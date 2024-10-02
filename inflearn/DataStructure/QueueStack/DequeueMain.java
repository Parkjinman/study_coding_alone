package inflearn.DataStructure.QueueStack;

import java.util.Deque;
import java.util.LinkedList;

public class DequeueMain {
    public static void main(String args[]) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(2);
        deque.add(1);
        deque.add(3);
        deque.add(5);
        deque.addFirst(4);
        deque.addLast(4);

        System.out.println(deque);
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque);
    }
}