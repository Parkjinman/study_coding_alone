package inflearn.DataStructure.List;

import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(5);
        list.addFirst(4);
        list.removeLast();

        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.subList(1, 3));
    }
}
