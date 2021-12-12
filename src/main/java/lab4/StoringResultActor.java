package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class StoringResultActor extends AbstractActor{
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(Testing.class, message -> {
                    testing.setReceivedResult()
                    sender().tell(testing, self())
                })
    }
}