package lab4;


import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.concurrent.Future;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.util.Timeout;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;

public class TestingApp {

    private ActorRef router;

    public TestingApp(ActorRef router) {
        this.router = router;
    }

    public static void main(String[] args) throws IOException {
        ActorSystem actorSystem = ActorSystem.create("lab4");
        ActorRef router = actorSystem.actorOf(Props.create(RouterActor.class));

        final Http http = Http.get(actorSystem);
        final ActorMaterializer actorMaterializer = ActorMaterializer.create(actorSystem);

        TestingApp instance = new TestingApp(router);

        final Flow<HttpRequest, HttpResponse, NotUsed>
                routeFlow = instance.createRoute().flow(actorSystem, actorMaterializer);

        final CompletionStage<ServerBinding> bindingCompletionStage = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8080),
                actorMaterializer
        );

        System.out.println("Listening in port: 8080 ");
        System.in.read();
        bindingCompletionStage.thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> actorSystem.terminate());
    }

    private Route createRoute() {
        return route(
                get(
                        () -> parameter("packageId", (id) -> {
                            Future<Object> result = Patterns.ask(RouterActor.class, new GetRequest(id), Timeout.create(Duration.ofSeconds(5)));
                            return completeOKWithFutute(result, Jackson.marshaller());
                        })),
                post(
                        () -> entity(Jackson.unmarshaller(PostRequest.class), msg -> {
                            router.tell(msg, ActorRef.noSender());
                            return complete("Start test");
                    }
                )
        );
    }

}