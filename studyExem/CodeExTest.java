package studyExem;

import java.io.*;
import java.util.StringTokenizer;

public class CodeExTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int temp = 0;

        if(A < B) {
            temp = B;
            B = A;
            A = temp;
        }

        int GCF = 0;
        int GCM = A*B;
        while(true) {
            if(A % B == 0) {
                GCF = B;
                break;
            } else {
                temp = B;
                B = A % B;
                A = temp;
            }
        }
        GCM /= GCF;

        bw.write(GCF+"\n");
        bw.write(String.valueOf(GCM));

        bw.flush();
        bw.close();
    }
}