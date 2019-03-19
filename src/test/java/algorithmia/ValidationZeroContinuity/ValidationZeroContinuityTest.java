package algorithmia.ValidationZeroContinuity;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for ValidationZeroContinuity algorithm
 */
public class ValidationZeroContinuityTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ValidationZeroContinuityTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ValidationZeroContinuityTest.class);
    }

    /**
     * Basic test
     */
    public void testValidationZeroContinuity() throws Exception {
        // If you made a constructor with multiple arguments, this will fail to compile
        // and for the time being, we think that's better than an InstantiationException
        // when trying to run the algorithm. If this bites you, sorry.
        ValidationZeroContinuity algorithm = new ValidationZeroContinuity();

        // Below is a test case that expects the apply method to take a string.
        // Since you may want an apply method that takes something else, we've
        // commented out this test for now so you don't get an annoying compile error.
        //assertEquals(algorithm.apply("Bob"), "Hello Bob");
    }
}
