package level2.me;

import java.util.ArrayList;

public class FibonacciNumber {

    static int solution(int n) {
        int answer = 0;

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);

        for(int i=2; i<n; i++) {
            arrayList.add(arrayList.get(i-2)+arrayList.get(i-1));
        }
        answer = arrayList.get(arrayList.size()-1) + arrayList.get(arrayList.size()-2);

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(3)); // result : 2
//        System.out.println(solution(5)); // result : 5
//        System.out.println(solution(6)); // result : 8
//        System.out.println(solution(7)); // result : 13
        System.out.println(solution(47)); // result : 13


    }
}
