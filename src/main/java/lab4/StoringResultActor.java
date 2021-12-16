package lab4;

import java.util.HashMap;
import java.util.Map;

public class StoringResultActor {
    private final Map<String, Map<String, String>> storingResult = new HashMap<>();

    private void T (Testing testing) {
        Map<String, String> storingResults = storingResult.get(testing.getPackageId());
        if (storingResults == null) storingResults = new HashMap<>();

        String result;
        if (testing.geturrentResult().equals(testing.getExpectedResult()))
            result = "CURRENT RESULT AND EXPECTED RESULT ARE EQUAL! SUCCESS";
        else result = "CURRENT RESULT AND EXPECTED RESULT ARE NOT EQUAL! FAILURE!"
    }
    
}
