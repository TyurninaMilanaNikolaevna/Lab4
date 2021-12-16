package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class StoringResultActor extends AbstractActor {
    private final Map<String, Map<String, String>> storingResult = new HashMap<>();

    private void T (Testing testing) {
        Map<String, String> storingResults = storingResult.get(testing.getPackageId());
        if (storingResults == null) storingResults = new HashMap<>();

        String result;
        if (testing.geturrentResult().equals(testing.getExpectedResult()))
            result = "CURRENT RESULT AND EXPECTED RESULT ARE EQUAL! SUCCESS";
        else result = "CURRENT RESULT AND EXPECTED RESULT ARE NOT EQUAL! FAILURE!"
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder
                .create()
                .match(GetRequest.class, getRequest -> {
                    Map<String, String> storingResults = storingResult.get(getRequest.getPackageId());
                    if (storingResults == null) storingResults = new HashMap<>();
                }
                sender().tell(storingResults,  ActorRef.noSender());
                )
                .build();
    }

}
