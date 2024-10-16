package inflearn.algorithm.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private Stack<Integer> stackMain = new Stack<>();
    private Stack<Integer> stackIndex = new Stack<>();

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!stackMain.isEmpty()) {
                if (stackMain.peek() >= temperatures[i]) {
                    break;
                }

                int peekIndex = stackIndex.pop();
                result[peekIndex] = i - peekIndex;
                stackMain.pop();
            }

            stackIndex.push(i);
            stackMain.push(temperatures[i]);
        }

        return result;
    }
//    [73,74,75,71,69,72,76,73]
//    [1,1,4,2,1,1,0,0]
}
