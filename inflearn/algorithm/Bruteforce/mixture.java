package inflearn.algorithm.Bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * nums = {1, 2, 3, 4} 에서 3개를 뽑는 조합을 구하시오.
 */
public class mixture {
    static int[] nums = {1, 2, 3, 4};
    static Stack<Integer> current = new Stack<>();
    static List<List<Integer>> answer = new Stack<>();
    static int mixtureCount = 3;

    public static void main(String[] args) {
        mixture(0, current);

        System.out.println(answer);
        System.out.println(answer.size());
    }

    private static void mixture(int start, Stack<Integer> current) {

        if (current.size() == mixtureCount) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start+1; i <= nums.length; i++) {
            if (!current.contains(i)) {
                current.add(i);
                mixture(i, current);
                current.pop();
            }
        }

    }
}
