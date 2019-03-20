package algorithmia.validationzerocontinuity;

import algorithmia.ValidationZeroContinuity.InputData;
import algorithmia.ValidationZeroContinuity.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuleTest {

    @Test
    public void testValidationZeroContinuity() throws Exception {
        InputData input = new InputData();
        Rule rule = new Rule(input);
        String returned = rule.getValueFormula();
        String expected = "((abs(0) > 0 AND 0 = 0) OR (abs(0) > 0 AND 0 = 0)) AND abs(0 - 0) > 0";
        assertEquals(expected,returned);
    }

    @Test
    public void test_GivenPositiveNumberReturnValueFomula() throws Exception {
        InputData input = new InputData("451.0","895.02","56");
        Rule rule = new Rule(input);
        String returned = rule.getValueFormula();
        String expected = "((abs(451.0) > 0 AND 895.02 = 0) OR (abs(895.02) > 0 AND 451.0 = 0)) AND abs(451.0 - 895.02) > 56";
        assertEquals(expected,returned);
    }

    @Test
    public void test_GivenAllZeroInputRunValidation_DoNotTrigger() throws Exception {
        InputData input = new InputData();
        Rule rule = new Rule(input);
        assertFalse(rule.run());
    }

    @Test
    public void test_GivenPositiveValueOneZeroValueTwoRunValidation_Trigger() throws Exception {
        InputData input = new InputData("78","0","77");
        Rule rule = new Rule(input);
        assertTrue(rule.run());
    }

    @Test
    public void test_GivenPositiveValueOneZeroValueTwoLargeThresholdRunValidation_DoNotTrigger() throws Exception {
        InputData input = new InputData("78","0","78");
        Rule rule = new Rule(input);
        assertFalse(rule.run());
    }

    @Test
    public void test_GivenZeroValueOnePositiveValueTwoRunValidation_Trigger() throws Exception {
        InputData input = new InputData("0","101","100");
        Rule rule = new Rule(input);
        assertTrue(rule.run());
    }

    @Test
    public void test_GivenZeroValueOnePositiveValueTwoLargeThresholdRunValidation_DoNotTrigger() throws Exception {
        InputData input = new InputData("0","101","101");
        Rule rule = new Rule(input);
        assertFalse(rule.run());
    }

    @Test
    public void test_GivenNegativeValueOneZeroValueTwoRunValidation_Trigger() throws Exception {
        InputData input = new InputData("-78","0","77");
        Rule rule = new Rule(input);
        assertTrue(rule.run());
    }

    @Test
    public void test_GivenZeroValueOneNegativeValueTwoRunValidation_Trigger() throws Exception {
        InputData input = new InputData("0","-78","77");
        Rule rule = new Rule(input);
        assertTrue(rule.run());
    }

    @Test
    public void test_GivenBothPositiveValuesRunValidation_DoNotTrigger() throws Exception {
        InputData input = new InputData("89","5","1");
        Rule rule = new Rule(input);
        assertFalse(rule.run());
    }

}