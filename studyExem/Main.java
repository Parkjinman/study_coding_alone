package studyExem;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

//    static HashMap<Character, Integer> map = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
//    static boolean[] primeAt = new boolean[1000001]; /*소수용 배열*/

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); //미래
        int B = Integer.parseInt(st.nextToken()); //정이가 사용
        int numOfDesits = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        // 10진수 변환
        int decimalNum = 0;
        for (int i = numOfDesits; i > 0; i--) {
            int num = Integer.parseInt(st.nextToken());
            decimalNum += num * Math.pow(A, i - 1);
        }

        if(decimalNum == 0){
            sb.append(0);
        }
        // B진수로 변환
        while(decimalNum != 0){
            list.add(decimalNum % B);
            decimalNum/=B;
        }
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();
    }
}