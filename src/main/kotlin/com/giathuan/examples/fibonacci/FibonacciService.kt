package com.giathuan.examples.fibonacci

import com.giathuan.examples.fibonacci.FibonacciServiceGrpcKt.FibonacciServiceCoroutineImplBase
import com.google.common.flogger.FluentLogger
import com.google.rpc.Code
import com.google.rpc.Status
import io.grpc.protobuf.StatusProto

/** ./gradlew run .  */
class FibonacciService : FibonacciServiceCoroutineImplBase() {
    companion object {
        @JvmStatic
        private val LOGGER = FluentLogger.forEnclosingClass()
    }

    override suspend fun getFibonacci(request: GetFibonacciRequest): Fibonacci {
        LOGGER.atInfo().log("Receiving GetFibonacciRequest: %s", request)

        val n = request.index
        if (n < 1) {
            throw StatusProto.toStatusException(
                Status.newBuilder()
                    .setCode(Code.INVALID_ARGUMENT_VALUE)
                    .setMessage("Value of request.index cannot be less than 1.")
                    .build()
            )
        }

        var prv = 0L
        var cur = 1L
        for (i in 2..n) {
            val nxt = prv + cur
            prv = cur
            cur = nxt
        }
        return Fibonacci.newBuilder().setIndex(n).setValue(cur).build()
    }
}