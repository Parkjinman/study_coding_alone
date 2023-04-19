package instutTask_changwoo;

import java.util.Random;

public class HrrGame {
    // # 경마 게임
    // 5마리의 말이 랜덤으로 한번에 일정거리 이동가능하다
    // 이동한거리의 합이 20이상이면 도착
    // 등수 출력
    // 조건) 단! 동시도착 예외처리

    public static void main(String[] args) throws InterruptedException {
        Random ran = new Random();

        int[][] horse = new int[5][20];
        int max = 20;

        int[] rank = new int[5];
        int[] total = new int[5];

        horse = new int[][]{
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                , {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                , {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                , {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                , {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        while( horse[0][19] != -1 ) {
            /** 말 이동거리(속력) 연산 */
            for (int i = 0; i < horse.length; i++) {
                int speed = ran.nextInt(3) + 1;

                for (int j = 0; j < horse[0].length; j++) {
                    if (horse[i][j] == -1) {
                        horse[i][j] = 0;

                        if (j + speed > 19) {
                            horse[i][19] = -1;
                            break;
                        } else {
                            horse[i][j + speed] = -1;
                            break;
                        }
                    }
                }
            }

            /** 현재 말 위치 */
            for (int k = 0; k < horse.length; k++) {
                String rctrck = "";

                for (int j = 0; j < horse[0].length; j++) {
                    if (horse[k][j] == -1) rctrck += "말";
                    else rctrck += "ㅡ";
                }

                System.out.println(rctrck);
            }

            System.out.println("==================구분선===================");

            Thread.sleep(1000);
        }
    }
}
