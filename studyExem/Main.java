package studyExem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
//    static Stack<Integer> stack = new Stack<>();
//    static Queue<Integer> queue = new LinkedList<>();
//    static ArrayList<Integer> list = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

//    static HashMap<Integer, Integer> xMap = new HashMap<>();
//    static HashMap<String, Integer> yMap = new HashMap<>();

//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringBuilder sb = new StringBuilder();

//    static int[][] positionArr = null;
//    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static int zero = 0;
    static int one = 0;

    static int fibonacci(int n) {
        if(n==0) {
            zero++;
            return 0;
        } else if(n==1) {
            one++;
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    public static void main(String[] args) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int A = Integer.parseInt(st.nextToken());

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        // 성능을 향상시키려면 DP의 메모제이션을 활용한 설계 개선 필요
        while(T-->0) {
            int N = scan.nextInt();
            zero = 0;
            one = 0;

            fibonacci(N);
            System.out.println(zero+" "+one);
        }


    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }