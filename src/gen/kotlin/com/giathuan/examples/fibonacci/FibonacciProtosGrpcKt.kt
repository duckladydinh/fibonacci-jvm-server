package com.giathuan.examples.fibonacci

import com.giathuan.examples.fibonacci.FibonacciServiceGrpc.getServiceDescriptor
import io.grpc.*
import io.grpc.CallOptions.DEFAULT
import io.grpc.ServerServiceDefinition.builder
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * giathuan.examples.fibonacci.FibonacciService.
 */
object FibonacciServiceGrpcKt {
    const val SERVICE_NAME: String = FibonacciServiceGrpc.SERVICE_NAME

    @JvmStatic
    val serviceDescriptor: ServiceDescriptor
        get() = FibonacciServiceGrpc.getServiceDescriptor()

    val getFibonacciMethod: MethodDescriptor<GetFibonacciRequest, Fibonacci>
        @JvmStatic
        get() = FibonacciServiceGrpc.getGetFibonacciMethod()

    /**
     * A stub for issuing RPCs to a(n) giathuan.examples.fibonacci.FibonacciService service as
     * suspending coroutines.
     */
    @StubFor(FibonacciServiceGrpc::class)
    class FibonacciServiceCoroutineStub @JvmOverloads constructor(
        channel: Channel,
        callOptions: CallOptions = DEFAULT
    ) : AbstractCoroutineStub<FibonacciServiceCoroutineStub>(channel, callOptions) {
        override fun build(channel: Channel, callOptions: CallOptions): FibonacciServiceCoroutineStub =
            FibonacciServiceCoroutineStub(channel, callOptions)

        /**
         * Executes this RPC and returns the response message, suspending until the RPC completes
         * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
         * corresponding
         * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
         * with the corresponding exception as a cause.
         *
         * @param request The request message to send to the server.
         *
         * @param headers Metadata to attach to the request.  Most users will not need this.
         *
         * @return The single response from the server.
         */
        suspend fun getFibonacci(request: GetFibonacciRequest, headers: Metadata = Metadata()):
                Fibonacci = unaryRpc(
            channel,
            FibonacciServiceGrpc.getGetFibonacciMethod(),
            request,
            callOptions,
            headers
        )
    }

    /**
     * Skeletal implementation of the giathuan.examples.fibonacci.FibonacciService service based on
     * Kotlin coroutines.
     */
    abstract class FibonacciServiceCoroutineImplBase(
        coroutineContext: CoroutineContext = EmptyCoroutineContext
    ) : AbstractCoroutineServerImpl(coroutineContext) {
        /**
         * Returns the response to an RPC for giathuan.examples.fibonacci.FibonacciService.GetFibonacci.
         *
         * If this method fails with a [StatusException], the RPC will fail with the corresponding
         * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
         * the RPC will fail
         * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
         * fail with `Status.UNKNOWN` with the exception as a cause.
         *
         * @param request The request from the client.
         */
        open suspend fun getFibonacci(request: GetFibonacciRequest): Fibonacci = throw
        StatusException(UNIMPLEMENTED.withDescription("Method giathuan.examples.fibonacci.FibonacciService.GetFibonacci is unimplemented"))

        final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
            .addMethod(
                unaryServerMethodDefinition(
                    context = this.context,
                    descriptor = FibonacciServiceGrpc.getGetFibonacciMethod(),
                    implementation = ::getFibonacci
                )
            ).build()
    }
}
