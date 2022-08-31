package studyExem;

import java.util.LinkedList;
import java.util.ListIterator;

public class CodeExTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
            System.out.print(iter.next() + " ");
        }

//        while (iter.hasPrevious()) {
//            System.out.print(iter.previous() + " ");
//            iter.remove();
//            System.out.print(iter.previous() + " ");
//        }
    }
}
