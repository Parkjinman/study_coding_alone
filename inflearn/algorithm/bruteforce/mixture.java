package inflearn.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class mixture {
    static int[] nums = {1, 2, 3, 4};
    static Stack<Integer> current = new Stack<>();
    static List<List<Integer>> answer = new Stack<>();

    public static void main(String[] args) {
        mixture(current);

        System.out.println(answer);
        System.out.println(answer.size());
    }

    private static void mixture(Stack<Integer> current) {

        if (current.size() == 2) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (!current.isEmpty() && current.firstElement() > num) {
                continue;
            }
            if (!current.contains(num)) {
                current.add(num);
                mixture(current);
                current.pop();
            }
        }

    }
}