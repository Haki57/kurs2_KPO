package behavioral.b10_memento.sample1_simple;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private List<Object> savedStates = new ArrayList<Object>();

    public void addMemento(Object m) {
        savedStates.add(m);
    }
    public Object getMemento(int index) {
        return savedStates.get(index);
    }
}
