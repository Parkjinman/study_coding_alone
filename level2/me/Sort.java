package level2.me;

import java.util.Arrays;
import java.util.HashMap;

public class Sort {

    //가장 큰 수
//    static int[] numbers = {6, 10, 2};
//    static int[] numbers = {3, 30, 34, 5, 9};
    static int[] numbers = {0, 0, 0, 0, 0};
    /*public static StringBuilder solution(int[] numbers) {
        int numbersLen = numbers.length;
        String[] strs = new String[numbersLen];

        StringBuilder stringBuilder = new StringBuilder();

        boolean se = true;
        for(int i=0; i<numbersLen; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }

//        Arrays.sort(strs, Collections.reverseOrder());
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(!strs[0].equals("0")) {
            stringBuilder.append(Arrays.toString(strs).replaceAll("[^0-9]", ""));
        } else {
            stringBuilder.append("0");
        }

        return stringBuilder;
    }*/

//    H-index
    static int[] citations = {3, 0, 6, 1, 5};
//    static int[] citations = {1, 1, 1, 2, 2};
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++) {
            int h = citations.length - i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(numbers));
//        solution(citations);
        System.out.println(solution(citations));
    }
}
