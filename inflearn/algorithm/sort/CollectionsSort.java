package inflearn.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(5);

        Collections.sort(list);
        System.out.println(list);
    }

}
