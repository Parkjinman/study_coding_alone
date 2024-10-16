package inflearn.algorithm.HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    private static HashMap<Integer, Integer> numsReader = new HashMap<>();

    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {100, 5, 200, 1, 3, 7};
        System.out.println(longestConsecutiveMap(nums));
    }

    private static int longestConsecutiveMap(int[] nums) {
         int result = 0;

         for (int i = 0; i < nums.length; i++) {
             numsReader.put(nums[i], -1);
         }

         for (int i = 0; i < nums.length; i++) {

             // 이전에 계산한 적이 있는지 체크
             if (!numsReader.containsKey(nums[i] - 1)) {
                 int count = 1;

                 // nums[i]의 연속된 수가 있다면 반복
                 while (numsReader.containsKey(nums[i] + count)) {
                     count ++;
                 }

                 result = Math.max(result, count);
             }

         }

         return result;
     }

//    private static int longestConsecutiveSort(int[] nums) {
//        int result = 0;
//        int count = 1;
//
//        // nlogn 정렬
//        Arrays.sort(nums);
//
//        System.out.println(Arrays.toString(nums));
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i-1]) {
//                continue;
//            }
//
//            if (nums[i] == nums[i-1] + 1) {
//                count ++;
//            } else {
//                result = Math.max(result, count);
//                count = 1;
//            }
//        }
//
//        return result;
//    }

}
