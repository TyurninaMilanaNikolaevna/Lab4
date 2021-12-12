package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PostRequest {

    ArrayList<Testing> testings;

    public PostRequest(@JsonProperty("packageId") String packageId,
                       @JsonProperty()) {

    }
}