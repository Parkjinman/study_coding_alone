package programers.level2.orther;

public class NumberCountries124 {
    static String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        while(n > 0){
            int remainder = n % 3;
            n /= 3;

            if(remainder == 0) n--;

            answer = numbers[remainder] + answer;
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println("1 : " + solution(1));  // 1
//        System.out.println("2 : " + solution(2));  // 2
//        System.out.println("3 : " + solution(3));  // 4
//        System.out.println("4 : " + solution(4));  // 11
//        System.out.println("5 : " + solution(5));  // 12
//        System.out.println("6 : " + solution(6));  // 14
//        System.out.println("7 : " + solution(7));  // 21
//        System.out.println("8 : " + solution(8));  // 22
//        System.out.println("9 : " + solution(9));  // 24
//        System.out.println("10 : " + solution(10));  // 41
//        System.out.println("11 : " + solution(11));  // 42
//        System.out.println("12 : " + solution(12));  // 44
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
//        System.out.println("13 : " + solution(13));  // 111
//        System.out.println("14 : " + solution(14));  // 112
//        System.out.println("15 : " + solution(15));  // 114
//        System.out.println("16 : " + solution(16));  // 121
//        System.out.println("17 : " + solution(17));  // 122
//        System.out.println("18 : " + solution(18));  // 124
//        System.out.println("19 : " + solution(19));  // 141
//        System.out.println("20 : " + solution(20));  // 142
//        System.out.println("21 : " + solution(21));  // 144
//        System.out.println("22 : " + solution(22));  // 211
//        System.out.println("23 : " + solution(23));  // 212
//        System.out.println("24 : " + solution(24));  // 214
//        System.out.println("25 : " + solution(25));  // 214
//        System.out.println("26 : " + solution(26));  // 214
//        System.out.println("27 : " + solution(27));  // 214
//        System.out.println("28 : " + solution(28));  // 214
//        System.out.println("29 : " + solution(29));  // 214
//        System.out.println("30 : " + solution(30));  // 214
//        System.out.println("31 : " + solution(31));  // 214
//        System.out.println("32 : " + solution(32));  // 214
//        System.out.println("33 : " + solution(33));  // 214
//        System.out.println("34 : " + solution(34));  // 214
        System.out.println("35 : " + solution(35));  // 422
        System.out.println("35 : " + solution(36));  // 422
    }
}
