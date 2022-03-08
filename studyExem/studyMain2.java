package studyExem;

import java.util.ArrayList;

public class studyMain2 {
    //문제1. 31명의 학생 중 남자 12명 여자 14명이 봉사활동을 했다. 봉사활동을 안한 학생 수는?(객체 및 반복문 사용 필수)
    public static void main(String[] args) {
        Students man1 = new Students("남","박창우", "Y");
        Students man2 = new Students("남","박창오", "Y");
        Students man3 = new Students("여","박창순", "N");

        ArrayList<Students> arrayList = new ArrayList<>();

        arrayList.add(man1);
        arrayList.add(man2);
        arrayList.add(man3);

        int count = 0;
        for(int i=0; i<arrayList.size(); i++) {
            if(arrayList.get(i).srvcActAtn.equals("Y")) {
                count++;
            }
        }

        System.out.println(count);
    }
}

class Students {
    String sex;
    String name;
    String srvcActAtn;

    Students(String sex, String name,  String srvcActAtn) {
        this.sex = sex;
        this.name = name;
        this.srvcActAtn = srvcActAtn;
    }
}
