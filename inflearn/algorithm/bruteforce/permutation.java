package inflearn.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Permutation - 순열 (순서를 고려한 조합)
 */
public class permutation {
    static int[] nums = {1, 2, 3, 4};
    static Stack<Integer> current = new Stack<>();
    static List<List<Integer>> answer = new Stack<>();
    static int count = 0;

    public static void main(String[] args) {
        permutation(current);

        System.out.println(answer);
        System.out.println(count);
    }

    /**
     * 재귀로 완전탐색 구현
     */
    private static void permutation(Stack<Integer> current) {
        if (current.size() == nums.length) {
            count ++;
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