package studyExem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] aStr;
    static int n;
    static int resultCnt;

    static void solution(int a, int b) {
        if(b+1 == n) return; // 끝까지 완전탐색했다면 종료

        for(int i = 0; i < n; i++) {
            if(i == a || i == b) continue; //합으로 선택된 두 수는 더할 수 없음

            int num = Integer.parseInt(aStr[a]) + Integer.parseInt(aStr[b]);
            int compareNum = Integer.parseInt(aStr[i]);

            if(num == compareNum) {
                resultCnt++;
            }
        }

        solution(a, b+1);
    }

    public static void main(String args[]) throws Exception {
        n = Integer.parseInt(br.readLine());
        aStr = br.readLine().split(" ");

        for(int i=0; i+1<n; i++) {
            solution(i, i+1);
        }

        System.out.println(resultCnt);
    }
}