package Inot.Network.proto;

import Inot.Model.Inscriere;
import Inot.Model.PersoanaOficiu;
import Inot.Model.Proba;
import Inot.Services.IInotObserver;
import Inot.Services.IInotServices;
import Inot.Services.InotException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InotServicesGrpcProxy implements IInotServices {
    private static final Logger logger = LogManager.getLogger(InotServicesGrpcProxy.class);

    private final ManagedChannel channel;
    private final InotServiceGrpc.InotServiceBlockingStub blockingStub;
    private final InotServiceGrpc.InotServiceStub asyncStub;
    private IInotObserver clientObserver;

    public InotServicesGrpcProxy(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = InotServiceGrpc.newBlockingStub(channel);
        asyncStub = InotServiceGrpc.newStub(channel);
    }

    @Override
    public void login(PersoanaOficiu persoanaOficiu, IInotObserver client) throws InotException {
        try {
            this.clientObserver = client;
            System.out.println("InotServicesGrpcProxy: login");
            blockingStub.login(persoanaOficiuToProto(persoanaOficiu));
            subscribeForUpdates();
        } catch (StatusRuntimeException e) {
            System.out.println("InotServicesGrpcProxy: login failed");
            throw new InotException(e.getStatus().getDescription());
        }
    }

    @Override
    public void logout(PersoanaOficiu persoanaOficiu, IInotObserver client) throws InotException {
        try {
            blockingStub.logout(persoanaOficiuToProto(persoanaOficiu));
            channel.shutdown();
        } catch (StatusRuntimeException e) {
            throw new InotException(e.getStatus().getDescription());
        }
    }

    @Override
    public void addInscriere(Inscriere inscriere) throws InotException {
        try {
            blockingStub.addInscriere(inscriereToProto(inscriere));
        } catch (StatusRuntimeException e) {
            throw new InotException(e.getStatus().getDescription());
        }
    }

    @Override
    public Inscriere[] findAllInscriere() throws InotException {
        try {
            var response = blockingStub.getAllInscrieri(InotProtobufs.Empty.newBuilder().build());
            return response.getInscrieriList()
                    .stream()
                    .map(this::protoToInscriere)
                    .toArray(Inscriere[]::new);
        } catch (StatusRuntimeException e) {
            throw new InotException(e.getStatus().getDescription());
        }
    }

    @Override
    public Proba[] findAllProba() throws InotException {
        try {
            var response = blockingStub.getAllProbe(InotProtobufs.Empty.newBuilder().build());
            return response.getProbeList()
                    .stream()
                    .map(this::protoToProba)
                    .toArray(Proba[]::new);
        } catch (StatusRuntimeException e) {
            throw new InotException(e.getStatus().getDescription());
        }
    }

    @Override
    public Proba findProbaById(Long id) throws InotException {
        try {
            InotProtobufs.Proba protoProba = blockingStub.findProbaById(InotProtobufs.Proba.newBuilder().setId(id).build());
            return protoToProba(protoProba);
        } catch (StatusRuntimeException e) {
            throw new InotException(e.getStatus().getDescription());
        }
    }

    @Override
    public PersoanaOficiu findByUsernameService(String username) throws InotException {
        try {
            InotProtobufs.PersoanaOficiuResponse response = blockingStub.findPersoanaByUsername(InotProtobufs.PersoanaOficiu.newBuilder().setUsername(username).build());
            return protoToPersoanaOficiu(response.getPersoana());
        } catch (StatusRuntimeException e) {
            throw new InotException(e.getStatus().getDescription());
        }
    }

    private void subscribeForUpdates() {
        asyncStub.subscribeForUpdates(InotProtobufs.Empty.newBuilder().build(), new StreamObserver<InotProtobufs.Inscriere>() {
            @Override
            public void onNext(InotProtobufs.Inscriere inscriereProto) {
                Inscriere inscriere = protoToInscriere(inscriereProto);
                logger.info("Received new inscriere -> Notifying observer");
                if (clientObserver != null) {
                    try {
                        clientObserver.inscriereAdded(inscriere);
                    } catch (InotException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Error in stream: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("Stream closed by server.");
            }
        });
    }

    private InotProtobufs.PersoanaOficiu persoanaOficiuToProto(Inot.Model.PersoanaOficiu persoana) {
        return InotProtobufs.PersoanaOficiu.newBuilder()
                .setId(0)
                .setUsername(persoana.getUsername())
                .setPassword(persoana.getPassword())
                .setLocation(persoana.getLocation())
                .build();
    }

    private InotProtobufs.Inscriere inscriereToProto(Inot.Model.Inscriere inscriere) {
        return InotProtobufs.Inscriere.newBuilder()
//                .setId(inscriere.getId())
                .setIdProba(inscriere.getIdProba())
                .setNumeParticipant(inscriere.getNumeParticipant())
                .setVarstaParticipant(inscriere.getVarstaParticipant())
                .build();
    }

    private Inot.Model.PersoanaOficiu protoToPersoanaOficiu(InotProtobufs.PersoanaOficiu p) {
        PersoanaOficiu persoanaOficiu = new PersoanaOficiu(p.getUsername(), p.getPassword(), p.getLocation());
        persoanaOficiu.setId(p.getId());
        return persoanaOficiu;
    }

    private Inot.Model.Inscriere protoToInscriere(InotProtobufs.Inscriere i) {
        Inscriere inscriere = new Inscriere(i.getIdProba(), i.getNumeParticipant(), i.getVarstaParticipant());
        inscriere.setId(i.getId());
        return inscriere;
    }

    private Inot.Model.Proba protoToProba(InotProtobufs.Proba p) {
        Proba proba = new Proba( p.getDistanta(), p.getStil(), p.getNrParticipantiInscrisi());
        proba.setId(p.getId());
        return proba;
    }
}
