package instutTask_changwoo;

class SuperObject {
    public void print() {
        draw();
    }

    public void draw() {
        draw(); //여기서 draw는 override되서 SubObject의 draw로 실행된다.
        System.out.println("Super Object");
    }
}

class SubObject extends SuperObject {
    public void print() {
        super.draw();
    }

    public void draw() {
        System.out.println("Sub Object");
    }
}

public class SSO {
    public static void main(String[] args) {
        int[][] data = { { 12345678 }, { 4005 }, { 230055 }, { 1 }, { 200 } };

        // 위 숫자에 한글단위명을 추가 해서 출력
        // 예) 1234만5천6백7십8
        // 예) 4천5
        // 예) 23만5십5
        // 예) 1
        // 예) 2백
        for(int i =0; i < data.length;i++) {

            String num = String.valueOf(data[i][0]);
            String num2 = "";
            for(int j =0; j <num.length();j++) {
                if(!String.valueOf(num.charAt(j)).equals("0")) {
                    num2 += String.valueOf(num.charAt(j));

                    if(j==num.length()-5) {
                        num2 +="만";
                    }else if(j==num.length()-4) {
                        num2 +="천";
                    }else if(j==num.length()-3) {
                        num2 +="백";
                    }else if(j==num.length()-2) {
                        num2 +="십";
                    }
                }
            }
            System.out.println(num2);
        }

    }
}