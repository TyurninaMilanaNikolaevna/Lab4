package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.ActorRefRoutee;
import akka.routing.Routee;

import java.util.ArrayList;
import java.util.List;

public class RouterActor extends AbstractActor {

    private final int CONST = 10;
    private final ActorRef storingResultActor;

    public RouterActor() {
        storingResultActor = getContext().actorOf(Props.create(StoringResultActor.class));

        List<Routee> routees = new ArrayList<>();
        for (int i = 0; i < CONST; i++) {
            ActorRef performingResultActor = getContext().
                    actorOf(Props.create(PerformingTestActor.class));
            routees.add(new ActorRefRoutee(performingResultActor));
        }

    }

    private void performingTest(PostRequest)

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(PostRequest.class, postRequest -> ).build();
    }
}