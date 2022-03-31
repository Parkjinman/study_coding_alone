package level2.me;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * 완전 탐색
 *
 * */
public class ExhaustiveSearch {
    //소수 찾기
//    static String numbers = "17";
    static String numbers = "011";
    public static int solution(String numbers) {
        int answer = 0;
        int number = Integer.parseInt(numbers);

        String[] strArr = numbers.split("|");
        HashMap<Integer, Integer> map = new HashMap<>();

        // 숫자 조합 만들기 ex) 1, 7, 17, 71
        for(int i=0; i<strArr.length; i++) {
            /*for() {
                map.put(Integer.parseInt(strArr[i] + strArr[i + 1]), i);
            }*/
            /*if(i > 0 && i < strArr.length-1) {
                map.put(Integer.parseInt(strArr[i] + strArr[i - 1]), i);
                map.put(Integer.parseInt(strArr[i] + strArr[i + 1]), i);
            } else {
                map.put(Integer.parseInt(strArr[i]), i);
                map.put(Integer.parseInt(strArr[0] + strArr[strArr.length-1] ), i);
                map.put(Integer.parseInt(strArr[strArr.length-1] + strArr[0] ), i);
            }*/
        }

        for(Entry<Integer, Integer> mapInt : map.entrySet()) {
            // 소수 찾기
            int count = 0;
            for(int j=1; j<=mapInt.getKey(); j++) {
                if( mapInt.getKey()%j == 0 ) count++;
            }
            if( count == 2 ) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(numbers));
    }
}