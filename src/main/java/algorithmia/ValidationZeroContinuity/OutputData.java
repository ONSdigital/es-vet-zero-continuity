package algorithmia.ValidationZeroContinuity;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class OutputData {

    public String valueFormula = null;
    public Boolean triggered = null;
    public Object metaData = null;
    public Object error = null;

    public OutputData(String valueFormula, Boolean triggered, Object metaData) {
        this.valueFormula = valueFormula;
        this.triggered = triggered;
        this.metaData = metaData;
    }

    public OutputData(Object error) {
        this.error = error;
    }

    public OutputData() {}

    public JsonElement toJsonElement() {
        return new JsonParser().parse(new Gson().toJson(this));
    }
}
