// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: giathuan/examples/fibonacci/fibonacci.proto

package com.giathuan.examples.fibonacci;

/**
 * Protobuf type {@code giathuan.examples.fibonacci.Fibonacci}
 */
public final class Fibonacci extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:giathuan.examples.fibonacci.Fibonacci)
    FibonacciOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Fibonacci.newBuilder() to construct.
  private Fibonacci(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Fibonacci() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Fibonacci();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Fibonacci(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            index_ = input.readInt32();
            break;
          }
          case 16: {

            value_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.giathuan.examples.fibonacci.FibonacciProtos.internal_static_giathuan_examples_fibonacci_Fibonacci_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.giathuan.examples.fibonacci.FibonacciProtos.internal_static_giathuan_examples_fibonacci_Fibonacci_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.giathuan.examples.fibonacci.Fibonacci.class, com.giathuan.examples.fibonacci.Fibonacci.Builder.class);
  }

  public static final int INDEX_FIELD_NUMBER = 1;
  private int index_;
  /**
   * <pre>
   * A zero-based index pointing to the wanted Fibonacci number.
   * </pre>
   *
   * <code>int32 index = 1 [json_name = "index"];</code>
   * @return The index.
   */
  @java.lang.Override
  public int getIndex() {
    return index_;
  }

  public static final int VALUE_FIELD_NUMBER = 2;
  private long value_;
  /**
   * <pre>
   * The Fibonacci value corresponding to the related index.
   * </pre>
   *
   * <code>int64 value = 2 [json_name = "value"];</code>
   * @return The value.
   */
  @java.lang.Override
  public long getValue() {
    return value_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (index_ != 0) {
      output.writeInt32(1, index_);
    }
    if (value_ != 0L) {
      output.writeInt64(2, value_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (index_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, index_);
    }
    if (value_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, value_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.giathuan.examples.fibonacci.Fibonacci)) {
      return super.equals(obj);
    }
    com.giathuan.examples.fibonacci.Fibonacci other = (com.giathuan.examples.fibonacci.Fibonacci) obj;

    if (getIndex()
        != other.getIndex()) return false;
    if (getValue()
        != other.getValue()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + INDEX_FIELD_NUMBER;
    hash = (53 * hash) + getIndex();
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getValue());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.giathuan.examples.fibonacci.Fibonacci parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.giathuan.examples.fibonacci.Fibonacci prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code giathuan.examples.fibonacci.Fibonacci}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:giathuan.examples.fibonacci.Fibonacci)
      com.giathuan.examples.fibonacci.FibonacciOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.giathuan.examples.fibonacci.FibonacciProtos.internal_static_giathuan_examples_fibonacci_Fibonacci_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.giathuan.examples.fibonacci.FibonacciProtos.internal_static_giathuan_examples_fibonacci_Fibonacci_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.giathuan.examples.fibonacci.Fibonacci.class, com.giathuan.examples.fibonacci.Fibonacci.Builder.class);
    }

    // Construct using com.giathuan.examples.fibonacci.Fibonacci.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      index_ = 0;

      value_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.giathuan.examples.fibonacci.FibonacciProtos.internal_static_giathuan_examples_fibonacci_Fibonacci_descriptor;
    }

    @java.lang.Override
    public com.giathuan.examples.fibonacci.Fibonacci getDefaultInstanceForType() {
      return com.giathuan.examples.fibonacci.Fibonacci.getDefaultInstance();
    }

    @java.lang.Override
    public com.giathuan.examples.fibonacci.Fibonacci build() {
      com.giathuan.examples.fibonacci.Fibonacci result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.giathuan.examples.fibonacci.Fibonacci buildPartial() {
      com.giathuan.examples.fibonacci.Fibonacci result = new com.giathuan.examples.fibonacci.Fibonacci(this);
      result.index_ = index_;
      result.value_ = value_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.giathuan.examples.fibonacci.Fibonacci) {
        return mergeFrom((com.giathuan.examples.fibonacci.Fibonacci)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.giathuan.examples.fibonacci.Fibonacci other) {
      if (other == com.giathuan.examples.fibonacci.Fibonacci.getDefaultInstance()) return this;
      if (other.getIndex() != 0) {
        setIndex(other.getIndex());
      }
      if (other.getValue() != 0L) {
        setValue(other.getValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.giathuan.examples.fibonacci.Fibonacci parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.giathuan.examples.fibonacci.Fibonacci) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int index_ ;
    /**
     * <pre>
     * A zero-based index pointing to the wanted Fibonacci number.
     * </pre>
     *
     * <code>int32 index = 1 [json_name = "index"];</code>
     * @return The index.
     */
    @java.lang.Override
    public int getIndex() {
      return index_;
    }
    /**
     * <pre>
     * A zero-based index pointing to the wanted Fibonacci number.
     * </pre>
     *
     * <code>int32 index = 1 [json_name = "index"];</code>
     * @param value The index to set.
     * @return This builder for chaining.
     */
    public Builder setIndex(int value) {
      
      index_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A zero-based index pointing to the wanted Fibonacci number.
     * </pre>
     *
     * <code>int32 index = 1 [json_name = "index"];</code>
     * @return This builder for chaining.
     */
    public Builder clearIndex() {
      
      index_ = 0;
      onChanged();
      return this;
    }

    private long value_ ;
    /**
     * <pre>
     * The Fibonacci value corresponding to the related index.
     * </pre>
     *
     * <code>int64 value = 2 [json_name = "value"];</code>
     * @return The value.
     */
    @java.lang.Override
    public long getValue() {
      return value_;
    }
    /**
     * <pre>
     * The Fibonacci value corresponding to the related index.
     * </pre>
     *
     * <code>int64 value = 2 [json_name = "value"];</code>
     * @param value The value to set.
     * @return This builder for chaining.
     */
    public Builder setValue(long value) {
      
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The Fibonacci value corresponding to the related index.
     * </pre>
     *
     * <code>int64 value = 2 [json_name = "value"];</code>
     * @return This builder for chaining.
     */
    public Builder clearValue() {
      
      value_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:giathuan.examples.fibonacci.Fibonacci)
  }

  // @@protoc_insertion_point(class_scope:giathuan.examples.fibonacci.Fibonacci)
  private static final com.giathuan.examples.fibonacci.Fibonacci DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.giathuan.examples.fibonacci.Fibonacci();
  }

  public static com.giathuan.examples.fibonacci.Fibonacci getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Fibonacci>
      PARSER = new com.google.protobuf.AbstractParser<Fibonacci>() {
    @java.lang.Override
    public Fibonacci parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Fibonacci(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Fibonacci> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Fibonacci> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.giathuan.examples.fibonacci.Fibonacci getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
