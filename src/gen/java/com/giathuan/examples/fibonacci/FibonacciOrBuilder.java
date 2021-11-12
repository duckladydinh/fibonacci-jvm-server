// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: giathuan/examples/fibonacci/fibonacci.proto

package com.giathuan.examples.fibonacci;

public interface FibonacciOrBuilder extends
    // @@protoc_insertion_point(interface_extends:giathuan.examples.fibonacci.Fibonacci)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * A zero-based index pointing to the wanted Fibonacci number.
   * </pre>
   *
   * <code>int32 index = 1 [json_name = "index"];</code>
   * @return The index.
   */
  int getIndex();

  /**
   * <pre>
   * The Fibonacci value corresponding to the related index.
   * </pre>
   *
   * <code>int64 value = 2 [json_name = "value"];</code>
   * @return The value.
   */
  long getValue();
}
