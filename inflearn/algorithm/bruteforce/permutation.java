package inflearn.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * nums = {1, 2, 3, 4} 에서 순열을 구하시오.
 */
public class permutation {
    static int[] nums = {1, 2, 3, 4};
    static Stack<Integer> current = new Stack<>();
    static List<List<Integer>> answer = new Stack<>();

    public static void main(String[] args) {
        permutation(current);

        System.out.println(answer);
        System.out.println(answer.size());
    }

    /**
     * 재귀로 완전탐색 구현
     */
    private static void permutation(Stack<Integer> current) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                permutation(current);
                current.pop();
            }
        }
    }

}