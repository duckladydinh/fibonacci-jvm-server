package com.giathuan.examples.fibonacci.v1;

import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** ./gradlew test --tests com.giathuan.examples.fibonacci.FibonacciServiceComposeTest. */
@Testcontainers
public final class FibonacciServiceComposeTest {
  private static final int FIBONACCI_JVM_SERVER_PORT = 9999;
  private static final String FIBONACCI_JVM_SERVER_NAME = "fibonacci-jvm-server_1";

  @Container
  public static DockerComposeContainer<?> environment =
      new DockerComposeContainer<>(new File("docker-compose.yml"))
          .withExposedService(FIBONACCI_JVM_SERVER_NAME, FIBONACCI_JVM_SERVER_PORT);

  private static FibonacciServiceGrpc.FibonacciServiceBlockingStub stub;

  @BeforeAll
  public static void setup() {
    String serviceHost =
        environment.getServiceHost(FIBONACCI_JVM_SERVER_NAME, FIBONACCI_JVM_SERVER_PORT);
    int servicePort =
        environment.getServicePort(FIBONACCI_JVM_SERVER_NAME, FIBONACCI_JVM_SERVER_PORT);

    stub =
        FibonacciServiceGrpc.newBlockingStub(
            ManagedChannelBuilder.forTarget(String.format("%s:%s", serviceHost, servicePort))
                .usePlaintext()
                .build());
  }

  @Test
  public void getFibonacci_validIndex_returnsExpectedValue() {
    GetFibonacciResponse resp =
        stub.getFibonacci(GetFibonacciRequest.newBuilder().setIndex(12).build());

    assertEquals(144, resp.getValue());
  }

  @Test
  public void getFibonacci_invalidIndex_throwsInvalidArgument() {
    //noinspection ResultOfMethodCallIgnored
    StatusRuntimeException e =
        assertThrows(
            StatusRuntimeException.class,
            () -> stub.getFibonacci(GetFibonacciRequest.newBuilder().setIndex(-1).build()));

    assertEquals(Status.Code.INVALID_ARGUMENT, e.getStatus().getCode());
  }
}
