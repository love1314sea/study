// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: student.proto

package netty.使用protobuf;

public final class StudentOuterClass {
  private StudentOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface StudentOrBuilder extends
      // @@protoc_insertion_point(interface_extends:test.model.protobuf.Student)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string name = 1;</code>
     */
    String getName();
    /**
     * <code>optional string name = 1;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>optional int32 age = 2;</code>
     */
    int getAge();

    /**
     * <code>optional string sex = 3;</code>
     */
    String getSex();
    /**
     * <code>optional string sex = 3;</code>
     */
    com.google.protobuf.ByteString
        getSexBytes();

    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */
    int getMapCount();
    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */
    boolean containsMap(
                               String key);
    /**
     * Use {@link #getMapMap()} instead.
     */
    @Deprecated
    java.util.Map<String, String>
    getMap();
    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */
    java.util.Map<String, String>
    getMapMap();
    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */

    String getMapOrDefault(
                                  String key,
                                  String defaultValue);
    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */

    String getMapOrThrow(
                                String key);

    /**
     * <code>repeated string lesssons = 5;</code>
     */
    java.util.List<String>
        getLesssonsList();
    /**
     * <code>repeated string lesssons = 5;</code>
     */
    int getLesssonsCount();
    /**
     * <code>repeated string lesssons = 5;</code>
     */
    String getLesssons(int index);
    /**
     * <code>repeated string lesssons = 5;</code>
     */
    com.google.protobuf.ByteString
        getLesssonsBytes(int index);
  }
  /**
   * Protobuf type {@code test.model.protobuf.Student}
   */
  public  static final class Student extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:test.model.protobuf.Student)
      StudentOrBuilder {
    // Use Student.newBuilder() to construct.
    private Student(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Student() {
      name_ = "";
      age_ = 0;
      sex_ = "";
      lesssons_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Student(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 16: {

              age_ = input.readInt32();
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              sex_ = s;
              break;
            }
            case 34: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                map_ = com.google.protobuf.MapField.newMapField(
                    MapDefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000008;
              }
              com.google.protobuf.MapEntry<String, String>
              map__ = input.readMessage(
                  MapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              map_.getMutableMap().put(
                  map__.getKey(), map__.getValue());
              break;
            }
            case 42: {
              String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                lesssons_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000010;
              }
              lesssons_.add(s);
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
        if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
          lesssons_ = lesssons_.getUnmodifiableView();
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return internal_static_test_model_protobuf_Student_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 4:
          return internalGetMap();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return internal_static_test_model_protobuf_Student_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              netty.使用protobuf.StudentOuterClass.Student.class, netty.使用protobuf.StudentOuterClass.Student.Builder.class);
    }

    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    /**
     * <code>optional string name = 1;</code>
     */
    public String getName() {
      Object ref = name_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int AGE_FIELD_NUMBER = 2;
    private int age_;
    /**
     * <code>optional int32 age = 2;</code>
     */
    public int getAge() {
      return age_;
    }

    public static final int SEX_FIELD_NUMBER = 3;
    private volatile Object sex_;
    /**
     * <code>optional string sex = 3;</code>
     */
    public String getSex() {
      Object ref = sex_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        sex_ = s;
        return s;
      }
    }
    /**
     * <code>optional string sex = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSexBytes() {
      Object ref = sex_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        sex_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MAP_FIELD_NUMBER = 4;
    private static final class MapDefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          String, String> defaultEntry =
              com.google.protobuf.MapEntry
              .<String, String>newDefaultInstance(
                      internal_static_test_model_protobuf_Student_MapEntry_descriptor,
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "");
    }
    private com.google.protobuf.MapField<
        String, String> map_;
    private com.google.protobuf.MapField<String, String>
    internalGetMap() {
      if (map_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            MapDefaultEntryHolder.defaultEntry);
      }
      return map_;
    }

    public int getMapCount() {
      return internalGetMap().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */

    public boolean containsMap(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      return internalGetMap().getMap().containsKey(key);
    }
    /**
     * Use {@link #getMapMap()} instead.
     */
    @Deprecated
    public java.util.Map<String, String> getMap() {
      return getMapMap();
    }
    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */

    public java.util.Map<String, String> getMapMap() {
      return internalGetMap().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */

    public String getMapOrDefault(
        String key,
        String defaultValue) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetMap().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; map = 4;</code>
     */

    public String getMapOrThrow(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetMap().getMap();
      if (!map.containsKey(key)) {
        throw new IllegalArgumentException();
      }
      return map.get(key);
    }

    public static final int LESSSONS_FIELD_NUMBER = 5;
    private com.google.protobuf.LazyStringList lesssons_;
    /**
     * <code>repeated string lesssons = 5;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getLesssonsList() {
      return lesssons_;
    }
    /**
     * <code>repeated string lesssons = 5;</code>
     */
    public int getLesssonsCount() {
      return lesssons_.size();
    }
    /**
     * <code>repeated string lesssons = 5;</code>
     */
    public String getLesssons(int index) {
      return lesssons_.get(index);
    }
    /**
     * <code>repeated string lesssons = 5;</code>
     */
    public com.google.protobuf.ByteString
        getLesssonsBytes(int index) {
      return lesssons_.getByteString(index);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
      }
      if (age_ != 0) {
        output.writeInt32(2, age_);
      }
      if (!getSexBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, sex_);
      }
      com.google.protobuf.GeneratedMessageV3
        .serializeStringMapTo(
          output,
          internalGetMap(),
          MapDefaultEntryHolder.defaultEntry,
          4);
      for (int i = 0; i < lesssons_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, lesssons_.getRaw(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
      }
      if (age_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, age_);
      }
      if (!getSexBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, sex_);
      }
      for (java.util.Map.Entry<String, String> entry
           : internalGetMap().getMap().entrySet()) {
        com.google.protobuf.MapEntry<String, String>
        map__ = MapDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(4, map__);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < lesssons_.size(); i++) {
          dataSize += computeStringSizeNoTag(lesssons_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getLesssonsList().size();
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof netty.使用protobuf.StudentOuterClass.Student)) {
        return super.equals(obj);
      }
      netty.使用protobuf.StudentOuterClass.Student other = (netty.使用protobuf.StudentOuterClass.Student) obj;

      boolean result = true;
      result = result && getName()
          .equals(other.getName());
      result = result && (getAge()
          == other.getAge());
      result = result && getSex()
          .equals(other.getSex());
      result = result && internalGetMap().equals(
          other.internalGetMap());
      result = result && getLesssonsList()
          .equals(other.getLesssonsList());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + AGE_FIELD_NUMBER;
      hash = (53 * hash) + getAge();
      hash = (37 * hash) + SEX_FIELD_NUMBER;
      hash = (53 * hash) + getSex().hashCode();
      if (!internalGetMap().getMap().isEmpty()) {
        hash = (37 * hash) + MAP_FIELD_NUMBER;
        hash = (53 * hash) + internalGetMap().hashCode();
      }
      if (getLesssonsCount() > 0) {
        hash = (37 * hash) + LESSSONS_FIELD_NUMBER;
        hash = (53 * hash) + getLesssonsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static netty.使用protobuf.StudentOuterClass.Student parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static netty.使用protobuf.StudentOuterClass.Student parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(netty.使用protobuf.StudentOuterClass.Student prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code test.model.protobuf.Student}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:test.model.protobuf.Student)
        netty.使用protobuf.StudentOuterClass.StudentOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return internal_static_test_model_protobuf_Student_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(
          int number) {
        switch (number) {
          case 4:
            return internalGetMap();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMutableMapField(
          int number) {
        switch (number) {
          case 4:
            return internalGetMutableMap();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return internal_static_test_model_protobuf_Student_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                netty.使用protobuf.StudentOuterClass.Student.class, netty.使用protobuf.StudentOuterClass.Student.Builder.class);
      }

      // Construct using netty.使用protobuf.StudentOuterClass.Student.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        name_ = "";

        age_ = 0;

        sex_ = "";

        internalGetMutableMap().clear();
        lesssons_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return internal_static_test_model_protobuf_Student_descriptor;
      }

      public netty.使用protobuf.StudentOuterClass.Student getDefaultInstanceForType() {
        return getDefaultInstance();
      }

      public netty.使用protobuf.StudentOuterClass.Student build() {
        netty.使用protobuf.StudentOuterClass.Student result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public netty.使用protobuf.StudentOuterClass.Student buildPartial() {
        netty.使用protobuf.StudentOuterClass.Student result = new netty.使用protobuf.StudentOuterClass.Student(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.name_ = name_;
        result.age_ = age_;
        result.sex_ = sex_;
        result.map_ = internalGetMap();
        result.map_.makeImmutable();
        if (((bitField0_ & 0x00000010) == 0x00000010)) {
          lesssons_ = lesssons_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.lesssons_ = lesssons_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof netty.使用protobuf.StudentOuterClass.Student) {
          return mergeFrom((netty.使用protobuf.StudentOuterClass.Student)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(netty.使用protobuf.StudentOuterClass.Student other) {
        if (other == getDefaultInstance()) return this;
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (other.getAge() != 0) {
          setAge(other.getAge());
        }
        if (!other.getSex().isEmpty()) {
          sex_ = other.sex_;
          onChanged();
        }
        internalGetMutableMap().mergeFrom(
            other.internalGetMap());
        if (!other.lesssons_.isEmpty()) {
          if (lesssons_.isEmpty()) {
            lesssons_ = other.lesssons_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureLesssonsIsMutable();
            lesssons_.addAll(other.lesssons_);
          }
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        netty.使用protobuf.StudentOuterClass.Student parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (netty.使用protobuf.StudentOuterClass.Student) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private Object name_ = "";
      /**
       * <code>optional string name = 1;</code>
       */
      public String getName() {
        Object ref = name_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string name = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string name = 1;</code>
       */
      public Builder setName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string name = 1;</code>
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string name = 1;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private int age_ ;
      /**
       * <code>optional int32 age = 2;</code>
       */
      public int getAge() {
        return age_;
      }
      /**
       * <code>optional int32 age = 2;</code>
       */
      public Builder setAge(int value) {
        
        age_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 age = 2;</code>
       */
      public Builder clearAge() {
        
        age_ = 0;
        onChanged();
        return this;
      }

      private Object sex_ = "";
      /**
       * <code>optional string sex = 3;</code>
       */
      public String getSex() {
        Object ref = sex_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          sex_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string sex = 3;</code>
       */
      public com.google.protobuf.ByteString
          getSexBytes() {
        Object ref = sex_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          sex_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string sex = 3;</code>
       */
      public Builder setSex(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        sex_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string sex = 3;</code>
       */
      public Builder clearSex() {
        
        sex_ = getDefaultInstance().getSex();
        onChanged();
        return this;
      }
      /**
       * <code>optional string sex = 3;</code>
       */
      public Builder setSexBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        sex_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.MapField<
          String, String> map_;
      private com.google.protobuf.MapField<String, String>
      internalGetMap() {
        if (map_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              MapDefaultEntryHolder.defaultEntry);
        }
        return map_;
      }
      private com.google.protobuf.MapField<String, String>
      internalGetMutableMap() {
        onChanged();;
        if (map_ == null) {
          map_ = com.google.protobuf.MapField.newMapField(
              MapDefaultEntryHolder.defaultEntry);
        }
        if (!map_.isMutable()) {
          map_ = map_.copy();
        }
        return map_;
      }

      public int getMapCount() {
        return internalGetMap().getMap().size();
      }
      /**
       * <code>map&lt;string, string&gt; map = 4;</code>
       */

      public boolean containsMap(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        return internalGetMap().getMap().containsKey(key);
      }
      /**
       * Use {@link #getMapMap()} instead.
       */
      @Deprecated
      public java.util.Map<String, String> getMap() {
        return getMapMap();
      }
      /**
       * <code>map&lt;string, string&gt; map = 4;</code>
       */

      public java.util.Map<String, String> getMapMap() {
        return internalGetMap().getMap();
      }
      /**
       * <code>map&lt;string, string&gt; map = 4;</code>
       */

      public String getMapOrDefault(
          String key,
          String defaultValue) {
        if (key == null) { throw new NullPointerException(); }
        java.util.Map<String, String> map =
            internalGetMap().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, string&gt; map = 4;</code>
       */

      public String getMapOrThrow(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        java.util.Map<String, String> map =
            internalGetMap().getMap();
        if (!map.containsKey(key)) {
          throw new IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearMap() {
        getMutableMap().clear();
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; map = 4;</code>
       */

      public Builder removeMap(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        getMutableMap().remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @Deprecated
      public java.util.Map<String, String>
      getMutableMap() {
        return internalGetMutableMap().getMutableMap();
      }
      /**
       * <code>map&lt;string, string&gt; map = 4;</code>
       */
      public Builder putMap(
          String key,
          String value) {
        if (key == null) { throw new NullPointerException(); }
        if (value == null) { throw new NullPointerException(); }
        getMutableMap().put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; map = 4;</code>
       */

      public Builder putAllMap(
          java.util.Map<String, String> values) {
        getMutableMap().putAll(values);
        return this;
      }

      private com.google.protobuf.LazyStringList lesssons_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureLesssonsIsMutable() {
        if (!((bitField0_ & 0x00000010) == 0x00000010)) {
          lesssons_ = new com.google.protobuf.LazyStringArrayList(lesssons_);
          bitField0_ |= 0x00000010;
         }
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public com.google.protobuf.ProtocolStringList
          getLesssonsList() {
        return lesssons_.getUnmodifiableView();
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public int getLesssonsCount() {
        return lesssons_.size();
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public String getLesssons(int index) {
        return lesssons_.get(index);
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public com.google.protobuf.ByteString
          getLesssonsBytes(int index) {
        return lesssons_.getByteString(index);
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public Builder setLesssons(
          int index, String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureLesssonsIsMutable();
        lesssons_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public Builder addLesssons(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureLesssonsIsMutable();
        lesssons_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public Builder addAllLesssons(
          Iterable<String> values) {
        ensureLesssonsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, lesssons_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public Builder clearLesssons() {
        lesssons_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string lesssons = 5;</code>
       */
      public Builder addLesssonsBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        ensureLesssonsIsMutable();
        lesssons_.add(value);
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:test.model.protobuf.Student)
    }

    // @@protoc_insertion_point(class_scope:test.model.protobuf.Student)
    private static final netty.使用protobuf.StudentOuterClass.Student DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new netty.使用protobuf.StudentOuterClass.Student();
    }

    public static netty.使用protobuf.StudentOuterClass.Student getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Student>
        PARSER = new com.google.protobuf.AbstractParser<Student>() {
      public Student parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Student(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Student> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Student> getParserForType() {
      return PARSER;
    }

    public netty.使用protobuf.StudentOuterClass.Student getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_test_model_protobuf_Student_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_test_model_protobuf_Student_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_test_model_protobuf_Student_MapEntry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_test_model_protobuf_Student_MapEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rstudent.proto\022\023test.model.protobuf\"\243\001\n" +
      "\007Student\022\014\n\004name\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\022\013\n\003s" +
      "ex\030\003 \001(\t\0222\n\003map\030\004 \003(\0132%.test.model.proto" +
      "buf.Student.MapEntry\022\020\n\010lesssons\030\005 \003(\t\032*" +
      "\n\010MapEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\002" +
      "8\001B\026\n\024netty.\344\275\277\347\224\250protobufb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_test_model_protobuf_Student_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_test_model_protobuf_Student_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_test_model_protobuf_Student_descriptor,
        new String[] { "Name", "Age", "Sex", "Map", "Lesssons", });
    internal_static_test_model_protobuf_Student_MapEntry_descriptor =
      internal_static_test_model_protobuf_Student_descriptor.getNestedTypes().get(0);
    internal_static_test_model_protobuf_Student_MapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_test_model_protobuf_Student_MapEntry_descriptor,
        new String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
