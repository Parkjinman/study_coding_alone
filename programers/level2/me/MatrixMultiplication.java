package programers.level2.me;

import java.util.Arrays;

public class MatrixMultiplication {

    static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int k=0; k < arr1.length; k++) {
            for (int i = 0; i < arr2[0].length; i++) {
                int num = 0;

                for (int j = 0; j < arr2.length; j++) {
                    num += arr1[k][j] * arr2[j][i];
                }

                answer[k][i] = num;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        //result : {{15, 15}, {15, 15}, {15, 15}}
//        int[][] arr1 = {{1, 4},{3, 2},{4, 1}};
//        int[][] arr2 = {{3, 3},{3, 3}};
        
        //result : {{22, 22, 11}, {36, 28, 18}, {29, 20, 14}}
//        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        //result : {{21, 24, 27}, {47, 54, 61}}
        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{5, 6, 7}, {8, 9, 10}};

        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

}
