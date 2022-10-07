package studyExem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String inputData = scan.nextLine();
        String[] arr = inputData.split(" ");

        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        for(int i=1; i<=n+1; i++) {
            int[] pascal = new int[i];
            for(int j=0; j<i; j++) {

                if(i-1 == j || j == 0) {
                    pascal[j] = 1;
                } else {
                    pascal[j] = list.get(i-2)[j-1] + list.get(i-2)[j];
                }
            }
            list.add(pascal);
        }

        System.out.println(list.get(n)[k]);
    }
}