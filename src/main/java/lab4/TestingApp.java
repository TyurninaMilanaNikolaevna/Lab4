package lab4;


import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;

public class TestingApp {

    private ActorRef router;

    public TestingApp(ActorRef router) {
        this.router = router;
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("lab4");
        ActorRef router = system.actorOf(Props.create(RouterActor.class));

        final Http http = Http.get(system);
        final ActorMaterializer actorMaterializer = ActorMaterializer.create(system);

        TestingApp instance = new TestingApp(router);

        final Flow<HttpRequest, HttpResponse, NotUsed>

    }
}