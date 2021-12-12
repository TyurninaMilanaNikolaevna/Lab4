package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Testing {
    private String testName;
    private String expectedResult;
    private ArrayList<Object> parameters;

    public Testing(@JsonProperty("")) {

    }
}