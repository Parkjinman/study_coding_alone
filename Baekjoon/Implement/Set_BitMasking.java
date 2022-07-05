package Baekjoon.Implement;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Set_BitMasking {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int result = 0;

        while( M-->0) {
            String inputDataA = scan.next();
            int inputDataB = 0;

            switch (inputDataA) {
                case "add" :
                    inputDataB = scan.nextInt();
                    result |= (1 << (inputDataB-1));
                    break;
                case "remove" :
                    inputDataB = scan.nextInt();
                    result &= ~(1 << (inputDataB-1));
                    break;
                case "check" :
                    inputDataB = scan.nextInt();
                    str.append((result & (1 << (inputDataB-1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    inputDataB = scan.nextInt();
                    result ^= (1 << (inputDataB-1));
                    break;
                case "all" :
                    result |= (~0);
                    break;
                case "empty" :
                    result = 0;
                    break;
            }
        }
        bw.write(str.toString());
        bw.close();
    }
}
