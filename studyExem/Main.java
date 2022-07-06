package studyExem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static ArrayDeque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int position = 0;

        while(M --> 0) {
            position = scan.nextInt();
            System.out.println(position);

            if(position == deque.getFirst()) {
                deque.removeFirst();
            } else {

                if(position/2 < N/2) ;
            }
        }

        while(N --> 0) {
            deque.addFirst(N+1);
        }

        System.out.println(deque);
    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }