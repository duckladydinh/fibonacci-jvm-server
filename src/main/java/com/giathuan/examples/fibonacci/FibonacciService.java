package com.giathuan.examples.fibonacci;

import com.giathuan.examples.fibonacci.FibonacciServiceGrpc.FibonacciServiceImplBase;
import io.grpc.stub.StreamObserver;

/** ./gradlew run .*/
public final class FibonacciService extends FibonacciServiceImplBase {
  @Override
  public void getFibonacci(
      GetFibonacciRequest request, StreamObserver<Fibonacci> responseObserver) {
    int n = request.getIndex();
    if (n <= 1) {
      responseObserver.onNext(Fibonacci.newBuilder().setIndex(n).setValue(n).build());
      responseObserver.onCompleted();
      return;
    }

    long prv = 0;
    long cur = 1;
    for (int i = 2; i <= n; ++i) {
      long nxt = prv + cur;
      prv = cur;
      cur = nxt;
    }
    responseObserver.onNext(Fibonacci.newBuilder().setIndex(n).setValue(cur).build());
    responseObserver.onCompleted();
  }
}
