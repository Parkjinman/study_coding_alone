package studyExem;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        String[] arr = N.split("");
        for(int i=0; i<arr.length; i++) {
            System.out.println((int)arr[i].charAt(0));
        }

//        while(true) {
//            if(N == 0) break;
//
//            sb.append(result[N % B]);
//            N /= B;
//        }
//
//        bw.write(String.valueOf(sb.reverse()));

        bw.flush();
        bw.close();
    }

    static void mapSetting() {
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 11);
        map.put('B', 25);
        map.put('B', 26);
        map.put('B', 27);
        map.put('B', 28);
        map.put('B', 29);
        map.put('B', 30);
        map.put('B', 31);
        map.put('B', 32);
        map.put('B', 33);
        map.put('B', 34);
        map.put('B', 35);
        map.put('B', 36);
    }
}