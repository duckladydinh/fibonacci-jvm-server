package com.giathuan.examples.fibonacci.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A sample FibonacciService.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: giathuan/examples/fibonacci/v1/fibonacci.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FibonacciServiceGrpc {

  private FibonacciServiceGrpc() {}

  public static final String SERVICE_NAME = "giathuan.examples.fibonacci.v1.FibonacciService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.giathuan.examples.fibonacci.v1.GetFibonacciRequest,
      com.giathuan.examples.fibonacci.v1.GetFibonacciResponse> getGetFibonacciMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFibonacci",
      requestType = com.giathuan.examples.fibonacci.v1.GetFibonacciRequest.class,
      responseType = com.giathuan.examples.fibonacci.v1.GetFibonacciResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.giathuan.examples.fibonacci.v1.GetFibonacciRequest,
      com.giathuan.examples.fibonacci.v1.GetFibonacciResponse> getGetFibonacciMethod() {
    io.grpc.MethodDescriptor<com.giathuan.examples.fibonacci.v1.GetFibonacciRequest, com.giathuan.examples.fibonacci.v1.GetFibonacciResponse> getGetFibonacciMethod;
    if ((getGetFibonacciMethod = FibonacciServiceGrpc.getGetFibonacciMethod) == null) {
      synchronized (FibonacciServiceGrpc.class) {
        if ((getGetFibonacciMethod = FibonacciServiceGrpc.getGetFibonacciMethod) == null) {
          FibonacciServiceGrpc.getGetFibonacciMethod = getGetFibonacciMethod =
              io.grpc.MethodDescriptor.<com.giathuan.examples.fibonacci.v1.GetFibonacciRequest, com.giathuan.examples.fibonacci.v1.GetFibonacciResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFibonacci"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giathuan.examples.fibonacci.v1.GetFibonacciRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giathuan.examples.fibonacci.v1.GetFibonacciResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FibonacciServiceMethodDescriptorSupplier("GetFibonacci"))
              .build();
        }
      }
    }
    return getGetFibonacciMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FibonacciServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FibonacciServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FibonacciServiceStub>() {
        @java.lang.Override
        public FibonacciServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FibonacciServiceStub(channel, callOptions);
        }
      };
    return FibonacciServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FibonacciServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FibonacciServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FibonacciServiceBlockingStub>() {
        @java.lang.Override
        public FibonacciServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FibonacciServiceBlockingStub(channel, callOptions);
        }
      };
    return FibonacciServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FibonacciServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FibonacciServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FibonacciServiceFutureStub>() {
        @java.lang.Override
        public FibonacciServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FibonacciServiceFutureStub(channel, callOptions);
        }
      };
    return FibonacciServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A sample FibonacciService.
   * </pre>
   */
  public static abstract class FibonacciServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Get a Fibonacci number specified by its index.
     * </pre>
     */
    public void getFibonacci(com.giathuan.examples.fibonacci.v1.GetFibonacciRequest request,
        io.grpc.stub.StreamObserver<com.giathuan.examples.fibonacci.v1.GetFibonacciResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFibonacciMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFibonacciMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.giathuan.examples.fibonacci.v1.GetFibonacciRequest,
                com.giathuan.examples.fibonacci.v1.GetFibonacciResponse>(
                  this, METHODID_GET_FIBONACCI)))
          .build();
    }
  }

  /**
   * <pre>
   * A sample FibonacciService.
   * </pre>
   */
  public static final class FibonacciServiceStub extends io.grpc.stub.AbstractAsyncStub<FibonacciServiceStub> {
    private FibonacciServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FibonacciServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FibonacciServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get a Fibonacci number specified by its index.
     * </pre>
     */
    public void getFibonacci(com.giathuan.examples.fibonacci.v1.GetFibonacciRequest request,
        io.grpc.stub.StreamObserver<com.giathuan.examples.fibonacci.v1.GetFibonacciResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFibonacciMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A sample FibonacciService.
   * </pre>
   */
  public static final class FibonacciServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FibonacciServiceBlockingStub> {
    private FibonacciServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FibonacciServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FibonacciServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get a Fibonacci number specified by its index.
     * </pre>
     */
    public com.giathuan.examples.fibonacci.v1.GetFibonacciResponse getFibonacci(com.giathuan.examples.fibonacci.v1.GetFibonacciRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFibonacciMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A sample FibonacciService.
   * </pre>
   */
  public static final class FibonacciServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FibonacciServiceFutureStub> {
    private FibonacciServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FibonacciServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FibonacciServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get a Fibonacci number specified by its index.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.giathuan.examples.fibonacci.v1.GetFibonacciResponse> getFibonacci(
        com.giathuan.examples.fibonacci.v1.GetFibonacciRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFibonacciMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FIBONACCI = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FibonacciServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FibonacciServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FIBONACCI:
          serviceImpl.getFibonacci((com.giathuan.examples.fibonacci.v1.GetFibonacciRequest) request,
              (io.grpc.stub.StreamObserver<com.giathuan.examples.fibonacci.v1.GetFibonacciResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FibonacciServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FibonacciServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.giathuan.examples.fibonacci.v1.FibonacciProtos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FibonacciService");
    }
  }

  private static final class FibonacciServiceFileDescriptorSupplier
      extends FibonacciServiceBaseDescriptorSupplier {
    FibonacciServiceFileDescriptorSupplier() {}
  }

  private static final class FibonacciServiceMethodDescriptorSupplier
      extends FibonacciServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FibonacciServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FibonacciServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FibonacciServiceFileDescriptorSupplier())
              .addMethod(getGetFibonacciMethod())
              .build();
        }
      }
    }
    return result;
  }
}
