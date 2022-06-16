package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class GroupWordChecker {
    static HashMap<String, Integer> map = new HashMap<>();
    static int cnt = 0;
    static void chk(String[] arr) {
        boolean chk = true;

        for(int i=0; i<arr.length; i++) {
            if(map.get(arr[i]) == null) {
                map.put(arr[i], i);
            }
            else if(i-map.get(arr[i]) > 1){
                chk = false;
                break;
            }
            else {
                map.put(arr[i], i);
            }
        }

        if(chk) cnt++;

        map.clear();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputCnt = scan.nextInt();

        for(int i=0; i<inputCnt; i++) {
            String inputData = scan.next();
            String[] arr = inputData.split("");

            chk(arr);
        }

        System.out.println(cnt);
    }
}
