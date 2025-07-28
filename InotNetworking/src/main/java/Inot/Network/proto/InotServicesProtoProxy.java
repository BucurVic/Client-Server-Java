//package Inot.Network.proto;
//
//import Inot.Model.Inscriere;
//import Inot.Model.PersoanaOficiu;
//import Inot.Model.Proba;
//import Inot.Network.dto.DTOUtils;
//import Inot.Network.dto.InscriereDTO;
//import Inot.Network.dto.ProbaDTO;
//import Inot.Network.rpcprotocol.Request;
//import Inot.Network.rpcprotocol.RequestType;
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
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class InotServicesProtoProxy implements IInotServices {
//    private String host;
//    private int port;
//
//    private static Logger logger = LogManager.getLogger(InotServicesProtoProxy.class);
//
//    private IInotObserver client;
//
//    private InputStream input;
//    private OutputStream output;
//    private Socket connection;
//
//    private BlockingQueue<InotProtobufs.Response> qresponses;
//    private volatile boolean finished;
//    public InotServicesProtoProxy(String host, int port) {
//        this.host = host;
//        this.port = port;
//        qresponses=new LinkedBlockingQueue<InotProtobufs.Response>();
//    }
//
//    public void login(PersoanaOficiu persoanaOficiu, IInotObserver client) throws InotException {
//        initializeConnection();
////        PersoanaOficiuDTO persoanaOficiuDTO = DTOUtils.getDTO(persoanaOficiu);
////        Request req=new Request.Builder().type(RequestType.LOGIN).data(persoanaOficiuDTO).build();
//        sendRequest(ProtoUtils.createLoginRequest(persoanaOficiu));
//        InotProtobufs.Response response=readResponse();
//        if (response.getType()== InotProtobufs.Response.ResponseType.OK){
//            this.client=client;
//            return;
//        }
//        if (response.getType()== InotProtobufs.Response.ResponseType.ERROR){
//            String err=ProtoUtils.getError(response);
//            closeConnection();
//            throw new InotException(err);
//        }
//    }
//
//    @Override
//    public Proba findProbaById(Long id) throws InotException {
////        Request req = new Request.Builder().type(RequestType.FIND_PROBA_BY_ID).data(id).build();
//        sendRequest(ProtoUtils.createfindProbaById(id));
//        InotProtobufs.Response response=readResponse();
//        System.out.println(response.getType());
//        if (response.getType()== InotProtobufs.Response.ResponseType.ERROR){
//            String err=ProtoUtils.getError(response);
//            throw new InotException(err);
//        }
//        logger.debug("findProbaById: "+id);
//        return ProtoUtils.getProba(response);
//    }
//
//    @Override
//    public PersoanaOficiu findByUsernameService(String username) throws InotException {
////        Request req = new Request.Builder().type(RequestType.GET_PERSOANA_BY_USERNAME).data(username).build();
//        sendRequest(ProtoUtils.createfindPersoanaByUsernameRequest(username));
//        InotProtobufs.Response response=readResponse();
//        if (response.getType()== InotProtobufs.Response.ResponseType.ERROR){
//            String err=ProtoUtils.getError(response);
//            throw new InotException(err);
//        }
//        logger.debug("InotServicesRpcProxy findByUsernameService");
//        return ProtoUtils.getPersoanaOficiu(response);
//    }
//
//    @Override
//    public Proba[] findAllProba() throws InotException {
////        Request req = new Request.Builder().type(RequestType.GET_ALL_PROBA).build();
//        sendRequest(ProtoUtils.createfindAllProbaRequest());
//        InotProtobufs.Response response=readResponse();
//        if (response.getType()== InotProtobufs.Response.ResponseType.ERROR){
//            String err=ProtoUtils.getError(response);
//            throw new InotException(err);
//        }
//        logger.debug("InotServicesRpcProxy findAllProba");
//        return ProtoUtils.getProbe(response);
//    }
//
//    @Override
//    public void addInscriere(Inscriere inscriere) throws InotException {
////        InscriereDTO inscriereDTO = DTOUtils.getDTO(inscriere);
////        Request req = new Request.Builder().type(RequestType.INSCRIERE_ADDED).data(inscriereDTO).build();
//        sendRequest(ProtoUtils.createInscriereAddedRequest(inscriere));
//        InotProtobufs.Response response=readResponse();
//        if (response.getType()== InotProtobufs.Response.ResponseType.ERROR){
//            String err=ProtoUtils.getError(response);
//            throw new InotException(err);
//        }
//    }
//
//    @Override
//    public Inscriere[] findAllInscriere() throws InotException {
////        Request req = new Request.Builder().type(RequestType.GET_ALL_INSCRIERE).build();
//        sendRequest(ProtoUtils.createfindAllInscirereRequest());
//        InotProtobufs.Response response = readResponse();
//        if (response.getType()== InotProtobufs.Response.ResponseType.ERROR) {
//            String err = ProtoUtils.getError(response);
//            throw new InotException(err);
//        }
//        logger.debug("Response: " + ProtoUtils.getError(response));
//        return ProtoUtils.getInscrieri(response);
//    }
//
//    public void logout(PersoanaOficiu persoanaOficiu, IInotObserver client) throws InotException {
////        PersoanaOficiuDTO udto= DTOUtils.getDTO(persoanaOficiu);
////        Request req=new Request.Builder().type(RequestType.LOGOUT).data(udto).build();
//        sendRequest(ProtoUtils.createLogoutRequest(persoanaOficiu));
//        InotProtobufs.Response response=readResponse();
//        closeConnection();
//        if (response.getType()== InotProtobufs.Response.ResponseType.ERROR){
//            String err=ProtoUtils.getError(response);
//            throw new InotException(err);
//        }
//    }
//
//    private void closeConnection() {
//        logger.debug("Closing connection");
//        finished=true;
//        try {
//            input.close();
//            output.close();
//            connection.close();
//            client=null;
//        } catch (IOException e) {
//            logger.error(e);
//            logger.error(e.getStackTrace());
//        }
//
//    }
//
//    private void sendRequest(InotProtobufs.Request request)throws InotException {
//        logger.debug("Sending request {} ",request);
//        try {
////            output.writeObject(request);
//            request.writeDelimitedTo(output);
//            output.flush();
//        } catch (IOException e) {
//            throw new InotException("Error sending object "+e);
//        }
//
//    }
//
//    private InotProtobufs.Response readResponse() throws InotException {
//        InotProtobufs.Response response=null;
//        try{
//            response=qresponses.take();
//        } catch (InterruptedException e) {
//            logger.error(e);
////            logger.error(e.getStackTrace());
//        }
//        return response;
//    }
//    private void initializeConnection() throws InotException {
//        try {
//            System.out.println("Connecting to server on port " + port + " and host " + host);
//            connection=new Socket(host,port);
//            output=connection.getOutputStream();
//            output.flush();
//            input= new BufferedInputStream(connection.getInputStream());
//            finished=false;
//            startReader();
//        } catch (IOException e) {
////            logger.error("Error initializing connection "+e);
//            logger.error(e.getStackTrace());
//        }
//    }
//    private void startReader(){
//        Thread tw=new Thread(new ReaderThread());
//        tw.start();
//    }
//
//    private void handleUpdate(InotProtobufs.Response response){
//        {
//            Inscriere inscriere = ProtoUtils.getInscriere(response);
//            logger.debug(inscriere + " received");
//            try {
//                client.inscriereAdded(inscriere);
//            } catch (InotException e) {
//                logger.error(e);
//                logger.error(e.getStackTrace());
//            }
//        }
//    }
//
//    private boolean isUpdate(InotProtobufs.Response response){return response.getType()== InotProtobufs.Response.ResponseType.INSCRIERE_ADDED;}
//
//    private class ReaderThread implements Runnable{
//        public void run() {
//            while(!finished){
//                try {
//                    InotProtobufs.Response response = InotProtobufs.Response.parseDelimitedFrom(input);
//                    logger.debug("response received "+response);
//                    if (isUpdate(response)){
//                        handleUpdate(response);
//                    }else{
//                        try {
//                            qresponses.put(response);
//                        } catch (InterruptedException e) {
//                            logger.error(e);
//                            logger.error(e.getStackTrace());
//                        }
//                    }
//                } catch (IOException e) {
//                    logger.error("Reading error "+e);
//                }
//            }
//        }
//    }
//}
