package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Set_BitMasking {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int bitset = 0;

        while(M-->0) {
            int num;
            String str = scan.next();

            switch (str) {
                case "add" :
                    num = scan.nextInt();
                    bitset |= (1 << (num-1));
                    break;
                case "remove" :
                    num = scan.nextInt();
                    bitset = bitset & ~(1 << (num-1));
                    break;
                case "check" :
                    num = scan.nextInt();
                    System.out.print((bitset & (1 << (num - 1))) != 0 ? "1\n" : "O\n");
                    break;
                case "toggle" :
                    num = scan.nextInt();
                    bitset ^= (1 << (num-1));
                    break;
                case "all" :
                    bitset |= (~0);
                    break;
                case "empty" :
                    bitset &= 0;
                    break;
            }
        }
        System.out.println();
    }
}
