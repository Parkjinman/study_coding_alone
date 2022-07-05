package Baekjoon.Implement;

import java.io.IOException;
import java.util.*;

public class Statistics {
    static ArrayList<Integer> list = new ArrayList<>();
    static HashMap<Integer, Integer> xMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); // 테스트 케이스 수
        double N = T;
        int[] arr = new int[(int) N];
        double avg = 0;

        while(T --> 0) {
            int num = scan.nextInt();
            arr[T] += num;
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            avg += arr[i];

            if(xMap.get(arr[i]) != null) xMap.put(arr[i], xMap.get(arr[i])+1);
            else xMap.put(arr[i], 1);
        }


        //최빈값 구하기
        for(int num : xMap.keySet()) {
            if(xMap.get(num) == Collections.max(xMap.values())) list.add(num);
        }

        Collections.sort(list);

        System.out.println(Math.round(avg/N)); // 산술평균
        System.out.println(Math.round(arr[(int) (N/2)])); // 중앙값
        System.out.println(list.size() > 1 ? list.get(1) : list.get(0)); // 최빈값
        System.out.println(Math.abs(arr[0]-arr[(int) (N-1)])); // 범위
    }
}
