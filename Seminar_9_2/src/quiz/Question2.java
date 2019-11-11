package quiz;

import java.util.ArrayList;

class Fruit {}

class Apple extends Fruit {}

class Orange extends Fruit {}

public class Question2 {
    public static void main(String[] args) {
        ArrayList<Apple> aList = new ArrayList<>();
        aList.add(new Apple());

        ArrayList<Orange> oList = (ArrayList) aList; //bList is just unneeded variable...

        oList.add(new Orange());

        System.out.println(oList);
    }
}
