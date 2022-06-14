package level2.me;

public class StringCompression {
    static int solution(String s) {
        int answer = 0;
        int unitLen = s.length()/2;
        String temp = "";

        for(int i=0; i<unitLen  ; i++) {
            s.replace(s.substring(0, i), "");

            if(s.contains(s.substring(0, i))) {
                temp += s;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        String s = "aabbaccc"; //7
        String s = "aabbaabb"; //7
//        String s = "ababcdcdababcdcd"; //9
//        String s = "abcabcdede"; //8
//        String s = "abcabcabcabcdededededede"; //14
//        String s = "abcabcabcabc"; //4
//        String s = "xababcdcdababcdcd"; //17

        System.out.println(solution(s));
    }
}
