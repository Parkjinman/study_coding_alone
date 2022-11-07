package nextStep.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static int add(String text) {
        boolean mSe;

        // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야한다.
        if(text == null || text.trim().isEmpty()) return 0;

        // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
        Pattern p = Pattern.compile("^[0-9]*$");
        Matcher m = p.matcher(text);
        if(m.matches()) return Integer.parseInt(text);

        // 3. 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
        // 4. 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.
        int sum = 0;
        String[] arrNum = text.split(",|:");
        for(String str : arrNum) {
            if(Pattern.compile("^[0-9]$").matcher(str).matches())
            sum += Integer.parseInt(str);
        }
        if(sum > 0) return sum;

        // 5. "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다.
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(text);
        mSe = matcher.find();
        if (mSe) {
            String customDelimeter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimeter);
            for (String str : tokens) sum += Integer.parseInt(str);
        }

        // 6. 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를  한다.
        if(!mSe && Integer.parseInt(text) < 0) throw new RuntimeException();

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(null));
    }
}
