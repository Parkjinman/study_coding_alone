package studyExem;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] result = null;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int temp = t-1;
        result = new int[t];

        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] resultArr = new int[n];

            for(int i=0; i<n; i++) {
                resultArr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<n; i++) {
                if(i+1 < n) {
                    for (int j = i + 1; j < n; j++) {
                        solution(resultArr[i], resultArr[j], temp-t);
                    }
                }
            }

            bw.write(result[temp-t] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void solution(int A, int B, int count) throws IOException {
        int temp = 0;

        if (A < B) {
            temp = B;
            B = A;
            A = temp;
        }

        int GCD = 0;
        while (true) {
            if (A % B == 0) {
                GCD = B;
                break;
            } else {
                temp = B;
                B = A % B;
                A = temp;
            }
        }

        result[count] += GCD;
    }
}

//3
//4 10 20 30 40
//3 7 5 12
//3 125 15 25