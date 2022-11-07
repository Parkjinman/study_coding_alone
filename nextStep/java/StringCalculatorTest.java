package nextStep.java;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void add() {
        // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야한다.
        assertEquals(0, stringCalculator.add(""));
        assertEquals(0, stringCalculator.add(null));

        // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
        assertEquals(123124, stringCalculator.add("123124"));

        // 3. 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
        assertEquals(3, stringCalculator.add("1,2"));

        // 4. 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.
        assertEquals(6, stringCalculator.add("1,2:3"));

        // 5. "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다.
        assertEquals(6, stringCalculator.add("//;\n1;2;3"));

        // 6. 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를  한다.
        assertThrows(RuntimeException.class, () -> {
            stringCalculator.add("-1");
        });
    }
}