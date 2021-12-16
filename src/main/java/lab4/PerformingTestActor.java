package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.*;
import java.io.Reader;

public class PerformingTestActor {

    public class StoringResultActor extends AbstractActor {
        public String performingTest(Testing testing) throws ScriptException, NoSuchMethodException {
            ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
            scriptEngine.eval(testing.getJsScript());
            Invocable invocable = (Invocable) scriptEngine;

            String testResult = invocable.invokeFunction(testing.getFunctionName(),
                    testing.getParameters().toArray()).toString();
            return testResult;
        }

        @Override
        public Receive createReceive() {
            return ReceiveBuilder.create()
                    .match(Testing.class, message -> {
                        message.setCurrentResult(performingTest(message));
                        sender().tell(message, self());
                    }).build();
        }

    }
}