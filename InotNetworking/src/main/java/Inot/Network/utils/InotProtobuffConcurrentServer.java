package Inot.Network.utils;

//import Inot.Network.proto.InotClientProtobuffWorker;
import Inot.Network.rpcprotocol.InotClientRpcReflectionWorker;
import Inot.Services.IInotServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Socket;

public class InotProtobuffConcurrentServer extends AbsConcurrentServer {

    private IInotServices InotServer;
    private static Logger logger = LogManager.getLogger(InotClientRpcReflectionWorker.class);
    public InotProtobuffConcurrentServer(int port, IInotServices inotServer) {
        super(port);
        this.InotServer = inotServer;
        logger.info("Chat- ChatRpcConcurrentServer");
    }
    @Override
    protected Thread createWorker(Socket client) {
//        InotClientProtobuffWorker worker = new InotClientProtobuffWorker(InotServer, client);
//        return new Thread(worker);
        return null;
    }
}
