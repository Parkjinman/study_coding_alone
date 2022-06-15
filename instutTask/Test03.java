package instutTask;

import java.util.Scanner;

class Tic {
    // 네모 한 칸
    private int[] line = new int[3];

    public int[] getLine() {
        return line;
    }
    public void setLine(int[] line) {
        this.line =  line;
    }
    public void printLine() {
        for(int i = 0; i < 3; i++) {
            if(line[i] == 0) {
                System.out.print("[ ]");
            }else if(line[i] == 1) {
                System.out.print("[o]");
            }else if(line[i] == 2) {
                System.out.print("[x]");
            }
        }
        System.out.println();
    }
}

class Tictactoe {
    // 게임 구현
    public void run() {
        boolean run = true;
        Tic[] ticList = new Tic[3];
        for(int i = 0; i < ticList.length; i++) {
            ticList[i] = new Tic(); // 제일많이 실수.
        }
        Scanner scan = new Scanner(System.in);
        boolean turn = true;
        while(run) {
            for(int i = 0; i< ticList.length; i++) {
                ticList[i].printLine();
            }
            System.out.println();
            System.out.println("y (0~2)를 입력하세요 >> ");
            int y = scan.nextInt();
            System.out.println("x (0~2)를 입력하세요 >> ");
            int x = scan.nextInt();
            if(turn == true && ticList[y].getLine()[x] == 0) {
                turn = false;
            }else {
                turn = true;
            }
        }
    }
}

public class Test03 {
    public static void main(String[] args) {
        Tictactoe ttt = new Tictactoe();
        ttt.run();

    }
}