package instutTask_changwoo;

import java.util.Scanner;

//티켓예매 시스템 완성
//시작 00:00
//종료 33:27
//소요 33:17.17
class Seat {
    private boolean check;

    boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void printList() {
        if(check == true) {
            System.out.print("■ ");
        }
        else {
            System.out.print("□ ");
        }
    }
}

class TMS {

    boolean run = true;
    int cnt = 0;

    Seat [] seatList = new Seat[10];
    public void select() {
        Scanner scan = new Scanner(System.in);
        System.out.println("번호를 입력하세요 >> ");
        int sel = scan.nextInt();
        if(seatList[sel].getCheck() == false) {
            seatList[sel].setCheck(true);
            cnt++;
        }else {
            System.out.println("예약이 된 자리입니다");
        }
    }
    public void print() {
        for(int i = 0; i< seatList.length; i++) {
            seatList[i].printList();
        }
    }
    public void soldout() {
        if(seatList.length==cnt) {
            System.out.println("매진입니다");
            run = false;
        }
    }

    public void run() {
        for(int i = 0; i < seatList.length; i++) {
            seatList[i] = new Seat();
        }
        while(run) {
            print();
            System.out.println();
            select();
            soldout();
        }
    }

    public TMS(Seat seat) {
        for(int i = 0; i < seatList.length; i++) {
            seatList[i] = seat;
        }
        while(run) {
            print();
            System.out.println();
            select();
            soldout();
        }
    }

    public TMS(String str) {

    }
}

public class Test02 {
    public static void main(String[] args) {
        TMS tms = new TMS(new Seat());

        TMS tms2 = new TMS("2");

        TMS tms3 = new TMS("2");
        tms3.run();
    }
}