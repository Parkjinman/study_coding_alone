package inflearn.DataStructure.Map;

import java.util.LinkedHashMap;

public class LinkedHashMapMain {
    public static void main(String args[]) {
         LinkedHashMap linkedHashMap = new LinkedHashMap();
         linkedHashMap.put(1, 2);
         linkedHashMap.put(2, 1);
         linkedHashMap.put(3, 3);
         linkedHashMap.put(5, 5);
         linkedHashMap.put(4, 4);

         System.out.println(linkedHashMap);
         System.out.println(linkedHashMap.remove(5));
         System.out.println(linkedHashMap.get(1));
         System.out.println(linkedHashMap.get(6));
    }
}
