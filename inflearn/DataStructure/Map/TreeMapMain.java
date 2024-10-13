package inflearn.DataStructure.Map;

import java.util.TreeMap;

public class TreeMapMain {
    public static void main(String args[]) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(1, 2);
        treeMap.put(2, 1);
        treeMap.put(3, 3);
        treeMap.put(5, 5);
        treeMap.put(4, 4);

        System.out.println(treeMap);
        System.out.println(treeMap.remove(5));
        System.out.println(treeMap.get(1));
        System.out.println(treeMap.get(6));
    }
}
