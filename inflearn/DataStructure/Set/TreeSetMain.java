package inflearn.DataStructure.Set;

import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String args[]) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(4);

        System.out.println(treeSet);
        System.out.println(treeSet.contains(1));
        System.out.println(treeSet.contains(6));
    }
}
