package algorithmia.ValidationZeroContinuity;

import com.algorithmia.algo.*;
import com.google.gson.*;

public class ValidationZeroContinuity {
    @AcceptsJson
    @ReturnsJson
    public JsonElement apply(String input) {
        return new Runner(input).parseAndRunValidationRule();
    }
}
