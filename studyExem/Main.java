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

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringBuilder str = new StringBuilder();

//    static int[][] positionArr = null;
    static ArrayDeque<String> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            try {
                String P = br.readLine();
                int N = Integer.parseInt(br.readLine());
                String str = br.readLine();

                String[] arrStr = str.split("[^0-9]");

                for (String s : arrStr) {
                    if (!s.equals(""))
                        deque.addLast(s);
                }
                int dSize = deque.size();

                String[] arrP = P.split("");
                for (String s : arrP) {
                    switch (s) {
                        case "R":
//                            Collections.reverse(deque);
                            String[] dqArr = new String[dSize];
                            for(int i=0; i<dSize; i++) {
                                dqArr[i] = deque.removeLast();
                            }

                            for(int i=0; i<dSize; i++) {
                                deque.addLast(dqArr[i]);
                            }

                            break;
                        case "D":
                            deque.removeFirst();
                            break;
                    }
                }

                System.out.println(deque);
                deque.clear();
            } catch (Exception e) {
                System.out.println("error");
            }
        }
        br.close();
    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }