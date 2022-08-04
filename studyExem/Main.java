package studyExem;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        int result = 0;

        String[][] chessBoard = new String[N][M];
        int[] compareArr = new int[(N-7)*(M-7)];
        scan.nextLine();

        // 체스판 입력받기
        for(int i=0; i<N; i++) {
            chessBoard[i] = scan.nextLine().split("");
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("B", "W");
        map.put("W", "B");

        boolean changeSe = false;
        int nC = 0;
        int mC = 0;
        int compareArrIdx = 0;

        while(true) {
            String strTemp = "";

            if(N-7 == nC) {
                nC = 0;
                mC++;
            }

            if(M-7 == mC) break;

            for (int i = nC; i < 8+nC; i++) {
                for (int j = mC; j < 8+mC; j++) {

                    if(strTemp.equals(chessBoard[i][j])) {
                        changeSe = true;
                    }
                    strTemp = chessBoard[i][j];

                    if(changeSe && i > nC) {
                        chessBoard[i][j] = map.get(chessBoard[i][j]);
                        compareArr[compareArrIdx]++;
                    }

                    System.out.print(chessBoard[i][j]);
                }
                System.out.println();
            }
            compareArrIdx++;
            nC++;
            System.out.println();
        }

//        System.out.println(Arrays.deepToString(compareArr));
        System.out.println(Arrays.toString(compareArr));
        System.out.println(result);
    }
}

//        10 13
//        BBBBBBBBWBWBW
//        BBBBBBBBBWBWB
//        BBBBBBBBWBWBW
//        BBBBBBBBBWBWB
//        BBBBBBBBWBWBW
//        BBBBBBBBBWBWB
//        BBBBBBBBWBWBW
//        BBBBBBBBBWBWB
//        WWWWWWWWWWBWB
//        WWWWWWWWWWBWB

//        BBBWBWBW 1
//        BBBBWBWB 2
//        BBBWBWBW 1
//        BBBBWBWB 2
//        BBBWBWBW 1
//        BBBBWBWB 2
//        BBBWBWBW 1
//        BBBBWBWB 2
