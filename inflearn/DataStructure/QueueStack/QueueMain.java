package inflearn.DataStructure.QueueStack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.add(4);

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
