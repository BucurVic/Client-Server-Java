import Inot.Network.utils.AbstractServer;
import Inot.Network.utils.InotProtobuffConcurrentServer;
import Inot.Network.utils.InotRpcConcurrentServer;
import Inot.Network.utils.ServerException;
import Inot.Persistence.*;
import Inot.Persistence.Interfaces.IRepoInscriere;
import Inot.Persistence.Interfaces.IRepoPersoanaOficiu;
import Inot.Persistence.Interfaces.IRepoProba;
import Inot.Server.InotServiceImpl;
import Inot.Services.IInotServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class StartRpcServer {
    private static int defaultPort=55555;
    private static Logger logger = LogManager.getLogger(StartRpcServer.class);
    public static void main(String[] args) {
        Properties serverProps=new Properties();
        try {
            serverProps.load(StartRpcServer.class.getResourceAsStream("/inotserver.properties"));
            logger.info("Server properties set {}",serverProps);
           // serverProps.list(System.out);
        } catch (IOException e) {
            logger.error("Cannot find chatserver.properties "+e);
            logger.debug("Looking for file in "+(new File(".")).getAbsolutePath());
            return;
        }
//        IRepoPersoanaOficiu repoPersoanaOficiu = new RepositoryPersoanaOficiu(serverProps);
//        IRepoProba repoProba = new RepositoryProba(serverProps);
//        IRepoInscriere repoInscriere = new RepositoryInscriere(serverProps);

        IRepoPersoanaOficiu repoPersoanaOficiu = new RepositoryPersoanaOficiuHibernate();
        IRepoProba repoProba = new RepositoryProbaHibernate();
        IRepoInscriere repoInscriere = new RepositoryInscriereHibernate();

        IInotServices inotServiceImpl = new InotServiceImpl(repoPersoanaOficiu, repoProba, repoInscriere);
        int inotServerPort =defaultPort;
        try {
            inotServerPort = Integer.parseInt(serverProps.getProperty("inot.server.port"));
        }catch (NumberFormatException nef){
            logger.error("Wrong  Port Number"+nef.getMessage());
            logger.debug("Using default port "+defaultPort);
        }
        logger.debug("Starting server on port: "+ inotServerPort);
        AbstractServer server = new InotRpcConcurrentServer(inotServerPort, inotServiceImpl);
//        AbstractServer server = new InotProtobuffConcurrentServer(inotServerPort, inotServiceImpl);
        try {
            server.start();
        } catch (ServerException e) {
            logger.error("Error starting the server" + e.getMessage());
        }finally {
            try {
                server.stop();
            }catch(ServerException e){
                logger.error("Error stopping server "+e.getMessage());
            }
        }
    }
}
