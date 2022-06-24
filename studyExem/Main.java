package studyExem;

import java.io.IOException;
import java.util.*;

public class Main {
//    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();
//    static ArrayList<Integer> list = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    static HashMap<Integer, Integer> xMap = new HashMap<>();
//    static HashMap<String, Integer> yMap = new HashMap<>();

//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); // 테스트 케이스 수
        int N = T;
        int[] arr = new int[N];
        int avg = 0;

        while(T --> 0) {
            int num = scan.nextInt();
            arr[T] += num;
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            avg += arr[i];

            if(xMap.get(arr[i]) != null) xMap.put(arr[i], xMap.get(arr[i])+1);
            else xMap.put(arr[i], 1);
        }

        System.out.println(avg/N); // 산술평균
        System.out.println(); // 중앙값
        System.out.println(xMap); // 최빈값
        System.out.println(Math.abs(arr[0]-arr[N-1])); // 범위
    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }