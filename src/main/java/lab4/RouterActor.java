package lab4;

import akka.actor.ActorRef;
import akka.actor.Props;

public class RouterActor {

    private final int MAX_RETRIES = 10;

    public RouterActor() {
        storingResultActor = getContext().actorOf(Props.create())

    }
}