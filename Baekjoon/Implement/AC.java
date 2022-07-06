package Baekjoon.Implement;

import java.util.ArrayDeque;

public class AC {

    public static void main(String[] args) {
        System.out.println("Stack!!");
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.addFirst("Element1");
        stack.addFirst("Element2");
        stack.addFirst("Element3");
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());

        System.out.println("Queue!!");
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addFirst("Element1");
        queue.addFirst("Element2");
        queue.addFirst("Element3");
        System.out.println(queue.removeLast());
        System.out.println(queue.removeLast());
        System.out.println(queue.removeLast());
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
