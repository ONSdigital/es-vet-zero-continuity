package algorithmia.ValidationZeroContinuity;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

public class Runner {

    private final String inputJson;

    public Runner(String inputJson) {
        this.inputJson = inputJson;
    }

    // Take any required source JSON, parse it into our data class, run the validation rule and then produce the output
    public JsonElement parseAndRunValidationRule(){
        OutputData outputData;
        try {
            InputData inputData = new Gson().fromJson(inputJson, InputData.class);
            outputData = runValidationRule(inputData);
        } catch (JsonSyntaxException e) {
            outputData = new OutputData("Error parsing source JSON: " + inputJson);
        } catch (Exception e) {
            outputData = new OutputData("Miscellaneous error parsing JSON input parameters: " + inputJson);
        }
        return outputData.toJsonElement();
    }

    // Take the given data and invoke the validation rule
    private OutputData runValidationRule(InputData inputData){
        Rule rule = new Rule(inputData);
        return new OutputData(rule.getValueFormula(),rule.run(),inputData.metaData);
    }

}
