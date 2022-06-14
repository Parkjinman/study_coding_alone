package level2.me;

public class NQueen {
    static int solution(int n) {
        int answer = 0;
        int[] arr = {};

        for(int i=0; i<n; i++) {
            arr[i] = i;
        }

        // 체스판을 그린다.
        // start 퀸을 둔다.(반복할 시에는 퀸의 기존 위치(index)+1)
        // 퀸의 공격 사거리 모두 +1
        // 0인 곳의 퀸을 둔다.
        // n만큼 퀸을 모두 두었다면 count + 1
        // 반복한다.

        return answer;
    }

    public static void main(String[] args) {
//        int n = 1; //result : 1
//        int n = 2; //result : 0
//        int n = 3; //result : 0
        int n = 4; //result : 2
//        int n = 5; //result : 2

        System.out.println(solution(n));
    }
}
