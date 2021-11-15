package com.giathuan.examples.fibonacci;

import io.grpc.Server;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** ./gradlew test --tests com.giathuan.examples.fibonacci.FibonacciServiceTest. */
public final class FibonacciServiceTest {
  @Test
  public void getFibonacci_validIndex_returnsExpectedValue() throws IOException {
    // arrange
    String srvName = InProcessServerBuilder.generateName();

    Server server =
        InProcessServerBuilder.forName(srvName)
            .directExecutor()
            .addService(ProtoReflectionService.newInstance())
            .addService(new FibonacciService())
            .build();
    server.start();

    FibonacciServiceGrpc.FibonacciServiceBlockingStub stub =
        FibonacciServiceGrpc.newBlockingStub(
            InProcessChannelBuilder.forName(srvName).directExecutor().build());

    // act
    Fibonacci fibonacci = stub.getFibonacci(GetFibonacciRequest.newBuilder().setIndex(12).build());

    // assert
    assertEquals(144, fibonacci.getValue());
  }

  @Test
  public void getFibonacci_invalidIndex_throwsInvalidArgument() throws IOException {
    // arrange
    String srvName = InProcessServerBuilder.generateName();

    Server server =
        InProcessServerBuilder.forName(srvName)
            .directExecutor()
            .addService(ProtoReflectionService.newInstance())
            .addService(new FibonacciService())
            .build();
    server.start();

    FibonacciServiceGrpc.FibonacciServiceBlockingStub stub =
        FibonacciServiceGrpc.newBlockingStub(
            InProcessChannelBuilder.forName(srvName).directExecutor().build());

    // act
    //noinspection ResultOfMethodCallIgnored
    StatusRuntimeException e =
        assertThrows(
            StatusRuntimeException.class,
            () -> stub.getFibonacci(GetFibonacciRequest.newBuilder().setIndex(-1).build()));

    // assert
    assertEquals(Code.INVALID_ARGUMENT, e.getStatus().getCode());
  }
}
