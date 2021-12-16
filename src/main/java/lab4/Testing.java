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

    String currentResult;

    public void setCurrentResult (String currentResult) {
        this.currentResult = currentResult;
    }

    public String getCurrentResult(){
        return currentResult;
    }

    private String packageId;
    private String jsScript;
    private String functionName;


    public String getPackageId() {
        return packageId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public void setJsScript(String jsScript) {
        this.jsScript = jsScript;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
}