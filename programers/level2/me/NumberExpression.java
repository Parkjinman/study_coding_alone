package programers.level2.me;

public class NumberExpression {
    static int solution(int n) {
        int answer = 0;
        int num = 0;
        int count = 0;

        for(int i=count; i<=n; i++) {
            num += i;
            if(num == n) {
                num = 0;
                count++;
                i = count;
                answer++;
            } else if(num > n) {
                num = 0;
                count++;
                i = count;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        // 1 + 2 + 3 + 4 + 5 = 15
        // 4 + 5 + 6 = 15
        // 7 + 8 = 15
        // 15 = 15
        // result : 4
    }
}
