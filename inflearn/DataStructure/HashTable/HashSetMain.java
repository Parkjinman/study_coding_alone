package inflearn.DataStructure.HashTable;

import java.util.HashSet;

public class HashSetMain {
    public static void main(String args[]) {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(4);

        System.out.println(hashSet);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(6));
    }
}
