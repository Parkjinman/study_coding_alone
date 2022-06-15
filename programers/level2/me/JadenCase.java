package programers.level2.me;

public class JadenCase {

    static String solution(String s) {
        String answer = "";

        String[] arr = s.split("\\s", -1);

        int cnt = 0;

        for(String str : arr) {
            cnt++;

            if(!str.equals("")) {
                answer += str.substring(0, 1).toUpperCase();
                answer += str.substring(1).toLowerCase();

                if(cnt != arr.length) answer += " "; else break;
            } else {
                if(cnt == arr.length) break; else answer += " ";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("people  unFollowed   me"));
        System.out.println(solution("3peoPle 2unFollowed  2me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution(" for  the   last    week     "));
    }
}
