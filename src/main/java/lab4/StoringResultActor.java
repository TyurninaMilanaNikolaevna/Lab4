package lab4;

import java.util.HashMap;
import java.util.Map;

public class StoringResultActor {
    private final Map<String, Map<String, String>> storingResult = new HashMap<>();

    private static class Result {
        String testName;
        String result;
    }

    
}
