package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;

import java.util.ArrayList;
import java.util.List;

public class RouterActor extends AbstractActor {

    private final int CONST = 10;
    private final ActorRef storingResultActor;
    private final Router performingTestRouter;

    public RouterActor() {
        storingResultActor = getContext().actorOf(Props.create(StoringResultActor.class));

        List<Routee> routees = new ArrayList<>();
        for (int i = 0; i < CONST; i++) {
            ActorRef performingTestActor = getContext().actorOf(Props.create(PerformingTestActor.class));
            routees.add(new ActorRefRoutee(performingTestActor));
        }
        performingTestRouter = new Router(new RoundRobinRoutingLogic(), routees);
    }

    private void performingTest(PostRequest postRequest) {
        for (Testing testing : postRequest.getTestings()) {
            performingTestRouter.route(testing, storingResultActor);
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(PostRequest.class, postRequest -> performingTest(postRequest))
                .match(GetRequest.class, getRequest -> {
                    storingResultActor.tell(getRequest, sender());
                }).build();
    }
}