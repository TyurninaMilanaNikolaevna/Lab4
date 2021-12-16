package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PostRequest {

    ArrayList<Testing> testings;

    public PostRequest(@JsonProperty("packageId") String packageId,
                       @JsonProperty("jsScript") String jsScript,
                       @JsonProperty("functionName") String functionName,
                       @JsonProperty("testings") ArrayList<Testing> testings) {
        this.testings = testings;

        for (Testing testing : this.testings) {
            testing.setPackageId(packageId);
            testing.setJsScript(jsScript);
            testing.setFunctionName(functionName);
        }
    }

    public ArrayList<Testing> getTestings() {
        return testings;
    }
}