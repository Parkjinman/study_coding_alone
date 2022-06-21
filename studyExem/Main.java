package studyExem;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
//    static ArrayList<int[]> list = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static HashMap<String, Integer> xMap = new HashMap<>();
//    static HashMap<String, Integer> yMap = new HashMap<>();
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        String inputData = scan.nextLine();
        String[] compare = new String[count];

        int k=0;
        for(int i=0; i<count; i++) {
            inputData = scan.nextLine();
            String[] arr = inputData.split(" ");

            compare[k] = arr[0];
            xMap.put(arr[0], Integer.valueOf(arr[1]));

            k++;
        }
        System.out.println(Arrays.toString(compare));
        System.out.println(xMap);
    }
}

//        while(true) {
//            String[] arr = br.readLine().split(" ");
//
//            if(!br.ready()) break;
//        }