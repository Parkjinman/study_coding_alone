package Baekjoon.Implement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class WordStudy {
    static HashMap<Integer, String> map = new HashMap<>();
    static HashMap<String, Boolean> chkMap = new HashMap<>();
    static void DP(String[] arr, String str) {
        int cnt = 0;

        for(int i=0; i<arr.length; i++) {
            if(str.equals(arr[i])) cnt++;
        }

        if( map.get(cnt) != null ) map.put(cnt, "?");
        else map.put(cnt, str);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputData = scan.nextLine().toUpperCase();

        String[] arr = inputData.split("");

        for(int i=0; i<arr.length; i++) {
            if(chkMap.get(arr[i]) == null) DP(arr, arr[i]);
            chkMap.put(arr[i], true);
        }

        System.out.println(map.get(Collections.max(map.keySet())));
    }
}
