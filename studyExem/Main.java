package studyExem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> list = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
//    static HashMap<Integer, Integer> xMap = new HashMap<>();
//    static HashMap<String, Integer> yMap = new HashMap<>();
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int temp = K;

        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        for(int i=0; i<N; i++) {
            queue.add(list.get(K-1));
            for(int j=0; j<temp; j++) {
                if(K == queue.size()) K=1;
                else K++;
            }
        }

        System.out.println(queue);
    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }