package problems;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MathPractice {
    public static void main(String[] args) {
        Double a = Math.pow(2,4);
        System.out.println(a.floatValue());
        Float fl  = 90842.30959393020029302093020029430020930220003f;
        Double f = Double.MIN_VALUE;
        System.out.println();

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        System.out.println(fl);
        System.out.println(decimalFormat.format(fl));

        Double d = Math.log(33) / Math.log(2);
        System.out.println(Math.ceil(d));

    }


}
