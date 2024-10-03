package inflearn.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * nums = {4, 9, 7, 5, 1} 에서 두 수를 더해서 12가 될 수 있나요? (중복 불가)
 */
public class twoSum {
    static int[] nums = {4, 9, 7, 5, 1};
    static Stack<Integer> current = new Stack();
    static int target = 12;
    static List<List<Integer>> answer = new Stack<>();
    static List<Integer> temp = new ArrayList<>();
    static Boolean isTrue = false;

    public static void main(String[] args) {
        twoSum(0, current);

        System.out.println(answer);
        System.out.println(answer.size());
        System.out.println(isTrue);
        System.out.println(temp);
    }

    private static void twoSum(int start, Stack<Integer> current) {
        if (isTrue) {
            return;
        }

        if (current.size() == 3) {
            answer.add(new ArrayList<>(current));
            temp = new ArrayList<>(current);
            int sum = 0;

            for (int i = 0; i < temp.size(); i++) {
                sum += temp.get(i);
            }

            if (sum == target) {
                isTrue = true;
                return;
            }

            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (!current.contains(nums[i])) {
                current.add(nums[i]);
                twoSum(i+1, current);
                current.pop();
            }
        }
    }

}