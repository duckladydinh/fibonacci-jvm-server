package com.giathuan.examples.fibonacci;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class FibonacciServer {
  public static void main(String[] args) throws InterruptedException, IOException {
    int port = 9999;
    System.out.printf("FibonacciServer starting at port :%d...\n", port);

    Server server =
        ServerBuilder.forPort(port)
            .addService(ProtoReflectionService.newInstance())
            .addService(new FibonacciService())
            .build();
    server.start();
    server.awaitTermination();
  }
}
