package studyExem.tip;

import java.math.BigDecimal;

public class Bigdecimal {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(3));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(0.35));
        System.out.println(bigDecimal.multiply(bigDecimal2));
    }
}
