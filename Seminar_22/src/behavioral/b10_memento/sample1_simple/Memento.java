package behavioral.b10_memento.sample1_simple;

public class Memento {

    private String state;

    public Memento(String stateToSave) {
        state = stateToSave;
    }

    public String getSavedState() {
        return state;
    }
}
