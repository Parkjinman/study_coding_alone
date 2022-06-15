package instutTask;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

class timeer1 extends Thread {

    private final AtomicBoolean running = new AtomicBoolean(false);
    int time;

    public timeer1() {
        this.time = 1;
    }

    public void run() {
        running.set(true);
        while (running.get()) {
            System.out.println(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            this.time++;
        }
    }
}

//class timeer2 implements Runnable {
//    int time;
//
//    public timeer2(int time) {
//        // TODO Auto-generated constructor stub
//        this.time = time;
//    }
//
//    public void run() {
//        // TODO Auto-generated method stub
//        while (0 < this.time) {
//            Scanner scan = new Scanner(System.in);
//            int sd = scan.nextInt();
//            System.out.println(time);
//
//            if(sd == 1) {
//
//            }else {
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    // TODO: handle exception
//                }
//                this.time++;
//            }
//        }
//    }
//}

public class Day15_04 {
    public static void main(String[] args) {
        // Thread와 Runnable을 활용 스탑워치 만들기
        timeer1 time1 = new timeer1();
        time1.start();

        Scanner scan = new Scanner(System.in);
        System.out.println("s : STOP");
        System.out.println("h : HOLD");
        System.out.println("r : START");

        while(true) {
            String str = scan.next();

            if (str.equals("s")) {
                time1.interrupt();
                break;
            }
            else if (str.equals("h")) {
                time1.stop();
            }
            else if (str.equals("r")) {
                time1 = new timeer1();
                time1.start();
            }
        }


//        timeer2 time2 = new timeer2(1);
//        time2.run();

    }
}