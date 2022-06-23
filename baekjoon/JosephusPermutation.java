package baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*https://st-lab.tistory.com/197 참고한 코드*/
public class JosephusPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int N = in.nextInt();
        int K = in.nextInt();


        for(int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        /*
         *  마지막 부분의 출력은 > 괄호 전에 공백이 없기 때문에
         *  일괄적으로 출력하기 위해 마지막 원소만 남겨질 때까지만
         *  반복하고 마지막 원소는 그대로 출력한다.
         */
        while(q.size() > 1) {

            for(int i = 0; i < K - 1; i++) {
                int val = q.poll();
                q.offer(val);
            }

            sb.append(q.poll()).append(", ");
        }

        // 마지막 원소 출력한 뒤 > 도 붙여준다.
        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
}

/*내 코드*/
/*
public class JosephusPermutation {
        static Queue<Integer> queue = new LinkedList<>();
        static Queue<Integer> queueRm = new LinkedList<>();
        static ArrayList<Integer> list = new ArrayList<>();
        //    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
//    static HashMap<Integer, Integer> xMap = new HashMap<>();
//    static HashMap<String, Integer> yMap = new HashMap<>();
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public static void main (String[]args) throws IOException {
            Scanner scan = new Scanner(System.in);
            int N = scan.nextInt();
            int K = scan.nextInt();
            int temp = K;

            for (int i = 1; i <= N; i++) {
                list.add(i);
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                queue.add(list.get(K - 1));
                queueRm.add(K - 1);
                cnt++;

                for (int j = 0; j < temp; j++) {
                    if (K == list.size()) {
                        for (int k = 0; k < cnt; k++) {
                            list.remove(queueRm.poll() - k);
                        }
                        K = 1;
                        cnt = 0;
                    } else {
                        K++;
                    }
                }
            }

            String result = "<";
            while (!queue.isEmpty()) {
                result += queue.poll();
                if (!queue.isEmpty()) result += ", ";
            }
            result += ">";
            System.out.println(result);
        }
    }
}*/
