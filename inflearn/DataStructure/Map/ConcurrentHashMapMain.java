package inflearn.DataStructure.Map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapMain {
    public static void main(String args[]) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1, 2);
        concurrentHashMap.put(2, 1);
        concurrentHashMap.put(3, 3);
        concurrentHashMap.put(5, 5);
        concurrentHashMap.put(4, 4);

        System.out.println(concurrentHashMap);
        System.out.println(concurrentHashMap.remove(5));
        System.out.println(concurrentHashMap.get(1));
        System.out.println(concurrentHashMap.get(6));
    }
}
