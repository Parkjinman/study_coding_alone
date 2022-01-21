package level1.me;

public class ThinkingPower {

    //숫자 문자열과 영단어
    public int solution(String s) {
        String str = s;
        str = str.replaceAll("zero", "0");
        str = str.replaceAll("one", "1");
        str = str.replaceAll("two", "2");
        str = str.replaceAll("three", "3");
        str = str.replaceAll("four", "4");
        str = str.replaceAll("five", "5");
        str = str.replaceAll("six", "6");
        str = str.replaceAll("seven", "7");
        str = str.replaceAll("eight", "8");
        str = str.replaceAll("nine", "9");

        return Integer.parseInt(str);
    }

    //[카카오 인턴] 키패드 누르기
    public String solution(int[] numbers, String hand) {
        String answer = "";

        //각 손의 현재 좌표
        int[] LP = new int[2];
        int[] RP = new int[2];
        int[] now = new int[2];

        //키패드 전체
        int[][] numPosition = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {'*',0,'#'}};
        //오른손 및 왼손 위치
        int handLeft = '*';
        int handRight= '#';

        //각 엄지손가락이 현재눌러야할 번호까지의 거리
        int StreetL = 0;
        int StreetR = 0;



        for(int i=0; i<numbers.length; i++) {
            //왼손인 경우
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                handLeft = numbers[i];
                answer += "L";
                //오른손인 경우
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                handRight = numbers[i];
                answer += "R";
                //number값이 2,5,8,0 인 경우
            } else {
                for(int j=0; j<numPosition.length; j++) {
                    for(int k=0; k<numPosition[j].length; k++) {
                        //왼손의 현재위치
                        if(handLeft == numPosition[j][k]) {
                            LP[0] = j;
                            LP[1] = k;
                        }
                        //오른손의 현재위치
                        if(handRight == numPosition[j][k]) {
                            RP[0] = j;
                            RP[1] = k;
                        }
                        //눌러야할 번호
                        if(numbers[i] == numPosition[j][k]) {
                            now[0] = j;
                            now[1] = k;
                        }
                        //거리계산
                        StreetL = getPosition(LP, now);
                        StreetR = getPosition(RP, now);
                    }
                }

                if(StreetL > StreetR) {
                    handRight = numbers[i];
                    answer += "R";
                } else if(StreetL < StreetR) {
                    handLeft = numbers[i];
                    answer += "L";
                } else if(StreetL == StreetR) {
                    if(hand.equals("right")) {
                        handRight = numbers[i];
                        answer += "R";
                    } else {
                        handLeft = numbers[i];
                        answer += "L";
                    }
                }
            }
        }

        return answer;
    }
    public static int getPosition(int[] a, int[] b) {
        int sum = 0;

        for(int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i]-b[i]);
        }

        return sum;
    }

    //체육복
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length; //현재 전체 체육복을 가진 학생 수

        //체육복 2개인 학생이 1개 잃어버렸을 때
        for(int i=0; i<reserve.length; i++) {
            for(int j=0; j<lost.length; j++) {
                if(reserve[i] == lost[j]) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        //체육복 2개인 학생이 양옆학생에게 빌려주는 경우
        for(int i=0; i<reserve.length; i++) {
            for(int j=0; j<lost.length; j++) {
                if(Math.abs(reserve[i] - lost[j]) == 1) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    //실패율
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        answer = new int[N];

        int temp1 = 0;
        int temp2 = 0;
        int num = 1;
        int row = 0;
        int high = 0;
        int[] bi;
        bi = new int[N];

        while(true) {
            for(int i=1; i<stages.length+1; i++) {
                // row = 실패율의 분모를 구하기 위한 변수
                if(num <= stages[i-1]) {
                    row++;
                }
                // high = 실패율의 분자를 구하기 위한 변수
                if(num == stages[i-1]) {
                    high++;
                }
            }
            // ex) 사람들이 전부 4단계에 머물러있고 5단계의 실패율을 구한다고 할때 zero에러를 방지하기위해
            if(row == 0){
                bi[num-1] = 1;
                answer[num-1] = num;
                high = 0;
                num++;
                // 분자율 구하기(*200000을 한 이유는 int에는 소수점이 안들어가서), 변수들 초기화
            }else{
                bi[num-1] = (high*200000 / row);
                answer[num-1] = num;
                row = 0;
                high = 0;
                num++;
            }
            if(num>N) {
                break;
            }
        }
        for(int i=0; i<bi.length; i++) {
            for(int j=0; j<bi.length-1; j++) {
                if (bi[j] < bi[j+1]) {
                    // 2차원 배열로 하는 것보다 이게 더 효율적인것 같아서
                    // bi[]를 정렬해줌과 동시에 answer[]를 같이 정렬해줌
                    temp1 = bi[j];
                    bi[j] =bi[j+1];
                    bi[j+1] = temp1;
                    temp2 = answer[j];
                    answer[j] =answer[j+1];
                    answer[j+1] = temp2;
                }
            }
        }

        return answer;
    }
}
