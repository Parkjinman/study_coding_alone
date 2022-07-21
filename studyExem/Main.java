package studyExem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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

    public static void main(String[] args) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int A = Integer.parseInt(st.nextToken());

        HashMap map = new HashMap();
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        int[] arr = new int[T];
        int result = 0;

        for(int i=0; i<T; i++) {
            int red = scan.nextInt();
            int green = scan.nextInt();
            int blue = scan.nextInt();

            map.put(red, "red");
            map.put(green, "green");
            map.put(blue, "blue");

            if(i == 0) {
                arr[i] = Math.min(red, green);
                arr[i] = Math.min(arr[i], blue);
            }

            if(i-1 >= 0) {
                if (map.get(arr[i - 1]).equals("red")) {
                    arr[i] = Math.min(green, blue);
                } else if (map.get(arr[i - 1]).equals("green")) {
                    arr[i] = Math.min(red, blue);
                } else if (map.get(arr[i - 1]).equals("blue")) {
                    arr[i] = Math.min(red, green);
                }
            }

            result += arr[i];
        }

        System.out.println(result);

    }
}


//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }