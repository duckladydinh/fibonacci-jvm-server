package com.giathuan.examples.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** ./gradlew test --tests com.giathuan.examples.fibonacci.FibonacciServiceTest. */
public final class FibonacciServiceTest {
  @Test
  public void dummy() {
    assertEquals(2, 1 + 1);
    Fibonacci fibonacci = Fibonacci.newBuilder().setIndex(0).setValue(1).build();
		assertEquals(1, fibonacci.getValue());
  }
}
