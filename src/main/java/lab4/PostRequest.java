package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PostRequest {

    ArrayList<Testing> testings;
    private  int packageId;
    private String jsScript;
    private String functionName;

    public PostRequest(@JsonProperty("packageId") String packageId,
                       @JsonProperty("jsScript") String jsScript,
                       @JsonProperty("functionName") String functionName,
                       @JsonProperty("testings") ArrayList<Testing> testings) {
        this.packageId.setPackageId(packageId);
        this.jsScript.serJsScript(jsScript);
        this.functionName = functionName;
        this.testings = testings;

        for (int i = 0; i < testings.size(); i++) {
            testings.set
        }
    }

    public ArrayList<Testing> getTestings() {
        return testings;
    }
}