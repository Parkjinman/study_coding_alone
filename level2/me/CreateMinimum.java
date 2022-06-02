package level2.me;

import java.util.Arrays;
import java.util.Collections;

public class CreateMinimum {
    /*효율성 떨어진 코드*/
    /*static int solution(int[] A, int[] B) {
        int answer = 0;

        Integer[] integerB = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(A);
        Arrays.sort(integerB, Collections.reverseOrder());

        for(int i=0; i<A.length; i++) {
            answer += A[i] * integerB[i];
        }

        return answer;
    }*/

    static int solution(int[] A, int[] B) {
        int answer = 0;
        int aLeng = A.length;
        int j = 1;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<aLeng; i++) {
            answer += A[i] * B[aLeng-j];

            j++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        int[] C = {1, 2};
        int[] D = {3, 4};

        System.out.println(solution(A, B));
//        System.out.println(solution(C, D));
    }
}
