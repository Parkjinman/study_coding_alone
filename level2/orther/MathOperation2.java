package level2.orther;

import java.util.ArrayList;
import java.util.HashMap;

public class MathOperation2 {

    static int[] arr = {2,6,8,14};

    //N개의 최소공배수(다른 사람 풀이)
    public static long nlcm(int[] num) {
        long answer = num[0],g;
        for(int i=1;i<num.length;i++){
            g=gcd(answer,num[i]);
            answer=g*(answer/g)*(num[i]/g);
        }
        return answer;
    }
    public static long gcd(long a,long b){
        if(a>b)
            return (a%b==0)? b:gcd(b,a%b);
        else
            return (b%a==0)? a:gcd(a,b%a);
    }

    public static void main(String[] args) {
        System.out.println(nlcm(arr));
    }
}