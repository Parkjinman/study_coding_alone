package studyExem;

import java.io.IOException;
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

    static int solution(int num, int five, int three) {
        if(num == 0) return five+three;
        else if(num < 0) return -1;

        if( (num%5 == 3 || num%5 == 0) && num%5 != 4 && num%5 != 1) {
            num -= 5;
            five++;
        } else if(num%3 == 0) {
            num -= 3;
            three++;
        }

        return solution(num, five, three);
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int bagCnt = scan.nextInt();
        int five = 0;
        int three = 0;

        System.out.println(solution(bagCnt, five, three));
    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }