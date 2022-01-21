package level1.me;

import java.util.HashMap;

public class HashMapProblem {

    //로또의 최고 순위와 최저 순위
    public int matchesRank(int number) {
        if(number == 6) return 1;
        if(number == 5) return 2;
        if(number == 4) return 3;
        if(number == 3) return 4;
        if(number == 2) return 5;

        return 6;
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int zeroCnt = 0;

        //로또 번호 맵에 저장.
        for(int lotto : lottos) {
            map.put( lotto, map.getOrDefault(lotto, 0)+1 );
        }

        // 0이 아닌 숫자가 당첨번호에 몇개가 일치하는지 확인
        int winNumsCnt = 0;
        for(int num : win_nums) {
            if(map.get(num) != null && map.get(num) == 1) winNumsCnt++;
        }

        //지워진 번호 개수 확인
        if(map.get(0) != null) zeroCnt = map.get(0);

        //최고 순위 구하기
        int bestRank = 0;
        if(winNumsCnt < 6) bestRank = winNumsCnt + zeroCnt;
        else bestRank = winNumsCnt;
        answer[0] = matchesRank(bestRank);

        //최저 순위 구하기
        answer[1] = matchesRank(winNumsCnt);

        return answer;
    }

    //폰켓몬
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        //N/2 최대값 구하기
        int maxNum = nums.length/2;

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        if(map.size() > maxNum) answer = maxNum;
        else answer = map.size();

        return answer;
    }

}
