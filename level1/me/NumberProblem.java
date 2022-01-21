package level1.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NumberProblem {

    //없는 숫자 더하기
    public int solution_5(int[] numbers) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : numbers) {
            map.put(i, 1);
        }

        for(int i=0; i<=9; i++) {
            if(map.get(i) == null) answer += i;
        }

        return answer;
    }

    //음양 더하기
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++) {
            if(signs[i]) answer += absolutes[i];
            else answer += absolutes[i]*-1;
        }

        return answer;
    }

    //내적
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i=0; i<a.length; i++) {
            answer += a[i]*b[i];
        }

        return answer;
    }

    //소수만들기
    public boolean primeNumberSe(int number) {
        if(number == 0 || number == 1) {
            return false;
        }

        for(int i=2; i<number; i++) {
            if(number % i ==0) {
                return false;
            }
        }

        return true;
    }
    public int solution_4(int[] nums) {
        int answer = 0;
        int numLength = nums.length;

        for(int i=0; i<numLength; i++) {
            for(int j=i+1; j<numLength; j++) {
                for(int k=j+1; k<numLength; k++) {
                    if(primeNumberSe(nums[i]+nums[j]+nums[k])) answer++;
                }
            }
        }

        return answer;
    }

    // 약수의 개수와 덧셈
    public int solution_3(int left, int right) {
        int answer = 0;

        //약수의 개수 구하기
        for(int i=left; i<=right; i++) {
            int measureCnt = getMeasure(i);
            answer += measureCnt % 2 == 0 ? i : i*-1;
        }

        return answer;
    }
    // 약수 구하기
    public int getMeasure(int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=1; i<=num; i++) {
            if(num%i == 0) arrayList.add(i);
        }

        return arrayList.size();
    }

    //3진법 뒤집기
    public int solution_7(int n) {
        int answer = 1;    // 결과 및 배열 길이
        int[] array;       // 3진수 담을 배열
        int remainder = 0; // 나머지
        int arrN = n;      // 배열을 길이를 구하기 위한 변수
        int power = 1;     // 거듭제곱 변수
        int arrLength;     // 배열을 담는 변수

        //n이 0미만이 될 때까지 반복한다.
        while(arrN > 0) {
            arrN = arrN/3;

            if(arrN > 0) {
                answer++; //answer변수는 임시로 배열 길이를 선언하기 위해 쓰였다.
            }
        }

        array = new int[answer];
        arrLength = array.length;

        //배열의 길이로 사용 후 초기화
        answer = 0;

        //10진수 → 3진수로 구하는 공식 그리고 구함과 동시에 거꾸로 배열에 담는다.
        for(int i=0; i<arrLength; i++) {
            if(n > 0) {
                array[i] = n%3;
            }

            n = n/3;
        }

        //거꾸로 뒤집은 배열을 그대로 10진수로 구하는 공식
        arrLength--;
        for(int i=0; i<array.length; i++) {

            //Math.pow(double) : 거듭제곱 구하는 함수 & Math.round : 반올림하는 함수
            power = Integer.parseInt(String.valueOf(Math.round(Math.pow(3, arrLength))));

            answer += array[i]*power;

            arrLength--;
        }

        return answer;
    }

    //예산
    public int solution_2(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int i=0; i<d.length; i++) {
            budget -= d[i];

            if(budget < 0) {
                break;
            }

            answer ++;
        }

        return answer;
    }

    //나머지가 1이 되는 수 찾기
    public int solution_6(int n) {
        int answer = 0;

        for(int i=1; i<n; i++) {
            if(n%i != 0 && n%i == 1) return i;
        }

        return answer;
    }

    //부족한 금액 게산하기.
    public long solution(int price, int money, int count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }

    //같은 숫자는 싫어
    public int[] solution_3(int []arr) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        int compare = -1;
        for(int i=0; i<arr.length; i++) {

            if(compare != arr[i]) {
                arrList.add(arr[i]);
            }

            compare = arr[i];
        }

        int[] answer = new int[arrList.size()];
        for(int i=0; i<arrList.size(); i++) {
            answer[i] = arrList.get(i);
        }

        return answer;
    }

    //나누어 떨어지는 숫자배열
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor == 0) {
                arrList.add(arr[i]);
            }
        }

        int[] answer = new int[arrList.size() == 0 ? 1 : arrList.size()];

        for (int i = 0; i < answer.length; i++) {
            if(arrList.size() != 0) {
                answer[i] = arrList.get(i);
            } else {
                answer[i] = -1;
            }
        }

        Arrays.sort(answer);

        return answer;
    }

    //두 정수 사이의 합
    public long solution_2(int a, int b) {
        long answer = 0;

        while(true) {
            answer += a;

            if (a != b) {
                if(a < b) {
                    a++;
                } else {
                    a--;
                }
            } else {
                break;
            }
        }

        return answer;
    }

    //소수찾기
    public int solution_5(int n) {
        int answer = 0;

        for(int i=2; i<n+1; i++) {
            if(test(i) == true) answer ++;
        }

        return answer;
    }
    public static boolean test(int num) {
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    //자릿수 더하기
    public int solution_4(int n) {
        int answer = 0;
        int calCL = 0;


        while(n != 0) {
            calCL = n%10;

            answer += calCL;

            n = myself(n);
        }


        return answer;
    }
    private static int myself(int n) {
        n = n/10;

        return n;
    }

    // 자연수 뒤집어 배열로 만들기
    public int[] solution_3(long n) {
        String leth = String.valueOf(n);
        int[] answer = new int[leth.length()];

        for(int i=0; i<answer.length; i++) {
            answer[i] = (int) (n % 10);
            n = n / 10;
        }

        return answer;
    }

    //정수 내림차순으로 배치하기.
    public long solution_2(long n) {
        String leth = String.valueOf(n);
        long answer = 0;
        long[] res = new long[leth.length()];

        for(int i=0; i<res.length; i++) {
            res[i] = n % 10;
            n = n/10;
        }

        Arrays.sort(res);

        leth = "";

        for(int i=res.length-1; i>=0; i--) {
            leth += res[i];
        }

        answer = Long.parseLong(leth);
        return answer;
    }

    //정수 제곱근 판별
    public long solution(long n) {
        long answer = 0;
        long emp = 0;

        answer = (long) Math.sqrt(n);
        emp = (long) Math.pow(answer, 2);

        if(emp == n) {
            if(n > 1 && answer == 1) {
                answer = -1;
            } else {
                answer ++;
                answer = (long) Math.pow(answer, 2);
            }
        } else {
            answer = -1;
        }

        return answer;
    }

    //제일 작은 수 제거하기
    public int[] solution_2(int[] arr) {
        int[] answer;
        if(arr.length == 1) {
            answer = new int[arr.length];

            answer[0] = -1;
        } else {
            answer = new int[arr.length-1];

            int min = arr[0];
            int minIndex = 0;
            ArrayList<Integer> array = new ArrayList<Integer>();

            for(int i=0; i<arr.length; i++) {
                if(min > arr[i]) {
                    min = arr[i];
                    minIndex = i;
                }
                array.add(arr[i]);
            }
            array.remove(minIndex);

            for(int i = 0; i<array.size(); i++) {
                answer[i] = array.get(i);
            }
        }

        return answer;
    }

    //짝수와 홀수
    public String solution_3(int num) {
        String answer = "";

        if(num%2 == 0) answer = "Even";
        else answer = "Odd";

        return answer;
    }

    //최대 공약수와 최소 공배수
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        //최대공약수
        for(int i=1; i < n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(n%i == 0 && m%j == 0 && i == j) {
                    answer[0] = i;
                }
            }
        }

        //최소공배수
        answer[1] = (n*m)/answer[0];

        return answer;
    }

    //콜라츠 추측
    public int solution_2(int num) {
        int answer = 0;

        while(num != 1) {
            if(num%2 == 0) {
                num = num / 2;
            } else if(num%2 == 1) {
                num = num * 3 + 1;
            }
            answer++;

            if(answer == 500) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

    //평균 구하기
    public double solution(int[] arr) {
        double answer = 0;
        int cnt = arr.length;

        for(int i=0; i < cnt; i++) {
            answer += arr[i];
        }

        answer = answer / cnt;

        return answer;
    }

    //하샤드 수
    public boolean solution(int x) {
        boolean answer = true;
        int xSub = x;
        int xTSub = x;
        int xResult = 0;
        int cnt = 0;

        while(xTSub > 0) {
            xSub = xTSub%10;
            xTSub = xTSub/10;

            xResult += xSub;
        }


        if(x%xResult == 0) answer = true;
        else answer = false;

        return answer;
    }

    //행렬의 덧셈
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for(int i=0; i < arr1.length; i++) {
            for(int j=0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }

}
