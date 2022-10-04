package studyExem;

import java.util.Iterator;
import java.util.LinkedList;

public class CodeExTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /*public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        while (iter.hasPrevious()) {
            System.out.print(iter.previous() + " ");
        }
    }*/
}
