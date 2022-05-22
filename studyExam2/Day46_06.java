package studyExam2;

import java.util.Random;

//경마

class Horse {
    // 경주마 한 마리
    int H = 1;
}

class Racing {
    Random ran = new Random();
    Horse horse[][] = new Horse[5][20];
    int max = 20;

    int rank[] = new int[5];
    int total[] = new int[5];
    int n = 1;
    boolean run = true;



    void ready() {
        for (int i = 0; i < total.length; i++) {
            this.horse[i][0].H = 1;
        }
    }

    void ptint() {
        System.out.println("RACE>>>");
        for (int i = 0; i < horse.length; i++) {
            for (int j = 0; j < horse[i].length; j++) {
                if (this.horse[i][0].H == 1) {
                    System.out.print("말_");
                } else {
                    System.out.print("__");
                }
            }
            System.out.println();
        }

    }

    void jump() {
        boolean goal = false;
        for (int i = 0; i < total.length; i++) {
            if (total[i] < max - 1) {
                int jump = ran.nextInt(4);
                int xx = total[i] + jump;

                if (xx < max - 1) {
                    this.horse[i][total[i]].H = 0;
                    total[i] = xx;
                }
                // goal
                else {
                    // exception
                    if (goal) {
                        i--;
                        break;
                    } else {
                        this.horse[i][total[i]].H = 0;
                        total[i] = max - 1;
                        goal = true;
                        rank[i] = n;
                        n++;
                    }
                }
                this.horse[i][total[i]].H = 1;
            }

        }
    }

    void result() {
        for (int i = 0; i < rank.length; i++) {
            System.out.printf("horse no.%d %d등\n", i + 1, rank[i]);
        }
    }

    // 게임 구현
    void run() {

        // ready
        ready();

        while (run) {
            // print
            ptint();
            if (n > rank.length) {
                break;
            }

            // jump
            jump();

            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }
        }

        // result
        result();

    }
}

public class Day46_06 {
    public static void main(String[] args) {

        Racing game = new Racing();
        game.run();

    }

}
