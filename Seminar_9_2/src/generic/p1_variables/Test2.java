package generic.p1_variables;

public class Test2 {
    public static void main(String[] args) {
        Variable<? extends Number> variable1 = new Variable<>(7);
        Number value = variable1.getValue();
        Integer integer = (Integer) variable1.getValue();
        System.out.println(value);
        System.out.println(integer);

        Variable<? super Integer> variable2 = new Variable<>(5);
        Comparable<Integer> comparable = new Comparable<Integer>() {
            @Override
            public int compareTo(Integer o) {
                return 0;
            }
        };
        variable2.setValue(3);
//        variable2.setValue(comparable);
//        variable2.setValue(value);
        variable2.setValue(integer);

        Variable<Number> numberVariable = new Variable<>();
        Variable<Comparable<Integer>> comparableVariable = new Variable<>();
        Variable<Object> objectVariable = new Variable<>();
        numberVariable.setValue(3);
        comparableVariable.setValue(4);
        objectVariable.setValue(5);
    }
}
