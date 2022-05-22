package studyExam2;

import java.util.Random;

//1개 게임만 당첨인 5개짜리 로또세트 완성

class Lotto {
    int mark;
}

class LottoSet {
    void fn_lotto(int i) {
        for (int j = 0; j < 7; j++) {
            this.lottoSet[i][j] = new Lotto();
            int r = ran.nextInt(2);

            if (r == 1) {
                this.lottoSet[i][j].mark = 3;
            } else {
                this.lottoSet[i][j].mark = 0;
            }
        }
    }

    Random ran = new Random();
    Lotto lottoSet[][] = new Lotto[5][7];

    void run() {

        int win = 0;
        for (int i = 0; i < 5; i++) {
            fn_lotto(i);

            int check = -1;
            int cnt = 0;
            for (int j = 0; j < 7; j++) {
                if (this.lottoSet[i][j].mark == 3) {
                    cnt += 1;
                } else {
                    cnt = 0;
                }
                if (cnt == 3) {
                    check = 1;
                }
            }

            if (check == 1 && win == 0) {
                win = 1;

            } else if (check == 1 && win == 1) {
                i -= 1;

            } else if (check == -1 && win == 0) {
                i -= 1;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(this.lottoSet[i][j].mark + " ");
            }
            System.out.println();
        }
    }
}

public class Day46_05 {
    public static void main(String[] args) {
        LottoSet game = new LottoSet();
        game.run();

    }
}