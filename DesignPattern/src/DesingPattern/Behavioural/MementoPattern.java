package DesingPattern.Behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Saves or restores the state.
 * Preserves encapsulation
 * Simplify originator
 * Mostly is inner class
 *
 *
 * Might be expensive
 * Language must facilitate the only originator can access Momento
 * Extra management to Managing States of Momento
 *
 */
class Memento {
    String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void setStateFromMomento(Memento momento) {
        this.state = momento.state;
    }
}

class MementoCareTaker {
    List<Memento> list = new ArrayList<>();

    public void add(Memento momento) {
        list.add(momento);
    }

    public Memento get(int index){
        return list.get(index);
    }
}

public class MementoPattern {

    public static void main(String args[]) {
        Originator originator = new Originator();
        MementoCareTaker careTaker = new MementoCareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.setStateFromMomento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.setStateFromMomento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
