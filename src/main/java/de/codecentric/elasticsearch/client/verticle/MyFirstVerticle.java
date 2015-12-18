package de.codecentric.elasticsearch.client.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyFirstVerticle extends AbstractVerticle {


    public static final int FALLBACK_PORT = 8080;

    public void start(Future<Void> future) {
        vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("<h1>Hello from my first Vert.x 3 application</h1>");
                })
                .listen(config().getInteger("http.port", FALLBACK_PORT),
                        result -> {
                            if (result.succeeded()) {
                                future.complete();
                            } else {
                                future.fail(result.cause());
                            }
                        });
    }

}
