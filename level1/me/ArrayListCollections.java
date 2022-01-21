package level1.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListCollections {

    //크레인 인형뽑기 게임
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        ArrayList<Integer> basket = new ArrayList<Integer>();
        for(int i=0;i<moves.length;i++){
            int selectLine = moves[i]-1;
            for(int j=0;j<board.length;j++){
                int selectDoll = board[j][selectLine];
                if(selectDoll == 0){
                    continue;
                } else {
                    if(basket.size() != 0 && basket.get(basket.size()-1) == selectDoll){
                        basket.remove(basket.size()-1);
                        answer = answer + 2;
                    } else {
                        basket.add(selectDoll);
                    }
                    board[j][selectLine] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    //모의고사
    public int[] solution_2(int[] answers) {
        int[] answer = null;
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        ArrayList<Integer> arr = new ArrayList<Integer>();

        //3명의 정답개수 구하기
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == first[i%first.length]) {
                cnt1++;
            }

            if(answers[i] == second[i%second.length]) {
                cnt2++;
            }

            if(answers[i] == third[i%third.length]) {
                cnt3++;
            }
        }

        //각각 정답맞춘 개수의 최대값 구하기
        int max = Math.max(Math.max(cnt1, cnt2),cnt3);

        //가장큰 개수가 여러명인지 확인하기
        if(max==cnt1) {
            arr.add(1);
        }

        if(max==cnt2) {
            arr.add(2);
        }

        if(max==cnt3) {
            arr.add(3);
        }

        //가장큰 개수 answer에 담기
        answer = new int[arr.size()];

        for(int i=0; i<answer.length;i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }

    //두 개 뽑아서 더하기
    public int[] solution(int[] numbers) {
        int[] answer;

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int res = 0;
                res = numbers[i]+numbers[j];

                if(!arr.contains(res)) {
                    arr.add(res);
                }
            }
        }

        answer = new int[arr.size()];

        for(int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        Arrays.sort(answer);


        return answer;
    }

    //최소직사각형
    public int solution(int[][] sizes) {
        int sizesLen = sizes.length;
        ArrayList<Integer> wArrayList = new ArrayList<>();
        ArrayList<Integer> hArrayList = new ArrayList<>();

        // 가로,세로 최대길이 구하기.
        for(int[] arr : sizes) {
            wArrayList.add(arr[0]);
            hArrayList.add(arr[1]);
        }

        Collections.sort(wArrayList);
        Collections.sort(hArrayList);

        // 가로, 세로중 가장 긴 길이 구하기.
        int wMax = wArrayList.get(sizesLen-1);
        int hMax = hArrayList.get(0);

        for(int i=0; i<sizesLen; i++) {
            int wCompare = Math.max(sizes[i][0], sizes[i][1]);
            int hCompare = Math.min(sizes[i][0], sizes[i][1]);

            wMax = Math.max(wMax, wCompare);
            hMax = Math.max(hMax, hCompare);
        }

        return wMax*hMax;
    }
}
