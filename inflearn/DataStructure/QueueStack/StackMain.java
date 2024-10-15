package inflearn.DataStructure.QueueStack;

import java.util.Map;
import java.util.Stack;

public class StackMain {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Stack<Map<Integer, Integer>> stackMap = new Stack<>();

        stackMap.push(Map.of(1, 1));
        stackMap.push(Map.of(2, 1));
        stackMap.push(Map.of(3, 4));

        System.out.println(stackMap);
        System.out.println(stackMap.peek().get(3));
        System.out.println(stackMap.pop());
        System.out.println(stackMap.pop().get(2));

//        System.out.println(stack.isEmpty());
//        System.out.println(stack.peek());
//        stack.push(2);
//        stack.push(1);
//        stack.push(3);
//        stack.push(5);
//        stack.push(4);
//
//        System.out.println(stack.get(0));
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack);
//        System.out.println(stack.firstElement());
//        System.out.println(stack.pop());
//        System.out.println(stack.removeAll(stack));
//        System.out.println(stack);
    }
}
