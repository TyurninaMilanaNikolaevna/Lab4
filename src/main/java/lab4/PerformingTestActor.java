package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.*;
import java.io.Reader;

public class PerformingTestActor {

    public class StoringResultActor extends AbstractActor {
        @Override
        public Receive createReceive() {
            return ReceiveBuilder.create()
                    .match(Testing.class, message -> {
                        testing.setReceivedResult(execute(test));
                        sender().tell(testing, self())
                    })
        }

        public String perform(Testing testing) {
            ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn")

                @Override
                public Object eval(Reader reader, ScriptContext context) throws ScriptException {
                    return null;
                }

                @Override
                public Object eval(String script) throws ScriptException {
                    return null;
                }

                @Override
                public Object eval(Reader reader) throws ScriptException {
                    return null;
                }

                @Override
                public Object eval(String script, Bindings n) throws ScriptException {
                    return null;
                }

                @Override
                public Object eval(Reader reader, Bindings n) throws ScriptException {
                    return null;
                }

                @Override
                public void put(String key, Object value) {

                }

                @Override
                public Object get(String key) {
                    return null;
                }

                @Override
                public Bindings getBindings(int scope) {
                    return null;
                }

                @Override
                public void setBindings(Bindings bindings, int scope) {

                }

                @Override
                public Bindings createBindings() {
                    return null;
                }

                @Override
                public ScriptContext getContext() {
                    return null;
                }

                @Override
                public void setContext(ScriptContext context) {

                }

                @Override
                public ScriptEngineFactory getFactory() {
                    return null;
                }
            }
        }
    }
}