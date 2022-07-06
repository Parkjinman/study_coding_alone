package Baekjoon.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class AC {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
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
                boolean dqSe = true;
                sb.append("[");

                String[] arrP = P.split("");
                for (String s : arrP) {
                    switch (s) {
                        case "R":
                            if(dqSe) dqSe = false;
                            else dqSe = true;

                            break;
                        case "D":
                            if(dqSe) deque.removeFirst();
                            else deque.removeLast();
                            break;
                    }
                }

                if(!dqSe) {
                    int dqSize = deque.size();
                    String[] dqArr = new String[dqSize];
                    for (int i = 0; i < dqSize; i++) {
                        dqArr[i] = deque.removeLast();
                    }

                    for (int i = 0; i < dqSize; i++) {
                        if(i == dqSize-1) sb.append(dqArr[i]);
                        else sb.append(dqArr[i]+",");
                    }
                } else {
                    while(!deque.isEmpty()) {
                        if(deque.size() != 1) sb.append(deque.removeFirst()+",");
                        else sb.append(deque.removeLast());
                    }
                }
                sb.append("]\n");

                System.out.print(sb);
                deque.clear();
                sb.setLength(0);
            } catch (Exception e) {
                sb.setLength(0);
                sb.append("error\n");
                System.out.print(sb);
                sb.setLength(0);
            }
        }
        br.close();
    }

    /*static ArrayList<Integer> list = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] positionArr = null;*/

    /*실패한 로직*/
    /*public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            try {
                String P = br.readLine();
                int N = Integer.parseInt(br.readLine());
                String str = br.readLine();

                String[] arrStr = str.split("[^0-9]");

                for (String s : arrStr) {
                    if (!s.equals(""))
                        list.add(Integer.parseInt(s));
                }

                String[] arrP = P.split("");
                for (String s : arrP) {
                    switch (s) {
                        case "R":
                            Collections.reverse(list);
                            break;
                        case "D":
                            list.remove(0);
                            break;
                    }
                }

                System.out.println(list);
                list.clear();
            } catch (Exception e) {
                System.out.println("error");
            }
        }
        br.close();
    }*/
}
