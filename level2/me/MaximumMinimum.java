package level2.me;

import java.util.Arrays;

public class MaximumMinimum {
    static String solution(String s) {
        String answer = "";

        String[] strArr = s.split(" ");
        Integer[] integers = new Integer[strArr.length];

        for(int i = 0; i<strArr.length; i++) {
            integers[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(integers);
        answer += integers[0] + " " + integers[strArr.length-1];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }
}
