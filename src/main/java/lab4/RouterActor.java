package lab4;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.Routee;

import java.util.ArrayList;

public class RouterActor {

    private final ActorRef storingResultActor;

    public RouterActor() {
        storingResultActor = getContext().actorOf(Props.create(StoringResultActor.class));

        List<Routee> routees = new ArrayList<>();


    }
}