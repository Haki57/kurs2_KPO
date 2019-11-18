package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeHashLinkedHashMapSample {
    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>();
//        treeMap.put(null, null); //TODO: uncomment and run...
        treeMap.put("Key", "Value");
//        treeMap.put(1, 2);
        System.out.println(treeMap.size());
        System.out.println(treeMap);

System.out.println();

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put("Key", "Value");
//        hashMap.put(1, 2);
        System.out.println(hashMap.size());
        System.out.print(hashMap);

        System.out.println();

    }
}
