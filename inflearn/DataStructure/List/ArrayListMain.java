package inflearn.DataStructure.List;

import java.util.ArrayList;

public class ArrayListMain {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(4);

        list.remove(0);

        System.out.println(list);
        System.out.println(list.get(1));
    }
}
