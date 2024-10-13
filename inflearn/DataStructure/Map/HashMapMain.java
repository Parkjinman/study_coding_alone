package inflearn.DataStructure.Map;

import java.util.HashMap;

public class HashMapMain {
    public static void main(String args[]) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, 2);
        hashMap.put(2, 1);
        hashMap.put(3, 3);
        hashMap.put(5, 5);
        hashMap.put(4, 4);

        System.out.println(hashMap);
        System.out.println(hashMap.remove(5));
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(6));
    }
}
