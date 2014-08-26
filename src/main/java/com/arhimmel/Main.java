package com.arhimmel;

import org.vertx.java.core.Handler;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.platform.Verticle;

public class Main extends Verticle {

    @Override
    public void start() {
        final Logger logger = container.logger();

        logger.info("Starting up");

        container.deployModule("io.vertx~mod-web-server~2.0.0-final", container.config());

        vertx.setPeriodic(1000, new Handler<Long>() {
            @Override
            public void handle(Long event) {
                JsonObject json = new JsonObject();
                json.putString("test", "blah");
                vertx.eventBus().publish("chat.messages", json);
            }
        });
    }
}
