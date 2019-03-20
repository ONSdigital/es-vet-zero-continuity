package algorithmia.ValidationZeroContinuity;

import java.math.BigDecimal;

public final class MathHelperFunctions {

    private MathHelperFunctions(){}

    public static BigDecimal safeConvertToBigDecimal(String string) {
        BigDecimal safeDecimal;
        try {
            safeDecimal = new BigDecimal(string);
        } catch (NumberFormatException | NullPointerException e) {
            safeDecimal = new BigDecimal(0);
        }
        return safeDecimal;
    }
}
