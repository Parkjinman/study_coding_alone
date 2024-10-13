package inflearn.DataStructure.Set;

import java.util.LinkedHashSet;

public class LinkedHashSetMain {
    public static void main(String args[]) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(2);
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(5);
        linkedHashSet.add(4);

        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.contains(1));
        System.out.println(linkedHashSet.contains(6));
    }
}
