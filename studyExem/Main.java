package studyExem;

import java.io.IOException;
import java.util.*;

public class Main {
//    static Stack<Integer> stack = new Stack<>();
//    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> list = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

//    static HashMap<Integer, Integer> xMap = new HashMap<>();
//    static HashMap<String, Integer> yMap = new HashMap<>();

//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringBuilder str = new StringBuilder();

    static int[][] positionArr = null;
    public static void main(String[] args) throws IOException {
            Scanner scan = new Scanner(System.in);

            int T = scan.nextInt();

        while (T-- > 0) {
            try {
                String P = scan.next();
                int N = scan.nextInt();
                scan.nextLine();
                String str = scan.nextLine();

                str = str.replaceAll("\\[", "");
                str = str.replaceAll("\\]", "");
                String[] arrStr = str.split(",");

                for (String s : arrStr) {
                    list.add(Integer.parseInt(s));
                }

                String[] arrP = P.split("");
                for (String s : arrP) {
                    switch (s) {
                        case "R":
                            list.sort(Collections.reverseOrder());
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
    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }