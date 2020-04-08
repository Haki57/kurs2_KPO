package behavioral.b7_state.sample1;

public class StateB implements State {

    private int count = 0;

    public void writeName(StateContext stateContext, String name){
        System.out.println(name.toUpperCase());
        if( ++count > 1) {
            stateContext.setState(new StateA());
        }
    }

}