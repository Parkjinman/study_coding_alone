package level2.me;

import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {
    static ArrayList<int[]> arrayList = new ArrayList<>();
    static int[][] solution(int n) {
        hanoi(1,2,3, n);

        int[][] answer = new int[arrayList.size()][2];

        for(int i=0; i<arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    static void hanoi(int s, int v, int e, int n) {
        int[] move = {s, e};

        if(n == 1) arrayList.add(move);
        else {
            hanoi(s, e, v, n-1);
            arrayList.add(move);
            hanoi(v, s, e, n-1);
        }
    }

    public static void main(String[] args) {
        int n = 2; // [ [1,2], [1,3], [2,3] ]

        System.out.println(solution(n));
    }
}
