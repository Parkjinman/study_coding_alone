package studyExem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class studyMain2 {
    //문제1. 31명의 학생 중 남자 12명 여자 14명이 봉사활동을 했다. 봉사활동을 안한 학생 수는?(객체 및 반복문 사용 필수)
    public static void main(String[] args) {
        Students man1 = new Students("남","홍길동", "Y");
        Students man2 = new Students("남","철수", "Y");
        Students man3 = new Students("여","짱구", "N");

        /*ArrayList<Students> arrayList = new ArrayList<>();

        arrayList.add(man1);
        arrayList.add(man2);
        arrayList.add(man3);

        int count = 0;
        for(int i=0; i<arrayList.size(); i++) {
            if(arrayList.get(i).srvcActAtn.equals("Y")) {
                count++;
            }
        }*/
//        System.out.println(count);

        comparator.compare(man2,man3);
        comparable.compareTo(man2);

    }

    private static Comparator<Students> comparator = new Comparator<Students>() {
        @Override
        public int compare(Students o1, Students o2) {
            System.out.println(" Comparator ( " + o1.name +" : "+ o2.name + " ) ");
            return 0;
        }
    };

    private static Comparable<Students> comparable = new Comparable<Students>() {
        String name = "고길동";

        @Override
        public int compareTo(Students o) {
            System.out.println(" Comparator ( " + this.name +" : "+ o.name + " ) ");
            return 0;
        }
    };
}

class Students{
    String sex;
    String name;
    String srvcActAtn;

    Students(String sex, String name,  String srvcActAtn) {
        this.sex = sex;
        this.name = name;
        this.srvcActAtn = srvcActAtn;
    }
}

/*class Students implements Comparable<Students>, Comparator<Students> {
    String sex;
    String name;
    String srvcActAtn;

    Students(String sex, String name,  String srvcActAtn) {
        this.sex = sex;
        this.name = name;
        this.srvcActAtn = srvcActAtn;
    }

    @Override
    public int compareTo(Students o) {
        System.out.println(" Comparable ( "+this.name+" : "+o.name + " ) ");
        return 0;
    }

    @Override
    public int compare(Students a, Students b) {
        System.out.println(" Comparator ( " + a.name +" : "+ b.name + " ) ");
        return 0;
    }
}*/
