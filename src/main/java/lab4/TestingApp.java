package lab4;


import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;

public class TestingApp {

    private ActorRef router;

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("lab4");
        ActorRef router = system.actorOf(Props.create(RouterActor.class));

        final Http http = Http.get(system);

    }
}