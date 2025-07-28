package Inot.Network.rpcprotocol;

import Inot.Model.Inscriere;
import Inot.Model.PersoanaOficiu;
import Inot.Model.Proba;
import Inot.Network.dto.DTOUtils;
import Inot.Network.dto.InscriereDTO;
import Inot.Network.dto.PersoanaOficiuDTO;
import Inot.Network.dto.ProbaDTO;
import Inot.Services.IInotObserver;
import Inot.Services.IInotServices;
import Inot.Services.InotException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InotServicesRpcProxy implements IInotServices {
    private String host;
    private int port;

    private static Logger logger = LogManager.getLogger(InotServicesRpcProxy.class);

    private IInotObserver client;

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket connection;

    private BlockingQueue<Response> qresponses;
    private volatile boolean finished;
    public InotServicesRpcProxy(String host, int port) {
        this.host = host;
        this.port = port;
        qresponses=new LinkedBlockingQueue<Response>();
    }

    public void login(PersoanaOficiu persoanaOficiu, IInotObserver client) throws InotException {
        initializeConnection();
        PersoanaOficiuDTO persoanaOficiuDTO = DTOUtils.getDTO(persoanaOficiu);
        Request req=new Request.Builder().type(RequestType.LOGIN).data(persoanaOficiuDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.OK){
            this.client=client;
            return;
        }
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new InotException(err);
        }
    }

    @Override
    public Proba findProbaById(Long id) throws InotException {
        Request req = new Request.Builder().type(RequestType.FIND_PROBA_BY_ID).data(id).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            throw new InotException(err);
        }
        logger.debug("findProbaById: "+id);
        return (Proba) response.data();
    }

    @Override
    public PersoanaOficiu findByUsernameService(String username) throws InotException {
        Request req = new Request.Builder().type(RequestType.GET_PERSOANA_BY_USERNAME).data(username).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            throw new InotException(err);
        }
        logger.debug("InotServicesRpcProxy findByUsernameService");
        return (PersoanaOficiu) response.data();
    }

    @Override
    public Proba[] findAllProba() throws InotException {
        Request req = new Request.Builder().type(RequestType.GET_ALL_PROBA).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            throw new InotException(err);
        }
        logger.debug("InotServicesRpcProxy findAllProba");
        ProbaDTO[] probaDTOS = (ProbaDTO[]) response.data();
        return DTOUtils.getFromDTO(probaDTOS);
    }

    @Override
    public void addInscriere(Inscriere inscriere) throws InotException {
        InscriereDTO inscriereDTO = DTOUtils.getDTO(inscriere);
        Request req = new Request.Builder().type(RequestType.INSCRIERE_ADDED).data(inscriereDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            throw new InotException(err);
        }
    }

    @Override
    public Inscriere[] findAllInscriere() throws InotException {
        Request req = new Request.Builder().type(RequestType.GET_ALL_INSCRIERE).build();
        sendRequest(req);
        Response response = readResponse();
        if (response.type() == ResponseType.ERROR) {
            String err = response.data().toString();
            throw new InotException(err);
        }
        logger.debug("Response: " + response.data().toString());
        InscriereDTO[] inscriereDTOS = (InscriereDTO[]) response.data();
        return DTOUtils.getFromDTO(inscriereDTOS);
    }

    public void logout(PersoanaOficiu persoanaOficiu, IInotObserver client) throws InotException {
        PersoanaOficiuDTO udto= DTOUtils.getDTO(persoanaOficiu);
        Request req=new Request.Builder().type(RequestType.LOGOUT).data(udto).build();
        sendRequest(req);
        Response response=readResponse();
        closeConnection();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            throw new InotException(err);
        }
    }

    private void closeConnection() {
        logger.debug("Closing connection");
        finished=true;
        try {
            input.close();
            output.close();
            connection.close();
            client=null;
        } catch (IOException e) {
            logger.error(e);
            logger.error(e.getStackTrace());
        }

    }

    private void sendRequest(Request request)throws InotException {
        logger.debug("Sending request {} ",request);
        try {
            output.writeObject(request);
            output.flush();
        } catch (IOException e) {
            throw new InotException("Error sending object "+e);
        }

    }

    private Response readResponse() throws InotException {
        Response response=null;
        try{
            response=qresponses.take();
        } catch (InterruptedException e) {
            logger.error(e);
//            logger.error(e.getStackTrace());
        }
        return response;
    }
    private void initializeConnection() throws InotException {
        try {
            System.out.println("Connecting to server on port " + port + " and host " + host);
            connection=new Socket(host,port);
            output=new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input=new ObjectInputStream(connection.getInputStream());
            finished=false;
            startReader();
        } catch (IOException e) {
//            logger.error("Error initializing connection "+e);
            logger.error(e.getStackTrace());
        }
    }
    private void startReader(){
        Thread tw=new Thread(new ReaderThread());
        tw.start();
    }

    private void handleUpdate(Response response){
        if (response.type()== ResponseType.INSCRIERE_ADDED){
            Inscriere message = DTOUtils.getFromDTO((InscriereDTO) response.data());
            logger.debug(message.toString() + " received");
            try {
                client.inscriereAdded(message);
            } catch (InotException e) {
                logger.error(e);
                logger.error(e.getStackTrace());
            }
        }
    }

    private boolean isUpdate(Response response){
        return response.type()== ResponseType.INSCRIERE_ADDED;
    }

    private class ReaderThread implements Runnable{
        public void run() {
            while(!finished){
                try {
                    Object response=input.readObject();
                    logger.debug("response received "+response);
                    if (isUpdate((Response)response)){
                        handleUpdate((Response)response);
                    }else{
                        try {
                            qresponses.put((Response)response);
                        } catch (InterruptedException e) {
                            logger.error(e);
                            logger.error(e.getStackTrace());
                        }
                    }
                } catch (IOException|ClassNotFoundException e) {
                    logger.error("Reading error "+e);
                }
            }
        }
    }
}
