package Baekjoon.Implement;

import java.math.BigInteger;
import java.util.Scanner;

public class BigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputData = scan.nextLine();

        String[] arr = inputData.split(" ");
        BigInteger A = new BigInteger(arr[0]);
        BigInteger B = new BigInteger(arr[1]);

        A = A.add(B);

        System.out.println(A.toString());
    }
}
