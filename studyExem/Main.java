package studyExem;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        /** 시간측정 start */
//        long beforeTime = System.currentTimeMillis();

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = scan.nextInt();
        }

        int result = 0;
        for(int i=N-1; i>0; i--) {
            if(K == 0) break;

            if(K - arr[i] >= 0) {
                K -= arr[i];
                result ++;
                i = N;
            }
        }

        System.out.println(result);

        /** 시간측정 end */
//        long afterTime = System.currentTimeMillis();
//        long secDiffTime = (afterTime - beforeTime)/1000;
//        System.out.println("시간차이(m) : "+secDiffTime);

    }
}
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

//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int A = Integer.parseInt(st.nextToken());

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }