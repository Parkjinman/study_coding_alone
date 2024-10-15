package inflearn.DataStructure.QueueStack;

import java.util.Stack;

public class StackMain {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();

        System.out.println(stack.isEmpty());
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);

        System.out.println(stack.get(0));
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack);
        System.out.println(stack.firstElement());
        System.out.println(stack.pop());
        System.out.println(stack.removeAll(stack));
        System.out.println(stack);
    }
}
