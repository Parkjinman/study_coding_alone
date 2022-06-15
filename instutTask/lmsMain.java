package instutTask;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

class Student {
    int num;
    String name;

    int subCnt;
    Subject[] subjects = null;

    void printInfo() {
        System.out.printf("%d (%s)\n", this.num, this.name);
    }

}

class Subject {
    String title;
    int score;

    void printInfo() {
        System.out.printf("%s :%d\n", this.title, this.score);
    }
}

class Lms {

    File file = new File("lms.txt");
    Random ran = new Random();
    Scanner scan = new Scanner(System.in);
    int stuCnt;
    Student[] group = null;

    void printMenu() {
        System.out.println("메뉴");
        System.out.println("[1]학생 추가하기"); // 이름 입력받아 추가
        System.out.println("[2]과목 추가하기"); // 이름과 과목 입력받아 추가
        System.out.println("[3]성적 추가하기"); // 이름과 과목 그리고 성적 입력받아 추가
        System.out.println("[4]삭제");
        System.out.println("[5]정렬");
        System.out.println("[6]출력");
        System.out.println("[7]저장");
        System.out.println("[8]로드");

    }

    void selectMenu() {
        int sel = scan.nextInt();

        if (sel == 1) {
            addStudent();
        } else if (sel == 2) {
            addSubject();
        } else if (sel == 3) {
            recordScore();
        } else if (sel == 4) {
            delStudent();
        } else if (sel == 5) {
            studentSort();
        } else if (sel == 6) {
            studentPrint();
        } else if (sel == 7) {
            studentSave();
        } else if (sel == 8) {
            studentLoad();
        }
    }

    void delStudent() {
        System.out.println("삭제할 학번을 입력해주세요");
        int num = scan.nextInt();
        boolean check = false;
        for (int i = 0; i < group.length; i++) {
            if (group[i].num == num)
                check = true;
        }
        if (check) {
            Student[] temp = this.group;
            this.group = new Student[this.stuCnt];
            int idx = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].num != num) {
                    this.group[idx] = temp[i];
                    idx++;
                }
            }
            stuCnt--;

            System.out.println("삭제 되었습니다");
        } else {
            System.out.println("일치하는 학번이 없습니다");
        }

    }

    void studentSort() {
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < group.length; j++) {
                if (group[i].num < group[j].num) {
                    Student temp = this.group[i];
                    this.group[i] = this.group[j];
                    this.group[j] = temp;
                }
            }
        }
    }

    void studentPrint() {
        for (int i = 0; i < this.group.length; i++) {
            System.out.printf("%d (%s)\n", this.group[i].num, this.group[i].name);
        }

    }

    String getdata() {
        String data = "";
        for (int i = 0; i < stuCnt; i++) {
            Student stu = this.group[i];
            data += group[i].num + "/";
            data += group[i].name + ",";
            for (int j = 0; j < stu.subCnt; j++) {
                Subject subject = stu.subjects[j];
                data += subject.title + "/";
                data += subject.score;
                if (j < stu.subCnt - 1) {
                    data += ",";
                }
            }
            if (i < this.stuCnt - 1)
                data += "\n";
        }
        return data;
    }

    void studentSave() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("Studentfile.txt");
            fw.write(getdata());
            fw.close();
            System.out.println("저장되었습니다");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("저장실패했습니다");
        }
    }

    void studentLoad() {
        try {
            File file = new File("Studentfile.txt");
            FileReader fr = new FileReader(file);
            FileReader fr2 = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(fr2);

            int c = 0;
            while(br2.ready()) {
                br2.readLine();
                c++;
            }

            int i = 0;
            String line;
            while(br.ready()) {
                Student temp[] = new Student[c];

                temp[i] = new Student();
                line = br.readLine();
                String value[] = line.split("/");
                temp[i].num = Integer.valueOf(value[0]);
                temp[i].name = value[1];
                i++;
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    int createStuNum() {
        while (true) {
            int rNum = ran.nextInt(8999) + 1000;
            boolean check = true;
            for (int i = 0; i < this.stuCnt; i++) {
                if (rNum == this.group[i].num)
                    check = false;
            }
            if (check) {
                return rNum;
            }
        }
    }

    void addStudent() {
        System.out.println("이름을 입력하세요");
        String name = scan.next();

        Student[] temp = this.group;
        this.group = new Student[this.stuCnt + 1];
        for (int i = 0; i < this.stuCnt; i++) {
            this.group[i] = temp[i];
        }

        Student student = new Student();
        student.name = name;
        student.num = createStuNum();

        this.group[this.stuCnt] = student;
        stuCnt++;

        System.out.println("추가 완료 되었습니다");
    }

    int getStudentIdx(int num) {
        for (int i = 0; i < this.stuCnt; i++) {
            if (this.group[i].num == num) {
                return i;
            }
        }
        return -1;
    }

    boolean checkSubjectDupl(int stuIdx, String subTitle) {
        for (int i = 0; i < this.group[stuIdx].subCnt; i++) {
            if (this.group[stuIdx].subjects[i].title.equals(subTitle)) {
                return false;
            }
        }
        return true;
    }

    void addSubject() {
        System.out.println("학번 입력 : ");
        int num = scan.nextInt();
        int idx = getStudentIdx(num);

        if (idx != -1) {
            System.out.println("과목명: ");
            String subTitle = scan.next();

            if (checkSubjectDupl(idx, subTitle)) {
                Subject subject = new Subject();
                subject.title = subTitle;

                Student stu = this.group[idx];

                Subject[] temp = stu.subjects;
                stu.subjects = new Subject[stu.subCnt + 1];
                for (int i = 0; i < this.group[idx].subCnt; i++)
                    stu.subjects[i] = temp[i];
                stu.subjects[stu.subCnt] = subject;
                stu.subCnt++;

            }

        }

    }

    void recordScore() {
        System.out.print("학번:");
        int num = scan.nextInt();
        int idx = getStudentIdx(num);
        if (idx != -1) {
            Student stu = this.group[this.stuCnt-1];
            for (int i = 0; i < stu.subjects.length; i++) {
                System.out.println(i + 1 + ")");
                stu.subjects[i].printInfo();

            }
            System.out.println("과목 번호 :");
            int subIdx = scan.nextInt() - 1;
            if (subIdx >= 0 && subIdx < stu.subCnt) {
                System.out.println("성적");
                int score = scan.nextInt();
                stu.subjects[subIdx].score = score;
            }
        }
    }

    void printAllStudents() {
        System.out.println("--------------------------------");
        for (int i = 0; i < this.stuCnt; i++) {
            System.out.printf("%d)", i + 1);
            this.group[i].printInfo();
            System.out.println();

            for (int j = 0; j < this.group[i].subCnt; j++) {
                System.out.print("ㄴ");
                this.group[i].subjects[j].printInfo();
            }
        }
        System.out.println("--------------------------------");
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        while (true) {

            printAllStudents();

            printMenu();

            selectMenu();

        }
    }
}

public class lmsMain {
    public static void main(String[] args) {
        Lms s = new Lms();
        s.run();
    }
}