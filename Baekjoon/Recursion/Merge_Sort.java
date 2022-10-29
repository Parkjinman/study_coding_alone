package Baekjoon.Recursion;

import java.io.*;
import java.util.StringTokenizer;

public class Merge_Sort {

    private static int[] sorted;		// 합치는 과정에서 정렬하여 원소를 담을 임시배열
    static int cnt = 0;
    static int K = 0;
    static int resultNum = 0;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*원소를반으로나누는함수*/
        merge_sort(arr);

        /** 출력 */
        if(K <= cnt) {
            bw.write(String.valueOf(resultNum));
        } else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
    }
    public static void merge_sort(int[] a) {

        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    // Top-Down 방식 구현
    private static void merge_sort(int[] a, int left, int right) {

        /*
         *  left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우
         *  더이상 쪼갤 수 없으므로 return한다.
         */
        if(left == right) return;

        int mid = (left + right) / 2;	// 절반 위치

        merge_sort(a, left, mid);		// 절반 중 왼쪽 부분리스트(left ~ mid)
        merge_sort(a, mid + 1, right);	// 절반 중 오른쪽 부분리스트(mid+1 ~ right)

        merge(a, left, mid, right);		// 병합작업

    }

    /**
     * 합칠 부분리스트는 a배열의 left ~ right 까지이다.
     *
     * @param a		정렬할 배열
     * @param left	배열의 시작점
     * @param mid	배열의 중간점
     * @param right	배열의 끝 점
     */
    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;		// 왼쪽 부분리스트 시작점
        int r = mid + 1;	// 오른쪽 부분리스트의 시작점
        int idx = left;		// 채워넣을 배열의 인덱스


        while(l <= mid && r <= right) {
            /*
             *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
             */
            if(a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            /*
             *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
             *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
             */
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if(l > mid) {
            while(r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        /*
         * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
         * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
         * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        else {
            while(l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        /*
         * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
         */
        for(int i = left; i <= right; i++) {
            cnt++;
            a[i] = sorted[i];
            if(cnt == K) resultNum = sorted[i];
        }
    }
}

/*
import java.io.*;
import java.util.StringTokenizer;

public class Merge_Sort{

    static int cnt = 0;
    static int K = 0;
    static int resultNum = 0;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        */
/*원소를반으로나누는함수*//*

        mergeSortDevide(arr,0,arr.length-1);

        */
/** 출력 *//*

        if(K <= cnt) {
            bw.write(String.valueOf(resultNum));
        } else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
    }
    private static void mergeSortDevide(int[] arr, int left, int right){
        */
/*원소의수가2개이상일경우실행*//*

        if(left<right){
            */
/*반으로나누기위한변수*//*

            int mid=(left+right)/2;
            */
/*앞(왼쪽)부분재귀호출*//*

            mergeSortDevide(arr,left,mid);
            */
/*뒤(오른쪽)부분재귀호출*//*

            mergeSortDevide(arr,mid+1,right);
            */
/*원소를Merge하는함수*//*

            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[]arr,int left,int mid,int right){
        int i=left;
        int j=mid+1;
        int temp_index=left;

        int[]temp = new int[arr.length];

        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[temp_index++]=arr[i++];
            }else{
                temp[temp_index++]=arr[j++];
            }
        }

        */
/*앞(왼쪽)부분배열에원소가남아있는경우*//*

        while(i<=mid){
            temp[temp_index++]=arr[i++];
        }

        */
/*뒤(오른쪽)부분배열에원소가남아있는경우*//*

        while(j<=right){
            temp[temp_index++]=arr[j++];
        }

        for(int index=left; index < temp_index; index++){
            cnt++;
            arr[index]=temp[index];
            if(cnt == K) resultNum = temp[index];
        }
    }

}*/
