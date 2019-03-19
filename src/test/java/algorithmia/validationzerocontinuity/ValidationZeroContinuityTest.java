package algorithmia.validationzerocontinuity;

import algorithmia.ValidationZeroContinuity.ValidationZeroContinuity;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidationZeroContinuityTest {

    private final ValidationZeroContinuity underTest;

    public ValidationZeroContinuityTest() {
        underTest = new ValidationZeroContinuity();
    }

    @Test
    public void testValidationZeroContinuity() throws Exception {
        assertThat(underTest.apply("Bob"), equalTo("Hello Bob"));
    }
}
