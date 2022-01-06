package level2;

import java.util.ArrayList;
import java.util.HashMap;

public class MathOperation {

    //N개의 최소공배수(나의 풀이)
    static int[] arr = {2,6,8,14};
    public static int solution(int[] arr) {
        int answer=1;
        ArrayList<HashMap<Integer,Integer>> arrayList = new ArrayList<>();

        for (int num : arr) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int i=2; i<=num; i++) {
                while (num%i == 0) {
                    hashMap.put(i, hashMap.getOrDefault(i, 0)+1);
                    num /= i;
                }
            }

            if(!arrayList.isEmpty()) {
                for(int key : hashMap.keySet()) {
                    if(arrayList.get(0).get(key) == null) arrayList.get(0).put(key, hashMap.get(key));

                    if(hashMap.get(key) > arrayList.get(0).get(key)) {
                        arrayList.get(0).put(key, hashMap.get(key));
                    }
                }
            } else {
                arrayList.add(hashMap);
            }
        }
        for(int key : arrayList.get(0).keySet()) {
            for(int i=0; i<arrayList.get(0).get(key); i++) {
                answer *= key;
            }
        }

        return answer;
    }

    //N개의 최소공배수(다른 사람 풀이)
    public static long nlcm(int[] num) {
        long answer = num[0],g;
        for(int i=1;i<num.length;i++){
            g=gcd(answer,num[i]);
            answer=g*(answer/g)*(num[i]/g);
        }
        return answer;
    }
    public static long gcd(long a,long b){
        if(a>b)
            return (a%b==0)? b:gcd(b,a%b);
        else
            return (b%a==0)? a:gcd(a,b%a);
    }

    public static void main(String[] args) {
        System.out.println(nlcm(arr));
    }
}