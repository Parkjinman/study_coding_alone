package studyExem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        String[] arr = str.split("");

        for(int i=0; i<arr.length; i++) {
            int hour = 0;
            int minute = 0;
        }

        System.out.println(str);
    }

    //14 30
    //20
    //result : 14 50

    //17 40
    //80
    //result : 19 0

    //23 48
    //25
    //result : 0 13
}