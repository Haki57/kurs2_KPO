package quiz;

import java.util.ArrayList;
import java.util.List;

public class Question8 {
    public static void main(String[] args) {
//        List<? extends Apple> list1 = new ArrayList<Fruit>(); // list of Fruits is not a subtype of list<? extends Apple>...
        List<? extends Fruit> list2 = new ArrayList<Apple>(); // ok
        List<? super Apple> list3 = new ArrayList<Fruit>(); // ok
//        List<? super Fruit> list4 = new ArrayList<Apple>(); // ArrayList<Apple> is not a subtype of List <? super Fruit>...
        List<?> list5 = list2;
        List<?> list6 = list3;
        List list7 = list5;
        List<?> list8 = list7;
    }
}
