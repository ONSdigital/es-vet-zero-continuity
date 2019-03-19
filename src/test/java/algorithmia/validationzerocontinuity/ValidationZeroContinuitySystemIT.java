package algorithmia.validationzerocontinuity;


import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidationZeroContinuitySystemIT {

    private static String API_KEY = null;
    private static String API_ADDRESS = null;
    private static String ALGORITHM_DESCRIPTOR = null;

    private AlgorithmiaClient client = null;

    @BeforeClass
    public static void loadConfig() {
        Config config = ConfigFactory.load().getConfig("algorithmia");
        API_KEY = config.getString("simpleApiKey");
        API_ADDRESS = config.getString("apiAddress");
        ALGORITHM_DESCRIPTOR = config.getString("algorithm.descriptor");
    }

    @Before
    public void setUp() {
        client = Algorithmia.client(API_KEY, API_ADDRESS);
    }

    @After
    public void tearDown() {
        if (client != null) {
            try {
                client.close();
            } catch (IOException ignore) {
                // silently ignore
            }
        }
    }

    @Test
    public void testASuitableGreetingIsReturnedWhenTheAlgorithmInputIsAName() throws Exception {
        assertThat(client.algo(ALGORITHM_DESCRIPTOR).pipe("Bob").asString(), equalTo("Hello Bob"));
    }
}
