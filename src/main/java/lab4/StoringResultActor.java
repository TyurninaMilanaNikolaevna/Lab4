package lab4;

import java.util.HashMap;
import java.util.Map;

public class StoringResultActor {
    private final Map<String, Map<String, String>> storingResult = new HashMap<>();

    private void T (Testing testing) {
        Map<String, String> results = storingResult.get(testing.getPackageId());
        if (results == null) results = new HashMap<>();

        String result = (testing.get)
    }


}
