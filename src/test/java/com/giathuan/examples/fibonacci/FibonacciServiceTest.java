package com.giathuan.examples.fibonacci;

import io.grpc.Server;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** ./gradlew test --tests com.giathuan.examples.fibonacci.FibonacciServiceTest. */
public final class FibonacciServiceTest {

  private static FibonacciServiceGrpc.FibonacciServiceBlockingStub stub;

  @BeforeAll
  public static void setup() throws IOException {
    String srvName = InProcessServerBuilder.generateName();

    Server server =
        InProcessServerBuilder.forName(srvName)
            .directExecutor()
            .addService(ProtoReflectionService.newInstance())
            .addService(new FibonacciService())
            .build();
    server.start();

    stub =
        FibonacciServiceGrpc.newBlockingStub(
            InProcessChannelBuilder.forName(srvName).directExecutor().build());
  }

  @Test
  public void getFibonacci_validIndex_returnsExpectedValue() {
    Fibonacci fibonacci = stub.getFibonacci(GetFibonacciRequest.newBuilder().setIndex(12).build());

    assertEquals(144, fibonacci.getValue());
  }

  @Test
  public void getFibonacci_invalidIndex_throwsInvalidArgument() {
    //noinspection ResultOfMethodCallIgnored
    StatusRuntimeException e =
        assertThrows(
            StatusRuntimeException.class,
            () -> stub.getFibonacci(GetFibonacciRequest.newBuilder().setIndex(-1).build()));

    assertEquals(Code.INVALID_ARGUMENT, e.getStatus().getCode());
  }
}
