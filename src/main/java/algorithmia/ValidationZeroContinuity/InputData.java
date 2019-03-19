package algorithmia.ValidationZeroContinuity;

public class InputData {

    public String value1 = "";
    public String value2 = "";
    public String threshold = "";

    public Object metaData = "{}";

    public InputData() {}

    public InputData(String value1, String value2,
                     String threshold) {
        this.value1 = value1;
        this.value2 = value2;
        this.threshold = threshold;
    }

}