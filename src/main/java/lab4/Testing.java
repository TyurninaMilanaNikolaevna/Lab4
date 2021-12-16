package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Testing {
    private final String testName;
    private final String expectedResult;
    private final ArrayList<Object> parameters;

    public Testing(@JsonProperty("testName") String testName,
                   @JsonProperty("expectedResult") String expectedResult,
                   @JsonProperty("parameters") ArrayList<Object> parameters) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.parameters = parameters;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public ArrayList<Object> getParameters() {
        return parameters;
    }

    String receiveResult;

    public void setReceiveResult(String receiveResult) {
        this.receiveResult = receiveResult;
    }

    public String getReceiveResult(){
        return receiveResult;
    }

    private String packageId;

    public String getPackageId() {
        return packageId;
    }
}