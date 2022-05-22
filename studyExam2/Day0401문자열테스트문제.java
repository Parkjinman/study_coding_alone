package studyExam2;

import java.util.Arrays;

class Student2{
    String name;
    int score;
    void print() {
        System.out.println(name + " : " + score);
    }
}

public class Day0401문자열테스트문제 {
    public static void main(String[] args) {
        String data = "3\n";
        data +="김영희/30\n";
        data += "이만수/40\n";
        data += "이철민/60";

        Student2[] studentList = new Student2[3];
        // 데이터 세팅
        int cnt = 0;
        String[] strArr2 = data.split("/|\\n");

        studentList[cnt] = new Student2();
        for (int i = 0; i < strArr2.length; i++) {
            if (i == 0) studentList[cnt].name = strArr2[i];
            else studentList[cnt].score = Integer.parseInt(strArr2[i]);
        }
        cnt++;

        int[] arr = new int[3];
        //문제1)data에 있는 내용을 잘라서 studentList에 저장후 출력
        for(int i=0; i<studentList.length; i++) {
            studentList[i].print();
            arr[i] = studentList[i].score;
        }

        Arrays.sort(arr);

        //문제2)꼴등 삭제후 다시 data에 저장
        data = "3\n";
        for(int i=0; i<studentList.length; i++) {
            if(studentList[i].score > arr[0]) data += studentList[i].name+"/"+studentList[i].score+"\n";
        }

        System.out.println(data);

    }

}