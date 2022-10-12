package studyExem;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static void solution(int A, int B) throws IOException {
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

        bw.write(GCD + "\n");
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(br.readLine());

            while(n --> 0) {
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                solution(A, B);
            }
        }

        bw.flush();
        bw.close();
    }
}