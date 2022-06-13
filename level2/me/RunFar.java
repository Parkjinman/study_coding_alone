package level2.me;

public class RunFar {
    static long[] num = new long[2000];
    static long solution(int n) {
        num[0] = 1;
        num[1] = 1;

        for(int i=2; i<=n; i++) {
            num[i] = num[i-2]%1234567 + num[i-1]%1234567;
        }

        return num[n];
    }

    public static void main(String[] args) {
        int n = 10; //5
//        int n = 3; //3

        System.out.println(solution(n));
    }
}
