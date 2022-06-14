package level2.me;

import java.util.ArrayList;

public class HowToLineUp {
    static int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        long temp = 1;

        for(int i=1; i<=n; i++) {
            arrayList.add(i);
            temp *= i;
        }

        k--;
        int i=0;

        while(n > 0) {
            temp/=n;

            answer[i++] = arrayList.get((int) (k / temp));
            arrayList.remove((int) (k / temp));

            k %= temp;
            n--;
        }

        return answer;
    }

    public static void main(String[] args) {
        // result : [3,1,2]
        int n = 3;
        int k = 5;

        System.out.println(solution(n, k));
    }
}
