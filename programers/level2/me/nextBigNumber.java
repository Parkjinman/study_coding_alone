package programers.level2.me;

public class nextBigNumber {
    /** bitCount */
    static int solution(int n) {
        int num = Integer.bitCount(n);
        int compareNum = n+1;

        while(true) {
            if(num == Integer.bitCount(compareNum)) break;
            compareNum++;
        }

        return compareNum;
    }

    /** toCharArray */
    /*static int solution(int n) {
        String nBinary = Integer.toBinaryString(n);
        char[] strArr = nBinary.toCharArray();
        int oneCnt = 0;
        int compareOneCnt = 0;

        for(int i=0; i<strArr.length; i++) {
            if(strArr[i] == '1') oneCnt++;
        }

        int k=1;
        while(oneCnt != compareOneCnt) {
            nBinary = Integer.toBinaryString(n+k);
            strArr = nBinary.toCharArray();
            compareOneCnt=0;

            for(int i=0; i<strArr.length; i++) {
                if(strArr[i] == '1') compareOneCnt++;
            }

            k++;
        }

        return Integer.parseInt(nBinary, 2);
    }*/

    /** replace */
    /*static int solution(int n) {
        int answer = 0;
        String nBinary = Integer.toBinaryString(n);
        int oneCnt = nBinary.length()-nBinary.replace(String.valueOf("1"), "").length();
        int compareCnt = 0;

        int k=1;
        while(oneCnt != compareCnt) {
            nBinary = Integer.toBinaryString(n+k);
            compareCnt =  nBinary.length()-nBinary.replace(String.valueOf("1"), "").length();

            k++;
        }
        answer = Integer.parseInt(nBinary, 2);

        return answer;
    }*/

    public static void main(String[] args) {
        System.out.println(solution(78));
//        System.out.println(solution(83));
//        System.out.println(solution(15));
//        System.out.println(solution(23));
    }
}
