package DesingPattern.Behavioural;

/**
 *
 *
 * In State pattern a class behavior changes based on its state.
 * This type of design pattern comes under behavior pattern.
 *
 * In State pattern, we create objects which represent various states and a context
 * object whose behavior varies as its state object changes.
 *
 */

interface State {
    void doAction(Context context);
}

class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Start State");
        context.setState(this);
    }
}

class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Stop State");
        context.setState(this);
    }
}

class Context {
    State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

public class StatePattern {

    public static void main(String args[]) {
        StartState startState = new StartState();
        Context context = new Context();
        context.setState(startState);
        startState.doAction(context);
        StopState stopState = new StopState();
        context.setState(stopState);
        stopState.doAction(context);
    }
}
