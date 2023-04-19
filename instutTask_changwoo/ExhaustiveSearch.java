package instutTask_changwoo;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * 완전 탐색
 *
 * */
public class ExhaustiveSearch {
    //소수 찾기
//    static String numbers = "17";
    static String numbers = "011";
    public static int solution(String numbers) {
        int answer = 0;
        int number = Integer.parseInt(numbers);

        String[] strArr = numbers.split("|");
        HashMap<Integer, Integer> map = new HashMap<>();

        // 숫자 조합 만들기 ex) 1, 7, 17, 71
        for(int i=0; i<strArr.length; i++) {
            /*for() {
                map.put(Integer.parseInt(strArr[i] + strArr[i + 1]), i);
            }*/
            /*if(i > 0 && i < strArr.length-1) {
                map.put(Integer.parseInt(strArr[i] + strArr[i - 1]), i);
                map.put(Integer.parseInt(strArr[i] + strArr[i + 1]), i);
            } else {
                map.put(Integer.parseInt(strArr[i]), i);
                map.put(Integer.parseInt(strArr[0] + strArr[strArr.length-1] ), i);
                map.put(Integer.parseInt(strArr[strArr.length-1] + strArr[0] ), i);
            }*/
        }

        for(Entry<Integer, Integer> mapInt : map.entrySet()) {
            // 소수 찾기
            int count = 0;
            for(int j=1; j<=mapInt.getKey(); j++) {
                if( mapInt.getKey()%j == 0 ) count++;
            }
            if( count == 2 ) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(numbers));

        Scanner sc = new Scanner(System.in);

        int map[][] = {
                {0, 0, 0, 0, 0},
                {0, 0, 4, 4, 0},
                {0, 0, 9, 9, 0},
                {4, 0, 0, 0, 0},
                {9, 0, 0, 0, 0}
        };

        int cnt = 3; // 설치된 폭탄 개수
        int bombs[][] = new int[5][2]; // {y,x} 설치순서대로 누적됨
        bombs[0][0] = 2;
        bombs[0][1] = 2;

        bombs[1][0] = 4;
        bombs[1][1] = 0;

        bombs[2][0] = 2;
        bombs[2][1] = 3;

        while (true) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 9) {
                        System.out.print("● ");
                    } else if (map[i][j] == 4) {
                        System.out.print("★ ");
                    } else {
                        System.out.print("+ ");
                    }
                }
                System.out.println();
            }

            // 한번 누르면 맨 앞(0인덱스) 에 있는 폭탄이 폭파
            // 폭탄 옆 폭탄 고려하기 (순서)
            // 폭탄은 폭파 시, 십자방향 1칸까지 도달함

//         + + + + +
//         + + ★ ★ +
//         + + ● ● +
//         ★ + + + +
//         ● + + + +

//         + + + + +
//         + + + + +
//         + + + + +
//         ★ + + + +
//         ● + + + +

//         + + + + +
//         + + + + +
//         + + + + +
//         + + + + +
//         + + + + +

            System.out.println("폭파(5): ");
            int btn = sc.nextInt();
            int n = 0;
            int x = bombs[n][0];
            int y = bombs[n][1];
            while (true) {
                x = bombs[n][0];
                y = bombs[n][1];
                if (map[x][y] != 9) {
                    n++;
                } else {
                    System.out.println("폭탄 제로");
                    break;
                }
            }
            if (btn == 5) {
                System.out.println("BOMB!");


                for (int i = -1; i <= 1; i++) {
                    int yy = y + i;
                    int xx = x + i;

                    if (xx >= 0 && xx < 5 && yy >= 0 && yy < 5) {
                        if (map[x][yy] == 4) {
                            map[x][yy] = 1;
                        }
                        if (map[xx][y] == 4) {
                            map[xx][y] = 1;
                        }
                        if (map[x][yy] == 9) {
                            for (int j = -1; j <= 1; j++) {
                                if (xx + j >= 0 && xx + j < 5 && yy + j >= 0 && yy + j < 5) {
                                    map[x][yy + j] = 0;
                                    map[x + j][yy] = 0;
                                }
                            }
                        }
                        if (map[xx][y] == 9) {
                            for (int j = -1; j <= 1; j++) {
                                if (xx + j >= 0 && xx + j < 5 && yy + j >= 0 && yy + j < 5) {
                                    map[xx + j][y] = 0;
                                    map[xx][y + j] = 0;
                                }
                            }
                        }

                        if (map[xx][y] != 1 || map[x][yy] != 1) {
                            map[x][yy] = 0;
                            map[xx][y] = 0;
                            n++;
                        }
                    }

                }

            }
        } //while end
    }
}