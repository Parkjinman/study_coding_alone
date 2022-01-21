package level1.me;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class RegularExpression {

    //신규 아이디 추천
    public String solution(String new_id) {
        String strT2 = new_id;

        strT2 = strT2.toLowerCase();
        strT2 = strT2.replaceAll("[^-_.a-z0-9]","");
        strT2 = strT2.replaceAll("[.]{2,}",".");
        strT2 = strT2.replaceAll("^[.]|[.]$","");

        if(strT2.isEmpty()) strT2 = "a";
        if(strT2.length() > 15) {
            strT2 = strT2.substring(0, 15);
            strT2 = strT2.replaceAll("[.]$", "");
        }
        if(strT2.length() <= 2) {
            while(strT2.length() < 3) {
                strT2 += strT2.charAt(strT2.length()-1);
            }
        }

        return strT2;
    }

    // 2016년
    public String solution_2(int a, int b) {
        String answer = "";
        String aString = String.valueOf(a);
        String bString = String.valueOf(b);

        //1~9까지의 정규표현식을 이용한 true, false 구하기
        String pattern = "^[1-9]{1}$";
        boolean aRegex = Pattern.matches(pattern, aString);
        boolean bRegex = Pattern.matches(pattern, bString);

        //각 a와 b의 값이 1~9인경우 앞에 0을 붙여줌
        if(aRegex) {
            aString = "0"+String.valueOf(a);
        }
        if(bRegex) {
            bString = "0"+String.valueOf(b);
        }

        // ex)20160524
        String data = "2016"+aString+bString;

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd") ;
        Date date = new Date();
        Calendar calendar = null;

        try {
            date = dateFormat.parse(data);

            calendar = Calendar.getInstance();
            calendar.setTime(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //1~7까지 각각 일~토 순서
        int result = calendar.get(Calendar.DAY_OF_WEEK);

        if(result == 1) answer = "SUN";
        if(result == 2) answer = "MON";
        if(result == 3) answer = "TUE";
        if(result == 4) answer = "WED";
        if(result == 5) answer = "THU";
        if(result == 6) answer = "FRI";
        if(result == 7) answer = "SAT";

        return answer;
    }
}
