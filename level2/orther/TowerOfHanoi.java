package level2.orther;

import java.util.*;

public class TowerOfHanoi {
    static ArrayList<int[]> arrayList = new ArrayList<>();
    static int[][] solution(int n) {
        hanoiTower(1, 2, 3, n);
        int[][] result = new int[arrayList.size()][2];
        for(int i = 0; i < arrayList.size(); i++) {
            result[i][0] = arrayList.get(i)[0];
            result[i][1] = arrayList.get(i)[1];
        }
        return result;
    }

    static void hanoiTower(int s, int v, int e, int n) {
        int[] move = {s, e};

        if(n == 1) arrayList.add(move);
        else {
            hanoiTower(s, e, v, n - 1);
            arrayList.add(move);
            hanoiTower(v, s, e, n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 2; // [ [1,2], [1,3], [2,3] ]

        System.out.println(Arrays.deepToString(solution(n)));
    }
}
