package instutTask_changwoo;

import java.util.HashMap;
import java.util.Scanner;

public class TestMain {
    static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    static String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    static int k = 2;
//    String[] id_list = {"con", "ryan"};
//    String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//    int k = 3;

    // 신고 결과 받기
    public static int[] solution(String[] id_list, String[] report, int k) {
        int idListLen = id_list.length;
        int[] answer = new int[idListLen];
        HashMap<String, Integer> reportChkCnt = new HashMap();

//        for(int i=0;) {
//
//        }

        // 신고당하면 카운트 +1

        // 같은 사람한테 신고를 당한 기록이 있으면 카운트 -1

        // k번 신고를 당하면 정지

        // 처리결과 메일을 받은 횟수 저장

        return answer;
    }

    public static void solution(int[][] map, int x, int y) {
        // 해당 위치에 폭탄이 있는 경우
        if (map[x][y] == 9) {
            map[x][y] = 2;

            if(y-1 >= 0) {
                if(map[x][y - 1] == 9) {
                    solution(map, x, y-1);
                } else {
                    map[x][y - 1] = 2;
                }
            }


            if(y+1 <= 4) {
                if(map[x][y + 1] == 9) {
                    solution(map, x, y+1);
                } else {
                    map[x][y + 1] = 2;
                }
            }


            if(x+1 <= 4) {
                if(map[x + 1][y] == 9) {
                    solution(map, x+1, y);
                } else {
                    map[x + 1][y] = 2;
                }
            }


            if(x-1 >= 0) {
                if(map[x - 1][y] == 9) {
                    solution(map, x-1, y);
                } else {
                    map[x - 1][y] = 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int map[][] = {
                {0, 0, 0, 0, 0},
                {0, 0, 4, 4, 0},
                {0, 0, 9, 9, 0},
                {4, 0, 0, 0, 0},
                {9, 0, 0, 0, 0}
        };

        int[][] bombs = {{2,2},
                         {4,0},
                         {2,3}}; // ①한 행당 누적된 폭탄 개수 ②{x,y} 설치순서대로 누적됨
        int x = 0;
        int y = 0;

        int n = 0;

        while (true) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 9) {
                        System.out.print("● ");
                    } else if (map[i][j] == 4) {
                        System.out.print("★ ");
                    } else if (map[i][j] == 2) {
                        System.out.print("0 ");
                    } else {
                        System.out.print("+ ");
                    }
                }
                System.out.println();
            }

            System.out.println("폭파(5): ");
            int btn = sc.nextInt();

            if(btn == 5) {
                System.out.println("BOMB!");
                if(n == 3) {
                    System.out.println("BOMB ZERO!");
                    break;
                }

                //터질 폭탄 세팅
                x = bombs[n][0];
                y = bombs[n][1];

                // 이미 터진 폭탄인 경우
                if(map[x][y] == 0) {
                    n++;
                    continue;
                }

                // 해당 위치에 폭탄이 있는 경우
                if (map[x][y] == 9) {
                    map[x][y] = 2;

                    if(y-1 >= 0) {
                        if(map[x][y - 1] == 9) {
                            solution(map, x, y-1);
                        } else {
                            map[x][y - 1] = 2;
                        }
                    }


                    if(y+1 <= 4) {
                        if(map[x][y + 1] == 9) {
                            solution(map, x, y+1);
                        } else {
                            map[x][y + 1] = 2;
                        }
                    }


                    if(x+1 <= 4) {
                        if(map[x + 1][y] == 9) {
                            solution(map, x+1, y);
                        } else {
                            map[x + 1][y] = 2;
                        }
                    }


                    if(x-1 >= 0) {
                        if(map[x - 1][y] == 9) {
                            solution(map, x-1, y);
                        } else {
                            map[x - 1][y] = 2;
                        }
                    }
                }

                n++;
            }
        } //while end

    }
}