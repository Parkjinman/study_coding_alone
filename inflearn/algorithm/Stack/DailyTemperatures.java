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

    private static Stack<Integer> stack = new Stack<>();

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        // teperatures 반복하여 스택에 담기
        for (int i = 0; i < temperatures.length; i++) {

            // 현재 기온이 push할 기온보다 크면 pop한다.
            int day = 0;
            while (!stack.isEmpty()) {
                if (stack.peek() >= temperatures[i]) {
                    break;
                }

                day ++;
                stack.pop();
                result[i-1] += day;
            }

            stack.push(temperatures[i]);
        }

        return result;
    }
//    [73,74,75,71,69,72,76,73]
//    [1,1,4,2,1,1,0,0]
    public int[] solve(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
