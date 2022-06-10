package level2.me;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMultiplication {

    static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2.length];
        ArrayList<Integer> arrayList = new ArrayList<>();

        int k=0;
        while (true) {

            for (int i = 0; i < arr1.length; i++) {
                int num = 0;

                for (int j = 0; j < arr2.length; j++) {
                    num += arr1[k][j] * arr2[j][i];
                }

                arrayList.add(num);
            }

            if (k == arr1.length - 1) break;
            k++;
        }

        k = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                answer[i][j] = arrayList.get(k);
                k++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        //result : {{15, 15}, {15, 15}, {15, 15}}
        int[][] arr1 = {{1, 4},{3, 2},{4, 1}};
        int[][] arr2 = {{3, 3},{3, 3}};
        
        //result : {{22, 22, 11}, {36, 28, 18}, {29, 20, 14}}
//        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

}
