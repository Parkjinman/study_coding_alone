package level1.me;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringProblem {

    //부족한 금액 게산하기.
    public long solution(int price, int money, int count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }

    //[1차] 비밀지도
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            String binaryStr1 = Integer.toBinaryString(arr1[i]);
            String binaryStr2 = Integer.toBinaryString(arr2[i]);

            while(true){
                if(binaryStr2.length() > binaryStr1.length()) {
                    binaryStr1 = "0" + binaryStr1;
                }
                if(binaryStr1.length() > binaryStr2.length()) {
                    binaryStr2 = "0" + binaryStr2;
                }
                if(binaryStr2.length() == binaryStr1.length()) {
                    break;
                }
            }

            answer[i] = "";

            for(int j=0; j<binaryStr1.length(); j++) {
                if(binaryStr1.substring(j, j+1).equals("1") || binaryStr2.substring(j, j+1).equals("1")) {
                    answer[i] += "#";
                }else {
                    answer[i] += " ";
                }
            }
        }
        return answer;

    }

    //가운데 글자 가져오기
    public String solution_8(String s) {
        String answer = "";
        int leng = s.length(); //문자의 길이
        String[] arr = new String[leng]; // 배열의 크기

        //문자열을 하나하나 배열의 담기
        for(int i=0; i<leng; i++) {
            arr[i] = String.valueOf(s.charAt(i));
        }

        //문자열이 홀수인지 짝수인지 구분
        if(s.length()%2 == 1) {
            answer = arr[leng/2];
        } else {
            answer += arr[leng/2-1];
            answer += arr[leng/2];
        }

        return answer;
    }

    //다트게임
    public int solution_7(String dartResult) {
        int answer = 0;
        int gubun = 0;
        String res1 = dartResult;
        String res2 = "";
        String res3 = "";
        String res4 = "";
        String previous = "";
        String previous2 = "";
        int s = 0;
        int d = 0;
        int t = 0;

        for(int i=1; i<=res1.length(); i++) {
            res2 = res1.substring(i-1,i); //검사할 문자열
            if(isNumeric(res2)) { //숫자인지 판별
                res4 += res2;
                gubun = Integer.parseInt(res4); //숫자로 변환
            } else {
                res3 = res1.substring(0,i); //문자인 경우

                if(res3.contains("S")) {
                    s += (int) Math.pow(gubun, 1);
                } else if(res3.contains("D")) {
                    d += (int) Math.pow(gubun, 2);
                } else if(res3.contains("T")) {
                    t += (int) Math.pow(gubun, 3);
                } else if(res3.contains("*")) {
                    if(previous.contains("S")) {
                        s = s * 2;
                    } else if(previous.contains("D")) {
                        d = d * 2;
                    } else if(previous.contains("T")) {
                        t = t * 2;
                    }

                    if(previous2.contains("S")) {
                        s = s * 2;
                    } else if(previous2.contains("D")) {
                        d = d * 2;
                    } else if(previous2.contains("T")) {
                        t = t * 2;
                    }
                } else if(res3.contains("#")) {
                    if(previous.contains("S")) {
                        s = s - (int) Math.pow(gubun, 1) * 2;
                    } else if(previous.contains("D")) {
                        d = d - (int) Math.pow(gubun, 2) * 2;
                    } else if(previous.contains("T")) {
                        t = t - (int) Math.pow(gubun, 3) * 2;
                    }
                }

                if(!res3.contains("*") && !res3.contains("#")) {
                    res1 = res1.replace(res1.substring(0,i),"");
                    previous2 = previous;
                    previous = res3;
                } else {
                    res1 = res1.substring(i, res1.length());
                }
                i=0;
                res4="";
            }
        }
        answer = s + d + t;
        return answer;
    }
    public static boolean isNumeric(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    //문자열 내 마음대로 정렬하기
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length]; //리턴 값
        String[] arr = new String[strings.length]; //정렬할 변수

        //주어진 문자열 제일 앞부분에 n번째 문자를 입력
        for(int i = 0; i < arr.length; i++) {
            arr[i] = strings[i].charAt(n) + strings[i];
        }

        //오름차순으로 정렬
        Arrays.sort(arr);

        //정렬 후 앞에 추가했던 n번째 문자 제거
        for(int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].substring(1,arr[i].length());
        }

        return answer;
    }

    //문자열 내 p와 y의 개수
    boolean solution_6(String s) {
        boolean answer = true;

        int leftBracket = 0;
        int rightBracket = 0;

        for(int i=0; i<s.length(); i++) {
            if(String.valueOf(s.charAt(i)).equals("(")) {
                leftBracket++;
            } else if(String.valueOf(s.charAt(i)).equals(")")) {
                rightBracket++;
            }
        }

        System.out.println(leftBracket+" / "+rightBracket);

        if(leftBracket == rightBracket) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    //문자열 내림차순으로 배치하기
    public String solution_5(String s) {
        String answer = "";
        int len = s.length();
        String[] answerArr = new String[len];

        for(int i=0; i<len; i++) {
            answerArr[i] = String.valueOf(s.charAt(i));
        }

        Arrays.sort(answerArr, Collections.reverseOrder());

        for(String answerStr : answerArr) {
            answer += answerStr;
        }

        return answer;
    }

    //문자열 다루기 기본
    public boolean solution_4(String s) {
        boolean answer = true;

        if(s.length() == 4 || s.length() == 6) {
            answer = Pattern.matches("^[0-9]*$", s);
        } else {
            return false;
        }

        return answer;
    }

    //서울에서 김서방 찾기
    public static StringBuilder solution(String[] seoul) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<seoul.length; i++)
            if("Kim".equals(seoul[i]))
                answer.append("김서방은 "+i+"에 있다");

        return answer;
    }

    //수박수박수박수박수박수?
    public String solution_2(int n) {
        return new String(new char[n]).replaceAll("\0", "수박").substring(0,n);
    }

    //문자열을 정수로 바꾸기
    public int solution_3(String s) {
        return Integer.parseInt(s);
    }

    //시저암호
    public String solution(String s, int n) {
        String answer = "";
        String[] all = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] sLength = new String[s.length()];
        String emp = "";

        for(int i=0; i < sLength.length; i++) {
            emp = Character.toString(s.charAt(i));

            System.out.println(i+n);

            for(int j=0; j<all.length; j++) {

                if(emp.equals(all[j])) {

                    if(j+n >= all.length) {
                        answer += all[n - all.length + j];
                    } else {
                        answer += all[j + n];
                    }

                } else if(emp.equals(all[j].toLowerCase())) { //소문자인 경우

                    if(j+n >= all.length) {
                        answer += all[n - all.length + j].toLowerCase();
                    } else {
                        answer += all[j + n].toLowerCase();
                    }

                }

            }

            if(emp.equals(" ")) {
                answer += " ";
            }
        }

        return answer;
    }

    // 약수의 합
    public int solution(int numbers) {
        int answer = 0;

        for(int i=1; i<=numbers; i++) {
            if(numbers%i == 0) {
                answer += i;
            }
        }

        return answer;
    }

    //이상한 문자 만들기
    public String solution_2(String s) {
        String answer = "";
        char tmp;
        s = s.replaceAll(" ","_");
        String[] t = s.split("_",-1);

        for(int i=0; i<t.length; i++) {
            for(int j=0; j<t[i].length(); j++) {
                if(j == 0 || j%2 == 0) {
                    tmp = t[i].charAt(j);
                    answer += String.valueOf(tmp).toUpperCase();
                } else if(j%2 == 1) {
                    tmp = t[i].charAt(j);
                    answer += String.valueOf(tmp).toLowerCase();
                }
            }

            if(i != t.length -1) {
                answer += " ";
            }
        }

        return answer;
    }

    //핸드폰 번호 가리기
    public String solution(String phone_number) {
        String answer = "";
        int phoneLength = phone_number.length()-4;
        int i=0;

        while(i < phoneLength) {
            answer+= "*";

            i++;
        }

        answer += phone_number.substring(phone_number.length()-4, phone_number.length());

        return answer;
    }

    //x만큼 간격이 있는 n개의 숫자
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i=0; i<n; i++) {
            answer[i] = (long)x * (i+1);
        }
        return answer;
    }

    //직사각형 별찍기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i=0; i<b; i++) {
            for(int j=0; j<a; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
