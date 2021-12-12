package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PostRequest {

    ArrayList<Testing> testings;
    private  int packageId;
    private 

    public PostRequest(@JsonProperty("packageId") String packageId,
                       @JsonProperty("jsScript") String jsScript,
                       @JsonProperty("functionName") String finctionName,
                       @JsonProperty("testings") ArrayList<Testing> testings) {
        this.



    }
}