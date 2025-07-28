package Inot.Network.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.72.0)",
        comments = "Source: proto/InotProtocol_v3.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InotServiceGrpc {

  private InotServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "proto.InotService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu,
          Inot.Network.proto.InotProtobufs.Empty> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "Login",
          requestType = Inot.Network.proto.InotProtobufs.PersoanaOficiu.class,
          responseType = Inot.Network.proto.InotProtobufs.Empty.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu,
          Inot.Network.proto.InotProtobufs.Empty> getLoginMethod() {
    io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu, Inot.Network.proto.InotProtobufs.Empty> getLoginMethod;
    if ((getLoginMethod = InotServiceGrpc.getLoginMethod) == null) {
      synchronized (InotServiceGrpc.class) {
        if ((getLoginMethod = InotServiceGrpc.getLoginMethod) == null) {
          InotServiceGrpc.getLoginMethod = getLoginMethod =
                  io.grpc.MethodDescriptor.<Inot.Network.proto.InotProtobufs.PersoanaOficiu, Inot.Network.proto.InotProtobufs.Empty>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Login"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.PersoanaOficiu.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Empty.getDefaultInstance()))
                          .setSchemaDescriptor(new InotServiceMethodDescriptorSupplier("Login"))
                          .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu,
          Inot.Network.proto.InotProtobufs.Empty> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "Logout",
          requestType = Inot.Network.proto.InotProtobufs.PersoanaOficiu.class,
          responseType = Inot.Network.proto.InotProtobufs.Empty.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu,
          Inot.Network.proto.InotProtobufs.Empty> getLogoutMethod() {
    io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu, Inot.Network.proto.InotProtobufs.Empty> getLogoutMethod;
    if ((getLogoutMethod = InotServiceGrpc.getLogoutMethod) == null) {
      synchronized (InotServiceGrpc.class) {
        if ((getLogoutMethod = InotServiceGrpc.getLogoutMethod) == null) {
          InotServiceGrpc.getLogoutMethod = getLogoutMethod =
                  io.grpc.MethodDescriptor.<Inot.Network.proto.InotProtobufs.PersoanaOficiu, Inot.Network.proto.InotProtobufs.Empty>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Logout"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.PersoanaOficiu.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Empty.getDefaultInstance()))
                          .setSchemaDescriptor(new InotServiceMethodDescriptorSupplier("Logout"))
                          .build();
        }
      }
    }
    return getLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Inscriere,
          Inot.Network.proto.InotProtobufs.Empty> getAddInscriereMethod;

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "AddInscriere",
          requestType = Inot.Network.proto.InotProtobufs.Inscriere.class,
          responseType = Inot.Network.proto.InotProtobufs.Empty.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Inscriere,
          Inot.Network.proto.InotProtobufs.Empty> getAddInscriereMethod() {
    io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Inscriere, Inot.Network.proto.InotProtobufs.Empty> getAddInscriereMethod;
    if ((getAddInscriereMethod = InotServiceGrpc.getAddInscriereMethod) == null) {
      synchronized (InotServiceGrpc.class) {
        if ((getAddInscriereMethod = InotServiceGrpc.getAddInscriereMethod) == null) {
          InotServiceGrpc.getAddInscriereMethod = getAddInscriereMethod =
                  io.grpc.MethodDescriptor.<Inot.Network.proto.InotProtobufs.Inscriere, Inot.Network.proto.InotProtobufs.Empty>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddInscriere"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Inscriere.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Empty.getDefaultInstance()))
                          .setSchemaDescriptor(new InotServiceMethodDescriptorSupplier("AddInscriere"))
                          .build();
        }
      }
    }
    return getAddInscriereMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty,
          Inot.Network.proto.InotProtobufs.InscriereList> getGetAllInscrieriMethod;

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "GetAllInscrieri",
          requestType = Inot.Network.proto.InotProtobufs.Empty.class,
          responseType = Inot.Network.proto.InotProtobufs.InscriereList.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty,
          Inot.Network.proto.InotProtobufs.InscriereList> getGetAllInscrieriMethod() {
    io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty, Inot.Network.proto.InotProtobufs.InscriereList> getGetAllInscrieriMethod;
    if ((getGetAllInscrieriMethod = InotServiceGrpc.getGetAllInscrieriMethod) == null) {
      synchronized (InotServiceGrpc.class) {
        if ((getGetAllInscrieriMethod = InotServiceGrpc.getGetAllInscrieriMethod) == null) {
          InotServiceGrpc.getGetAllInscrieriMethod = getGetAllInscrieriMethod =
                  io.grpc.MethodDescriptor.<Inot.Network.proto.InotProtobufs.Empty, Inot.Network.proto.InotProtobufs.InscriereList>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllInscrieri"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Empty.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.InscriereList.getDefaultInstance()))
                          .setSchemaDescriptor(new InotServiceMethodDescriptorSupplier("GetAllInscrieri"))
                          .build();
        }
      }
    }
    return getGetAllInscrieriMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty,
          Inot.Network.proto.InotProtobufs.ProbaList> getGetAllProbeMethod;

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "GetAllProbe",
          requestType = Inot.Network.proto.InotProtobufs.Empty.class,
          responseType = Inot.Network.proto.InotProtobufs.ProbaList.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty,
          Inot.Network.proto.InotProtobufs.ProbaList> getGetAllProbeMethod() {
    io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty, Inot.Network.proto.InotProtobufs.ProbaList> getGetAllProbeMethod;
    if ((getGetAllProbeMethod = InotServiceGrpc.getGetAllProbeMethod) == null) {
      synchronized (InotServiceGrpc.class) {
        if ((getGetAllProbeMethod = InotServiceGrpc.getGetAllProbeMethod) == null) {
          InotServiceGrpc.getGetAllProbeMethod = getGetAllProbeMethod =
                  io.grpc.MethodDescriptor.<Inot.Network.proto.InotProtobufs.Empty, Inot.Network.proto.InotProtobufs.ProbaList>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllProbe"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Empty.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.ProbaList.getDefaultInstance()))
                          .setSchemaDescriptor(new InotServiceMethodDescriptorSupplier("GetAllProbe"))
                          .build();
        }
      }
    }
    return getGetAllProbeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Proba,
          Inot.Network.proto.InotProtobufs.Proba> getFindProbaByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "FindProbaById",
          requestType = Inot.Network.proto.InotProtobufs.Proba.class,
          responseType = Inot.Network.proto.InotProtobufs.Proba.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Proba,
          Inot.Network.proto.InotProtobufs.Proba> getFindProbaByIdMethod() {
    io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Proba, Inot.Network.proto.InotProtobufs.Proba> getFindProbaByIdMethod;
    if ((getFindProbaByIdMethod = InotServiceGrpc.getFindProbaByIdMethod) == null) {
      synchronized (InotServiceGrpc.class) {
        if ((getFindProbaByIdMethod = InotServiceGrpc.getFindProbaByIdMethod) == null) {
          InotServiceGrpc.getFindProbaByIdMethod = getFindProbaByIdMethod =
                  io.grpc.MethodDescriptor.<Inot.Network.proto.InotProtobufs.Proba, Inot.Network.proto.InotProtobufs.Proba>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindProbaById"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Proba.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Proba.getDefaultInstance()))
                          .setSchemaDescriptor(new InotServiceMethodDescriptorSupplier("FindProbaById"))
                          .build();
        }
      }
    }
    return getFindProbaByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu,
          Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse> getFindPersoanaByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "FindPersoanaByUsername",
          requestType = Inot.Network.proto.InotProtobufs.PersoanaOficiu.class,
          responseType = Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse.class,
          methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu,
          Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse> getFindPersoanaByUsernameMethod() {
    io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.PersoanaOficiu, Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse> getFindPersoanaByUsernameMethod;
    if ((getFindPersoanaByUsernameMethod = InotServiceGrpc.getFindPersoanaByUsernameMethod) == null) {
      synchronized (InotServiceGrpc.class) {
        if ((getFindPersoanaByUsernameMethod = InotServiceGrpc.getFindPersoanaByUsernameMethod) == null) {
          InotServiceGrpc.getFindPersoanaByUsernameMethod = getFindPersoanaByUsernameMethod =
                  io.grpc.MethodDescriptor.<Inot.Network.proto.InotProtobufs.PersoanaOficiu, Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindPersoanaByUsername"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.PersoanaOficiu.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse.getDefaultInstance()))
                          .setSchemaDescriptor(new InotServiceMethodDescriptorSupplier("FindPersoanaByUsername"))
                          .build();
        }
      }
    }
    return getFindPersoanaByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty,
          Inot.Network.proto.InotProtobufs.Inscriere> getSubscribeForUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
          fullMethodName = SERVICE_NAME + '/' + "SubscribeForUpdates",
          requestType = Inot.Network.proto.InotProtobufs.Empty.class,
          responseType = Inot.Network.proto.InotProtobufs.Inscriere.class,
          methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty,
          Inot.Network.proto.InotProtobufs.Inscriere> getSubscribeForUpdatesMethod() {
    io.grpc.MethodDescriptor<Inot.Network.proto.InotProtobufs.Empty, Inot.Network.proto.InotProtobufs.Inscriere> getSubscribeForUpdatesMethod;
    if ((getSubscribeForUpdatesMethod = InotServiceGrpc.getSubscribeForUpdatesMethod) == null) {
      synchronized (InotServiceGrpc.class) {
        if ((getSubscribeForUpdatesMethod = InotServiceGrpc.getSubscribeForUpdatesMethod) == null) {
          InotServiceGrpc.getSubscribeForUpdatesMethod = getSubscribeForUpdatesMethod =
                  io.grpc.MethodDescriptor.<Inot.Network.proto.InotProtobufs.Empty, Inot.Network.proto.InotProtobufs.Inscriere>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                          .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeForUpdates"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Empty.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  Inot.Network.proto.InotProtobufs.Inscriere.getDefaultInstance()))
                          .setSchemaDescriptor(new InotServiceMethodDescriptorSupplier("SubscribeForUpdates"))
                          .build();
        }
      }
    }
    return getSubscribeForUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InotServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InotServiceStub> factory =
            new io.grpc.stub.AbstractStub.StubFactory<InotServiceStub>() {
              @java.lang.Override
              public InotServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new InotServiceStub(channel, callOptions);
              }
            };
    return InotServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static InotServiceBlockingV2Stub newBlockingV2Stub(
          io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InotServiceBlockingV2Stub> factory =
            new io.grpc.stub.AbstractStub.StubFactory<InotServiceBlockingV2Stub>() {
              @java.lang.Override
              public InotServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new InotServiceBlockingV2Stub(channel, callOptions);
              }
            };
    return InotServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InotServiceBlockingStub newBlockingStub(
          io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InotServiceBlockingStub> factory =
            new io.grpc.stub.AbstractStub.StubFactory<InotServiceBlockingStub>() {
              @java.lang.Override
              public InotServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new InotServiceBlockingStub(channel, callOptions);
              }
            };
    return InotServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InotServiceFutureStub newFutureStub(
          io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InotServiceFutureStub> factory =
            new io.grpc.stub.AbstractStub.StubFactory<InotServiceFutureStub>() {
              @java.lang.Override
              public InotServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new InotServiceFutureStub(channel, callOptions);
              }
            };
    return InotServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void login(Inot.Network.proto.InotProtobufs.PersoanaOficiu request,
                       io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    default void logout(Inot.Network.proto.InotProtobufs.PersoanaOficiu request,
                        io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    /**
     */
    default void addInscriere(Inot.Network.proto.InotProtobufs.Inscriere request,
                              io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddInscriereMethod(), responseObserver);
    }

    /**
     */
    default void getAllInscrieri(Inot.Network.proto.InotProtobufs.Empty request,
                                 io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.InscriereList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllInscrieriMethod(), responseObserver);
    }

    /**
     */
    default void getAllProbe(Inot.Network.proto.InotProtobufs.Empty request,
                             io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.ProbaList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllProbeMethod(), responseObserver);
    }

    /**
     */
    default void findProbaById(Inot.Network.proto.InotProtobufs.Proba request,
                               io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Proba> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindProbaByIdMethod(), responseObserver);
    }

    /**
     */
    default void findPersoanaByUsername(Inot.Network.proto.InotProtobufs.PersoanaOficiu request,
                                        io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindPersoanaByUsernameMethod(), responseObserver);
    }

    /**
     */
    default void subscribeForUpdates(Inot.Network.proto.InotProtobufs.Empty request,
                                     io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Inscriere> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeForUpdatesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InotService.
   */
  public static abstract class InotServiceImplBase
          implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return InotServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InotService.
   */
  public static final class InotServiceStub
          extends io.grpc.stub.AbstractAsyncStub<InotServiceStub> {
    private InotServiceStub(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InotServiceStub build(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InotServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(Inot.Network.proto.InotProtobufs.PersoanaOficiu request,
                      io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
              getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(Inot.Network.proto.InotProtobufs.PersoanaOficiu request,
                       io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
              getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addInscriere(Inot.Network.proto.InotProtobufs.Inscriere request,
                             io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
              getChannel().newCall(getAddInscriereMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllInscrieri(Inot.Network.proto.InotProtobufs.Empty request,
                                io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.InscriereList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
              getChannel().newCall(getGetAllInscrieriMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllProbe(Inot.Network.proto.InotProtobufs.Empty request,
                            io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.ProbaList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
              getChannel().newCall(getGetAllProbeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findProbaById(Inot.Network.proto.InotProtobufs.Proba request,
                              io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Proba> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
              getChannel().newCall(getFindProbaByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findPersoanaByUsername(Inot.Network.proto.InotProtobufs.PersoanaOficiu request,
                                       io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
              getChannel().newCall(getFindPersoanaByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribeForUpdates(Inot.Network.proto.InotProtobufs.Empty request,
                                    io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Inscriere> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
              getChannel().newCall(getSubscribeForUpdatesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InotService.
   */
  public static final class InotServiceBlockingV2Stub
          extends io.grpc.stub.AbstractBlockingStub<InotServiceBlockingV2Stub> {
    private InotServiceBlockingV2Stub(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InotServiceBlockingV2Stub build(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InotServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.Empty login(Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.Empty logout(Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.Empty addInscriere(Inot.Network.proto.InotProtobufs.Inscriere request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getAddInscriereMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.InscriereList getAllInscrieri(Inot.Network.proto.InotProtobufs.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getGetAllInscrieriMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.ProbaList getAllProbe(Inot.Network.proto.InotProtobufs.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getGetAllProbeMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.Proba findProbaById(Inot.Network.proto.InotProtobufs.Proba request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getFindProbaByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse findPersoanaByUsername(Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getFindPersoanaByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public java.util.Iterator<Inot.Network.proto.InotProtobufs.Inscriere>
    subscribeForUpdates(Inot.Network.proto.InotProtobufs.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
              getChannel(), getSubscribeForUpdatesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service InotService.
   */
  public static final class InotServiceBlockingStub
          extends io.grpc.stub.AbstractBlockingStub<InotServiceBlockingStub> {
    private InotServiceBlockingStub(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InotServiceBlockingStub build(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InotServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.Empty login(Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.Empty logout(Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getLogoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.Empty addInscriere(Inot.Network.proto.InotProtobufs.Inscriere request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getAddInscriereMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.InscriereList getAllInscrieri(Inot.Network.proto.InotProtobufs.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getGetAllInscrieriMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.ProbaList getAllProbe(Inot.Network.proto.InotProtobufs.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getGetAllProbeMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.Proba findProbaById(Inot.Network.proto.InotProtobufs.Proba request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getFindProbaByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse findPersoanaByUsername(Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
              getChannel(), getFindPersoanaByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<Inot.Network.proto.InotProtobufs.Inscriere> subscribeForUpdates(
            Inot.Network.proto.InotProtobufs.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
              getChannel(), getSubscribeForUpdatesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InotService.
   */
  public static final class InotServiceFutureStub
          extends io.grpc.stub.AbstractFutureStub<InotServiceFutureStub> {
    private InotServiceFutureStub(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InotServiceFutureStub build(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InotServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Inot.Network.proto.InotProtobufs.Empty> login(
            Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
              getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Inot.Network.proto.InotProtobufs.Empty> logout(
            Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
              getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Inot.Network.proto.InotProtobufs.Empty> addInscriere(
            Inot.Network.proto.InotProtobufs.Inscriere request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
              getChannel().newCall(getAddInscriereMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Inot.Network.proto.InotProtobufs.InscriereList> getAllInscrieri(
            Inot.Network.proto.InotProtobufs.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
              getChannel().newCall(getGetAllInscrieriMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Inot.Network.proto.InotProtobufs.ProbaList> getAllProbe(
            Inot.Network.proto.InotProtobufs.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
              getChannel().newCall(getGetAllProbeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Inot.Network.proto.InotProtobufs.Proba> findProbaById(
            Inot.Network.proto.InotProtobufs.Proba request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
              getChannel().newCall(getFindProbaByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse> findPersoanaByUsername(
            Inot.Network.proto.InotProtobufs.PersoanaOficiu request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
              getChannel().newCall(getFindPersoanaByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;
  private static final int METHODID_ADD_INSCRIERE = 2;
  private static final int METHODID_GET_ALL_INSCRIERI = 3;
  private static final int METHODID_GET_ALL_PROBE = 4;
  private static final int METHODID_FIND_PROBA_BY_ID = 5;
  private static final int METHODID_FIND_PERSOANA_BY_USERNAME = 6;
  private static final int METHODID_SUBSCRIBE_FOR_UPDATES = 7;

  private static final class MethodHandlers<Req, Resp> implements
          io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((Inot.Network.proto.InotProtobufs.PersoanaOficiu) request,
                  (io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((Inot.Network.proto.InotProtobufs.PersoanaOficiu) request,
                  (io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty>) responseObserver);
          break;
        case METHODID_ADD_INSCRIERE:
          serviceImpl.addInscriere((Inot.Network.proto.InotProtobufs.Inscriere) request,
                  (io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Empty>) responseObserver);
          break;
        case METHODID_GET_ALL_INSCRIERI:
          serviceImpl.getAllInscrieri((Inot.Network.proto.InotProtobufs.Empty) request,
                  (io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.InscriereList>) responseObserver);
          break;
        case METHODID_GET_ALL_PROBE:
          serviceImpl.getAllProbe((Inot.Network.proto.InotProtobufs.Empty) request,
                  (io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.ProbaList>) responseObserver);
          break;
        case METHODID_FIND_PROBA_BY_ID:
          serviceImpl.findProbaById((Inot.Network.proto.InotProtobufs.Proba) request,
                  (io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Proba>) responseObserver);
          break;
        case METHODID_FIND_PERSOANA_BY_USERNAME:
          serviceImpl.findPersoanaByUsername((Inot.Network.proto.InotProtobufs.PersoanaOficiu) request,
                  (io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_FOR_UPDATES:
          serviceImpl.subscribeForUpdates((Inot.Network.proto.InotProtobufs.Empty) request,
                  (io.grpc.stub.StreamObserver<Inot.Network.proto.InotProtobufs.Inscriere>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
            .addMethod(
                    getLoginMethod(),
                    io.grpc.stub.ServerCalls.asyncUnaryCall(
                            new MethodHandlers<
                                    Inot.Network.proto.InotProtobufs.PersoanaOficiu,
                                    Inot.Network.proto.InotProtobufs.Empty>(
                                    service, METHODID_LOGIN)))
            .addMethod(
                    getLogoutMethod(),
                    io.grpc.stub.ServerCalls.asyncUnaryCall(
                            new MethodHandlers<
                                    Inot.Network.proto.InotProtobufs.PersoanaOficiu,
                                    Inot.Network.proto.InotProtobufs.Empty>(
                                    service, METHODID_LOGOUT)))
            .addMethod(
                    getAddInscriereMethod(),
                    io.grpc.stub.ServerCalls.asyncUnaryCall(
                            new MethodHandlers<
                                    Inot.Network.proto.InotProtobufs.Inscriere,
                                    Inot.Network.proto.InotProtobufs.Empty>(
                                    service, METHODID_ADD_INSCRIERE)))
            .addMethod(
                    getGetAllInscrieriMethod(),
                    io.grpc.stub.ServerCalls.asyncUnaryCall(
                            new MethodHandlers<
                                    Inot.Network.proto.InotProtobufs.Empty,
                                    Inot.Network.proto.InotProtobufs.InscriereList>(
                                    service, METHODID_GET_ALL_INSCRIERI)))
            .addMethod(
                    getGetAllProbeMethod(),
                    io.grpc.stub.ServerCalls.asyncUnaryCall(
                            new MethodHandlers<
                                    Inot.Network.proto.InotProtobufs.Empty,
                                    Inot.Network.proto.InotProtobufs.ProbaList>(
                                    service, METHODID_GET_ALL_PROBE)))
            .addMethod(
                    getFindProbaByIdMethod(),
                    io.grpc.stub.ServerCalls.asyncUnaryCall(
                            new MethodHandlers<
                                    Inot.Network.proto.InotProtobufs.Proba,
                                    Inot.Network.proto.InotProtobufs.Proba>(
                                    service, METHODID_FIND_PROBA_BY_ID)))
            .addMethod(
                    getFindPersoanaByUsernameMethod(),
                    io.grpc.stub.ServerCalls.asyncUnaryCall(
                            new MethodHandlers<
                                    Inot.Network.proto.InotProtobufs.PersoanaOficiu,
                                    Inot.Network.proto.InotProtobufs.PersoanaOficiuResponse>(
                                    service, METHODID_FIND_PERSOANA_BY_USERNAME)))
            .addMethod(
                    getSubscribeForUpdatesMethod(),
                    io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                            new MethodHandlers<
                                    Inot.Network.proto.InotProtobufs.Empty,
                                    Inot.Network.proto.InotProtobufs.Inscriere>(
                                    service, METHODID_SUBSCRIBE_FOR_UPDATES)))
            .build();
  }

  private static abstract class InotServiceBaseDescriptorSupplier
          implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InotServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Inot.Network.proto.InotProtobufs.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InotService");
    }
  }

  private static final class InotServiceFileDescriptorSupplier
          extends InotServiceBaseDescriptorSupplier {
    InotServiceFileDescriptorSupplier() {}
  }

  private static final class InotServiceMethodDescriptorSupplier
          extends InotServiceBaseDescriptorSupplier
          implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InotServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InotServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                  .setSchemaDescriptor(new InotServiceFileDescriptorSupplier())
                  .addMethod(getLoginMethod())
                  .addMethod(getLogoutMethod())
                  .addMethod(getAddInscriereMethod())
                  .addMethod(getGetAllInscrieriMethod())
                  .addMethod(getGetAllProbeMethod())
                  .addMethod(getFindProbaByIdMethod())
                  .addMethod(getFindPersoanaByUsernameMethod())
                  .addMethod(getSubscribeForUpdatesMethod())
                  .build();
        }
      }
    }
    return result;
  }
}
