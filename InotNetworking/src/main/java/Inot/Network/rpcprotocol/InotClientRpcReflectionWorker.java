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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class InotClientRpcReflectionWorker implements Runnable, IInotObserver {
    private IInotServices server;
    private Socket connection;

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private volatile boolean connected;

    private static Logger logger = LogManager.getLogger(InotClientRpcReflectionWorker.class);

    public InotClientRpcReflectionWorker(IInotServices server, Socket connection) {
        this.server = server;
        this.connection = connection;
        try{
            output=new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input=new ObjectInputStream(connection.getInputStream());
            connected=true;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
            logger.error(e.getStackTrace());
        }
    }

    public void run() {
        while(connected){
            try {
                Object request=input.readObject();
                Response response=handleRequest((Request)request);
                if (response!=null){
                    sendResponse(response);
                }
            } catch (IOException|ClassNotFoundException e) {
                e.printStackTrace();
                logger.error(e);
                logger.error(e.getStackTrace());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error(e);
                logger.error(e.getStackTrace());
            }
        }
        try {
            input.close();
            output.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error "+e);
        }
    }

    @Override
    public void inscriereAdded(Inscriere inscriere) throws InotException {
        InscriereDTO inscriereDTO = DTOUtils.getDTO(inscriere);
        Response resp = new Response.Builder().type(ResponseType.INSCRIERE_ADDED).data(inscriereDTO).build();
        logger.info(resp.toString());
        try{
            sendResponse(resp);
        }catch (IOException e){
            e.printStackTrace();
            logger.error("Error:" + e);
        }
    }


    private static Response okResponse=new Response.Builder().type(ResponseType.OK).build();

    private Response handleRequest(Request request){
        Response response=null;
        String handlerName="handle"+(request).type();
        logger.debug("HandlerName "+handlerName);
        try {
            Method method=this.getClass().getDeclaredMethod(handlerName, Request.class);
            response=(Response)method.invoke(this,request);
            logger.debug("Method "+handlerName+ " invoked");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            logger.error(e);
            logger.error(e.getStackTrace());
            e.printStackTrace();
        }
        return response;
    }

    private Response handleLOGIN(Request request){
        logger.debug("Login request ..."+request.type());
        PersoanaOficiuDTO persoanaOficiuDTO = (PersoanaOficiuDTO)request.data();
        PersoanaOficiu persoanaOficiu = DTOUtils.getFromDTO(persoanaOficiuDTO);
        try {
            server.login(persoanaOficiu, this);
            return okResponse;
        } catch (InotException e) {
            connected=false;
            return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
        }
    }

    private Response handleLOGOUT(Request request){
        logger.debug("Logout request...");
        PersoanaOficiuDTO persoanaOficiuDTO = (PersoanaOficiuDTO)request.data();
        PersoanaOficiu persoanaOficiu = DTOUtils.getFromDTO(persoanaOficiuDTO);
        try {
            server.logout(persoanaOficiu, this);
            connected=false;
            return okResponse;
        } catch (InotException e) {
            return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
        }
    }

    private Response handleINSCRIERE_ADDED(Request request){
        logger.debug("Add inscriere");
        InscriereDTO inscriereDTO = (InscriereDTO)request.data();
        Inscriere inscriere = DTOUtils.getFromDTO(inscriereDTO);
        new Thread(() -> {
            try{
                server.addInscriere(inscriere);
            }catch (InotException e){
                e.printStackTrace();
                logger.error(e);
            }
        }).start();
        return okResponse;
    }

    private Response handleGET_ALL_INSCRIERE(Request request){
        logger.debug("Find all inscriere");
        try{
            Inscriere[] inscrieres = server.findAllInscriere();
            InscriereDTO[] inscriereDTOS = DTOUtils.getDTO(inscrieres);
            return new Response.Builder().type(ResponseType.GET_ALL_INSCRIERE).data(inscriereDTOS).build();
        }catch (InotException e){
            return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
        }
    }

    private Response handleGET_ALL_PROBA(Request request){
        logger.debug("Find all inscriere");
        try{
            Proba[] probe = server.findAllProba();
            ProbaDTO[] probaDTOS = DTOUtils.getDTO(probe);
            return new Response.Builder().type(ResponseType.GET_ALL_PROBA).data(probaDTOS).build();
        }catch (InotException e){
            return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
        }
    }

    private Response handleGET_PERSOANA_BY_USERNAME(Request request){
        logger.debug("Find persoane by username");
        String username=(String)request.data();
        try{
            return new Response.Builder().type(ResponseType.GET_PERSOANA_BY_USERNAME).data(server.findByUsernameService(username)).build();
        }catch (InotException e){
            return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
        }
    }

    private void sendResponse(Response response) throws IOException{
        logger.debug("sending response {}",response);
        synchronized (output) {
            output.writeObject(response);
            output.flush();
        }
    }

}
