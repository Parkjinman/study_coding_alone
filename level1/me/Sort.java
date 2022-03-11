package level1.me;

import java.util.*;

public class Sort {

    //완주하지 못한 선수
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String str : completion) {
            map.put(str, map.getOrDefault(str, 0) +1);
        }

        for(String str : participant) {
            if(map.get(str) != null && map.get(str) == 1) map.remove(str);
            else if(map.get(str) != null && map.get(str) > 1) map.put(str, map.getOrDefault(str, map.get(str))-1);
            else if(map.get(str) == null) return str;
        }

        return answer;
    }

    //K번째수
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int count = 0;

        for(int j=0; j<commands.length; j++) {
            int first = commands[j][0] - 1;  // 여기부터
            int second = commands[j][1] - 1; // 여기까지 자름
            int third = commands[j][2] - 1; // 여기까지 자름

            int[] emp = new int[commands[j][1] - commands[j][0]+1]; //자른 값을 담을 배열
            int cnt = 0;
            //문자열 자르기
            for(int i=first; i<=second; i++) {
                emp[cnt] = array[i];
                cnt++;
            }

            //정렬
            Arrays.sort(emp);

            //answer에 commands자른 값에 k번째 수 담기
            answer[count] = emp[third];
            count++;
        }

        return answer;
    }

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
