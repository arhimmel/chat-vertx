package com.arhimmel;

import org.vertx.java.core.logging.Logger;
import org.vertx.java.platform.Verticle;

public class Main extends Verticle {

    @Override
    public void start() {

        final Logger logger = container.logger();

        logger.info("Starting up");

        container.deployModule("io.vertx~mod-web-server~2.0.0-final", container.config());

    }
}
