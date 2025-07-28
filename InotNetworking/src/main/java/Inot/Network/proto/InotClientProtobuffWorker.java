//package Inot.Network.proto;
//
//import Inot.Model.Inscriere;
//import Inot.Network.rpcprotocol.Response;
//import Inot.Network.rpcprotocol.ResponseType;
//import Inot.Services.IInotObserver;
//import Inot.Services.IInotServices;
//import Inot.Services.InotException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.*;
//import java.net.Socket;
//
//public class InotClientProtobuffWorker implements Runnable, IInotObserver {
//    private IInotServices server;
//    private Socket connection;
//
//    private InputStream input;
//    private OutputStream output;
//    private volatile boolean connected;
//
//    private static Logger logger = LogManager.getLogger(InotClientProtobuffWorker.class);
//
//    public InotClientProtobuffWorker(IInotServices server, Socket connection) {
//        this.server = server;
//        this.connection = connection;
//        try{
//            output=connection.getOutputStream();
//            output.flush();
//            input=connection.getInputStream();
//            connected=true;
//        } catch (IOException e) {
//            e.printStackTrace();
//            logger.error(e);
//            logger.error(e.getStackTrace());
//        }
//    }
//
//    public void run() {
//        while(connected){
//            try {
//                System.out.println("Waiting requests ...");
//                InotProtobufs.Request request = InotProtobufs.Request.parseDelimitedFrom(input);
//                System.out.println("Request received: "+request);
//                InotProtobufs.Response response = handleRequest(request);
//                if (response!=null){
//                    sendResponse(response);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                logger.error(e);
//                logger.error(e.getStackTrace());
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                logger.error(e);
//                logger.error(e.getStackTrace());
//            }
//        }
//        try {
//            input.close();
//            output.close();
//            connection.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            logger.error("Error "+e);
//        }
//    }
//
//    @Override
//    public void inscriereAdded(Inscriere inscriere) throws InotException {
////        logger.info(resp.toString());
//        try{
//            sendResponse(ProtoUtils.createInscriereAddedResponse(inscriere));
//        }catch (IOException e){
//            e.printStackTrace();
//            logger.error("Error:" + e);
//        }
//    }
//
//    private InotProtobufs.Response handleRequest(InotProtobufs.Request request)
//    {
//        InotProtobufs.Response response = null;
//        switch (request.getType())
//        {
//            case LOGIN:
//            {
//                var user = ProtoUtils.getPersoanaOficiu(request);
//                try
//                {
//                    server.login(user, this);
//                    return ProtoUtils.createOkResponse();
//                }
//                catch (InotException e)
//                {
//                    connected=false;
//                    return ProtoUtils.createErrorResponse(e.getMessage());
//                }
//            }
//            case LOGOUT:
//            {
//                var user = ProtoUtils.getPersoanaOficiu(request);
//                try
//                {
//                    server.logout(user, this);
//                    connected=false;
//                    return ProtoUtils.createOkResponse();
//                }
//                catch (InotException e)
//                {
//                    return ProtoUtils.createErrorResponse(e.getMessage());
//                }
//            }
//            case INSCRIERE_ADDED:
//            {
//                var inscriere = ProtoUtils.getInscriere(request);
//                try
//                {
//                    server.addInscriere(inscriere);
//                    return ProtoUtils.createOkResponse();
//                }
//                catch (InotException e)
//                {
//                    return ProtoUtils.createErrorResponse(e.getMessage());
//                }
//            }
//            case GET_ALL_INSCRIERE:
//            {
//                try
//                {
//                    var inscrieri = server.findAllInscriere();
//                    return ProtoUtils.createGetAllInscriereResponse(inscrieri);
//                }
//                catch (InotException e)
//                {
//                    return ProtoUtils.createErrorResponse(e.getMessage());
//                }
//            }
//            case GET_ALL_PROBA:
//            {
//                try
//                {
//                    var probe = server.findAllProba();
//                    return ProtoUtils.createGetAllProbaResponse(probe);
//                }
//                catch (InotException e)
//                {
//                    return ProtoUtils.createErrorResponse(e.getMessage());
//                }
//            }
//            case GET_PERSOANA_BY_USERNAME:
//            {
//                try
//                {
//                    var persoana = server.findByUsernameService(request.getUsername());
//                    return ProtoUtils.createGetPersoanaByUsernameResponse(persoana);
//                }
//                catch (InotException e)
//                {
//                    return ProtoUtils.createErrorResponse(e.getMessage());
//                }
//            }
//        }
//        return response;
//    }
//    private void sendResponse(InotProtobufs.Response response) throws IOException{
//        logger.debug("sending response {}",response);
//        synchronized (output) {
//            response.writeDelimitedTo(output);
//            output.flush();
//        }
//    }
//
//}