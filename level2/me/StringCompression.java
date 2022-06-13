package level2.me;

public class StringCompression {
    static int solution(String s) {
        String str = "";

        for(int i=2; i<=s.length(); i++) {
            if(s.split(s.substring(0,s.length()/i)).length == 0) {
                str = i+s.substring(0,s.length()/i);
            }
        }

        return str.length();
    }

    public static void main(String[] args) {
        String s = "aabbaccc"; //7
//        String s = "ababcdcdababcdcd"; //9
//        String s = "abcabcdede"; //8
//        String s = "abcabcabcabcdededededede"; //14
//        String s = "abcabcabcabc"; //4
//        String s = "xababcdcdababcdcd"; //17

        System.out.println(solution(s));
    }
}
