package lab4;

import akka.actor.ActorRef;
import akka.actor.Props;

public class RouterActor {

    private final ActorRef storingResultActor;

    public RouterActor() {
        storingResultActor = getContext().actorOf(Props.create(StoringResultActor.class));

    

    }
}