package level2.me;

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

    public static void main(String[] args) {
        System.out.println(solution(arr));
    }
}