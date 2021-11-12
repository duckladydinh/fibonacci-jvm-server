package com.giathuan.examples.fibonacci;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class FibonacciServer {
  public static void main(String[] args) throws InterruptedException, IOException {
    System.out.println("FibonacciServer starting...");
    Server server =
        ServerBuilder.forPort(9999)
            .addService(ProtoReflectionService.newInstance())
            .addService(new FibonacciService())
            .build();
    server.start();
    server.awaitTermination();
  }
}
