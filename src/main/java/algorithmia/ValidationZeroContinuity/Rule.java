package algorithmia.ValidationZeroContinuity;

import java.math.BigDecimal;
import static algorithmia.ValidationZeroContinuity.MathHelperFunctions.safeConvertToBigDecimal;

public class Rule {

    private BigDecimal value1;
    private BigDecimal value2;
    private BigDecimal threshold;

    public Rule(InputData sourceInputData) {
        value1 = safeConvertToBigDecimal(sourceInputData.value1);
        value2 = safeConvertToBigDecimal(sourceInputData.value2);
        threshold = safeConvertToBigDecimal(sourceInputData.threshold);
    }

    public String getValueFormula() {
        return String.format("((abs(%1$s) > 0 AND %2$s = 0) OR (abs(%2$s) > 0 AND %1$s = 0)) AND abs(%1$s - %2$s) > %3$s",value1,value2,threshold);
    }

    public boolean run() {
        return oneValueOnlyIsPositive(value1,value2) && absoluteDifferenceGreaterThanThreshold(value1,value2,threshold);
    }

    // Static helper functions to try and simplify method calculation
    private static boolean oneValueOnlyIsPositive(BigDecimal value1, BigDecimal value2) {
        return (absGreaterThanZero(value1) && isZero(value2)) || (absGreaterThanZero(value2) && isZero(value1));
    }

    private static boolean absGreaterThanZero(BigDecimal value){
        return value.abs().compareTo(BigDecimal.ZERO) == 1;
    }

    private static boolean isZero(BigDecimal value){
        return value.compareTo(BigDecimal.ZERO) == 0;
    }

    private static boolean absoluteDifferenceGreaterThanThreshold(BigDecimal value1, BigDecimal value2, BigDecimal threshold){
        return value1.subtract(value2).abs().compareTo(threshold) == 1;
    }

}