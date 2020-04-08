package behavioral.b7_state.sample1;

public class StateContext {

    private State myState;

    public StateContext() {
        setState(new StateA());
    }

    public void setState(State stateName) {
        myState = stateName;
    }

    public void writeName(String name) {
        myState.writeName(this, name);
    }
}
