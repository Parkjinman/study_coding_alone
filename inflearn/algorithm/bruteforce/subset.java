package inflearn.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class subset {
    static int[] nums = {1, 2, 3, 4};
    static Stack<Integer> current = new Stack<>();
    static List<List<Integer>> answer = new Stack<>();
    static int mixtureCount;

    public static void main(String[] args) {
        for (int i = 0; i <= nums.length; i++) {
            mixtureCount = i;
            current = new Stack<>();
            subset(0, current);
        }

        System.out.println(answer);
        System.out.println(answer.size());
    }

    private static void subset(int start, Stack<Integer> current) {

        if (current.size() == mixtureCount) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start+1; i <= nums.length; i++) {
            if (!current.contains(i)) {
                current.add(i);
                subset(i, current);
                current.pop();
            }
        }

    }
}
