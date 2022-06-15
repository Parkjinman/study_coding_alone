package programers.level1.me;

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

    public static void main(String[] args) {
//        System.out.println(solution(numbers));
    }
}
