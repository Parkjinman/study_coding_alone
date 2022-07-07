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
        int positionCp = 0;
        int result = 0;
        int n = N/2;

        for(int i=0; i<N; i++) {
            deque.addLast(i+1);
        }

        while(M --> 0) {
            position = scan.nextInt();

            Iterator<Integer> iterator = deque.iterator();
            int i=1;
            while(iterator.hasNext()) {
                if(iterator.next() == position) positionCp = iterator.next();
                i++;
            }

            while(position != deque.getFirst()) {
                //왼쪽
                if(positionCp < n) deque.addLast(deque.removeFirst());
                //오른쪽
                else deque.addFirst(deque.removeLast());

                result++;
            }

            if(position == deque.getFirst()) {
                deque.removeFirst();
            }
        }

        System.out.println(deque.getClass());
        System.out.println(result);
    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }