package studyExam2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Subject2 {
    String name;
    int score;
}

class SubjectManager {
    Vector<Subject2> subjectList=new Vector<Subject2>();
}

class Student3 {
    String name;
    int number;
    SubjectManager sm=new SubjectManager();



    void studentPrint() {
        System.out.println(number + " " + name);
    }
}

class StudentManager {
    String name;
    Vector<Student3> studentList=new Vector<>();

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
        init();
    }

    void init() {
        studentList = new Vector<>();
        int num = 1001;
        int i = 0;
        Student3 st = new Student3();
        st.name = getName();
        st.number += (num + i);
        studentList.add(st);
        i++;
    }

    void printAllStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).studentPrint();
        }
    }
}



public class ArrayGetSet {
    /*static boolean getCon() {
        return false;
    }*/

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        StudentManager sm = new StudentManager();
        sm.init();
        sm.printAllStudent();

        int log=-1;

        while(true) {
            System.out.println("메뉴");
            System.out.println("[0] 학생추가");
            System.out.println("[1] 로그인");
            System.out.println("[2] 로그아웃");
            System.out.println("[3] 수강과목 추가");
            System.out.println("[4] 수강과목 삭제");
            System.out.println("[5] 수강과목 전체 출력");

            System.out.println("입력 : ");
            int num=scan.nextInt();

            if(num == 0) {
                Student3 st = new Student3();

                System.out.println("이름 입력 : ");
                sm.setName(scan.next());
            }
            else if(num==1) {
                if(log==-1) {
                    System.out.println("이름 입력 : ");
                    String name=scan.next();
                    for(int i=0;i<5;i++) {
                        if(name.equals(sm.studentList.get(i).name)) {
                            log=i;
                        }
                    }

                    if(log==-1) {
                        System.out.println("없는 이름 입니다...");
                    }
                    else {
                        System.out.println("로그인에 성공하였습니다!!!");
                    }

                }
                else {
                    System.out.println("이미 로그인 중이십니다...");
                }
            }
            else if(num==2){
                if(log!=-1) {
                    System.out.println("로그아웃 되셨습니다!!");
                    log=-1;
                }
                else {
                    System.out.println("로그인 후 이용해주세요!!!");
                }
            }
            else if(num==3) {
                if(log!=-1) {
                    Subject2 s=new Subject2();
                    System.out.println("추가하실 과목 입력 : ");
                    s.name=scan.next();

                    System.out.println("추가하실 과목 점수 입력 : ");
                    s.score=scan.nextInt();

                    sm.studentList.get(log).sm.subjectList.add(s);

                    System.out.println("추가 되었습니다!!!");
                }
                else {
                    System.out.println("로그인 후 이용해주세요!!!");
                }
            }
            else if(num==4) {
                if(log!=-1) {
                    for(int i=0;i<sm.studentList.get(log).sm.subjectList.size();i++) {
                        System.out.println(i+":"+sm.studentList.get(log).sm.subjectList.get(i).name+":"+sm.studentList.get(log).sm.subjectList.get(i).score);
                    }

                    System.out.println("삭제하실 인덱스 입력 :");

                    int n=scan.nextInt();

                    sm.studentList.get(log).sm.subjectList.remove(n);

                    System.out.println("삭제 되었습니다!!!");

                }
                else {
                    System.out.println("로그인 후 이용해주세요!!!");
                }
            }
            else if(num==5) {
                if(log!=-1) {
                    for(int i=0;i<sm.studentList.get(log).sm.subjectList.size();i++) {
                        System.out.println(i+":"+sm.studentList.get(log).sm.subjectList.get(i).name+":"+sm.studentList.get(log).sm.subjectList.get(i).score);
                    }
                }
                else {
                    System.out.println("로그인 후 이용해주세요!!!");
                }
            }

        }

    }

}
