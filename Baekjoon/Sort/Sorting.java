package Baekjoon.Sort;

import java.util.Scanner;

public class Sorting {
    static int[] tmp, arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        arr = new int[N];
        tmp = new int[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = scan.nextInt();
        }

        mergeSort(0, arr.length-1);

        for(int i=0; i<N; i++) {
            System.out.println(arr[i]);
        }
    }

    /** 병합 정렬 */
    public static void mergeSort(int start, int end) {
        if (start<end) {
            int mid = (start+end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p<=mid || q<=end) {
                if (q>end || (p<=mid && arr[p]<arr[q])) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            }

            for (int i=start;i<=end;i++) {
                arr[i]=tmp[i];
            }
        }
    }
}
