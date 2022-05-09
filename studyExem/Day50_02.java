package studyExem;

import java.util.Scanner;

class Student {
    String name = null;
}

class Subject {
    String title;
    int score;
}

class Lms {
    Scanner scan = new Scanner(System.in);
    int stuCnt = 0;
    Student[] group = null;
    Student[] copyGroup = null;


    void printMenu() {
        System.out.println("[1]학생 추가하기"); // 이름 입력받아 추가
        System.out.println("[2]과목 추가하기"); // 이름과 과목 입력받아 추가
        System.out.println("[3]성적 추가하기"); // 이름과 과목 그리고 성적 입력받아 추가
    }

    void addStudent() {
        stuCnt++;

        if(this.group != null) {
            this.copyGroup = new Student[stuCnt];

            for(int i=0; i<this.copyGroup.length-1; i++) {
                this.copyGroup[i] = new Student();
                this.copyGroup[i].name = this.group[i].name;
            }

            this.group = new Student[stuCnt];

            for(int i=0; i<this.group.length; i++) {
                this.group[i] = new Student();
                if(i < this.group.length-1) this.group[i].name = this.copyGroup[i].name;
            }

            System.out.println("이름을 입력하세요");
            this.group[stuCnt-1].name=scan.next();

            System.out.println("추가 완료 되었습니다");

        } else {
            this.group = new Student[stuCnt];

            this.group[stuCnt-1] = new Student();

            System.out.println("이름을 입력하세요");
            this.group[stuCnt-1].name = scan.next();

            System.out.println("추가 완료 되었습니다");
        }
    }

    void addSubject() {
        for(int i=0;i<stuCnt;i++) {
            System.out.println("["+(i+1)+"]"+":"+group[i].name);
        }
        System.out.println("숫자 입력 : ");
        int num=scan.nextInt();

        num-=1;
        System.out.println("추가할 과목 입력 : ");
        String g=scan.next();

    }

    void recordScore() {

    }

    void selectMenu() {
        System.out.println("번호를 입력해주세요");
        int sel = scan.nextInt();
        if (sel == 1) {
            addStudent();
        } else if (sel == 2) {
            addSubject();
        } else if (sel == 3) {
            recordScore();
        } else if (sel == 4) {
            print();
        }
    }

    void print() {
        for(int i = 0; i<stuCnt; i++) {
            System.out.println(group[i].name);
        }
    }

    void run() {

        while (true) {
            printMenu();
            selectMenu();
        }
    }
}



public class Day50_02 {
    public static void main(String[] args) {
        Lms s = new Lms();
        s.run();
    }
}