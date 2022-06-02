package level2.me;

public class nextBigNumber {
    static int solution(int n) {
        String nBinary = Integer.toBinaryString(n);
        String[] strArr = nBinary.split("");
        int oneCnt = 0;
        int compareOneCnt = 0;

        for(int i=0; i<strArr.length; i++) {
            if(strArr[i].equals("1")) oneCnt++;
        }

        int k=1;
        while(oneCnt != compareOneCnt) {
            nBinary = Integer.toBinaryString(n+k);
            strArr = nBinary.split("");
            compareOneCnt=0;

            for(int i=0; i<strArr.length; i++) {
                if(strArr[i].equals("1")) compareOneCnt++;
            }

            k++;
        }

        return Integer.parseInt(nBinary, 2);
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
//        System.out.println(solution(83));
//        System.out.println(solution(15));
//        System.out.println(solution(23));
    }
}
