package DesingPattern.Behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Takes Action on changes to the Subject
 * Examples are Listeners
 *
 * Too Many Notifications might be generated
 * Ripple effect
 *
 */
class Subject {
    List<Observer> list = new ArrayList<>();
    int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    private void notifyAllObserver() {

        for (Observer observer : list) {
            observer.update();
        }
    }

    public void attach(Observer observer) {
        this.list.add(observer);
    }
}

abstract class Observer {
    Subject subject;

    public abstract void update();
}

class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary >>" + Integer.toBinaryString(subject.getState()));
    }
}

class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex >>" + Integer.toHexString(subject.getState()));
    }
}

class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal >>" + Integer.toOctalString(subject.getState()));
    }
}

public class ObserverPattern {
    public static void main(String args[]) {
        Subject subject = new Subject();
        new OctalObserver(subject);
        new HexObserver(subject);
        new BinaryObserver(subject);
        subject.setState(34);

        subject.setState(74);

    }
}
