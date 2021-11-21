package com.giathuan.examples.fibonacci.v1;

import com.google.common.flogger.FluentLogger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class FibonacciServer {
  private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();

  public static void main(String[] args) throws InterruptedException, IOException {
    int port = 9999;
    LOGGER.atInfo().log("FibonacciServer starting at port :%d...\n", port);

    Server server =
        ServerBuilder.forPort(port)
            .addService(ProtoReflectionService.newInstance())
            .addService(new FibonacciService())
            .build();
    server.start();
    server.awaitTermination();
  }
}
