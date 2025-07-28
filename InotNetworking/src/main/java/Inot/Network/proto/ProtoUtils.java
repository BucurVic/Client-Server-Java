//package Inot.Network.proto;
//
//import Inot.Model.Inscriere;
//import Inot.Model.PersoanaOficiu;
//import Inot.Model.Proba;
//
//public class ProtoUtils {
//    public static InotProtobufs.Request createLoginRequest(PersoanaOficiu persoanaOficiu) {
//        InotProtobufs.PersoanaOficiu.Builder builder = InotProtobufs.PersoanaOficiu.newBuilder();
//        if (persoanaOficiu.getId() != null)
//            builder.setId(persoanaOficiu.getId());
//        else
//            builder.setId(0);
//
//        builder.setUsername(persoanaOficiu.getUsername());
//        builder.setPassword(persoanaOficiu.getPassword());
//        builder.setLocation(persoanaOficiu.getLocation());
//
//        return InotProtobufs.Request.newBuilder()
//                .setType(InotProtobufs.Request.RequestType.LOGIN)
//                .setPersoana(builder.build())
//                .build();
//    }
//
//
//    public static InotProtobufs.Request createLogoutRequest(PersoanaOficiu persoanaOficiu) {
//        InotProtobufs.PersoanaOficiu persoana = InotProtobufs.PersoanaOficiu.newBuilder().setUsername(persoanaOficiu.getUsername()).setPassword(persoanaOficiu.getPassword()).setLocation(persoanaOficiu.getLocation()).build();
//        return InotProtobufs.Request.newBuilder().setType(InotProtobufs.Request.RequestType.LOGOUT).setPersoana(persoana).build();
//    }
//
//    public static InotProtobufs.Request createfindProbaById(Long id) {
//        InotProtobufs.Proba proba1 = InotProtobufs.Proba.newBuilder().setId(id).build();
//        return InotProtobufs.Request.newBuilder().setType(InotProtobufs.Request.RequestType.FIND_PROBA_BY_ID).setProba(proba1).build();
//    }
//
//    public static InotProtobufs.Request createfindPersoanaByUsernameRequest (String username) {
//        InotProtobufs.PersoanaOficiu persoanaOficiu = InotProtobufs.PersoanaOficiu.newBuilder().setUsername(username).build();
//        return InotProtobufs.Request.newBuilder().setType(InotProtobufs.Request.RequestType.GET_PERSOANA_BY_USERNAME).setPersoana(persoanaOficiu).build();
//    }
//
//    public static InotProtobufs.Request createfindAllInscirereRequest () {
//        return InotProtobufs.Request.newBuilder().setType(InotProtobufs.Request.RequestType.GET_ALL_INSCRIERE).build();
//    }
//
//    public static InotProtobufs.Request createfindAllProbaRequest () {
//        return InotProtobufs.Request.newBuilder().setType(InotProtobufs.Request.RequestType.GET_ALL_PROBA).build();
//    }
//
//    public static InotProtobufs.Request createInscriereAddedRequest (Inscriere inscriere) {
//        InotProtobufs.Inscriere inscriere1 = InotProtobufs.Inscriere.newBuilder().setIdProba(inscriere.getIdProba()).setNumeParticipant(inscriere.getNumeParticipant()).setVarstaParticipant(inscriere.getVarstaParticipant()).build();
//        return InotProtobufs.Request.newBuilder().setType(InotProtobufs.Request.RequestType.INSCRIERE_ADDED).setInscriere(inscriere1).build();
//    }
//
//    public static PersoanaOficiu getPersoanaOficiu(InotProtobufs.Request inotRequest) {
//        PersoanaOficiu persoanaOficiu = new PersoanaOficiu();
//        persoanaOficiu.setId(inotRequest.getPersoana().getId());
//        persoanaOficiu.setUsername(inotRequest.getPersoana().getUsername());
//        persoanaOficiu.setPassword(inotRequest.getPersoana().getPassword());
//        persoanaOficiu.setLocation(inotRequest.getPersoana().getLocation());
//        return persoanaOficiu;
//    }
//
//    public static PersoanaOficiu getPersoanaOficiu(InotProtobufs.Response inotResponse) {
//        PersoanaOficiu persoanaOficiu = new PersoanaOficiu();
//        persoanaOficiu.setId(inotResponse.getPersoanaOficiu().getId());
//        persoanaOficiu.setUsername(inotResponse.getPersoanaOficiu().getUsername());
//        persoanaOficiu.setPassword(inotResponse.getPersoanaOficiu().getPassword());
//        persoanaOficiu.setLocation(inotResponse.getPersoanaOficiu().getLocation());
//        return persoanaOficiu;
//    }
//
//    public static Inscriere getInscriere(InotProtobufs.Request inotRequest) {
//        Inscriere inscriere = new Inscriere();
//        inscriere.setId(inotRequest.getInscriere().getId());
//        inscriere.setIdProba(inotRequest.getInscriere().getIdProba());
//        inscriere.setNumeParticipant(inotRequest.getInscriere().getNumeParticipant());
//        inscriere.setVarstaParticipant(inotRequest.getInscriere().getVarstaParticipant());
//        return inscriere;
//    }
//
//    public static Inscriere getInscriere(InotProtobufs.Response inotResponse) {
//        Inscriere inscriere = new Inscriere();
//        inscriere.setId(inotResponse.getInscriere().getId());
//        inscriere.setIdProba(inotResponse.getInscriere().getIdProba());
//        inscriere.setNumeParticipant(inotResponse.getInscriere().getNumeParticipant());
//        inscriere.setVarstaParticipant(inotResponse.getInscriere().getVarstaParticipant());
//        return inscriere;
//    }
//
//    public static Inscriere[] getInscrieri(InotProtobufs.Response inotResponse) {
//        Inscriere[] inscrieres = new Inscriere[inotResponse.getInscrieriCount()];
//        for (int i = 0; i < inotResponse.getInscrieriCount(); i++) {
//            Inscriere inscriere = new Inscriere();
//            inscriere.setId(inotResponse.getInscrieri(i).getId());
//            inscriere.setIdProba(inotResponse.getInscrieri(i).getIdProba());
//            inscriere.setNumeParticipant(inotResponse.getInscrieri(i).getNumeParticipant());
//            inscriere.setVarstaParticipant(inotResponse.getInscrieri(i).getVarstaParticipant());
//            inscrieres[i] = inscriere;
//            System.out.println("Inscriere: " + inscriere);
//        }
//        return inscrieres;
//    }
//
//    public static Proba getProba(InotProtobufs.Response inotResponse) {
//        Proba proba = new Proba();
//        proba.setId(inotResponse.getProba().getId());
//        proba.setDistanta(inotResponse.getProba().getDistanta());
//        proba.setStil(inotResponse.getProba().getStil());
//        proba.setNrParticipantiInscrisi((long) inotResponse.getProba().getNrParticipantiInscrisi());
//        return proba;
//    }
//
//    public static Proba[] getProbe(InotProtobufs.Response inotResponse) {
//        Proba[] probas = new Proba[inotResponse.getProbeCount()];
//        for (int i = 0; i < inotResponse.getProbeCount(); i++) {
//            Proba proba = new Proba();
//            proba.setId(inotResponse.getProbe(i).getId());
//            proba.setDistanta(inotResponse.getProbe(i).getDistanta());
//            proba.setStil(inotResponse.getProbe(i).getStil());
//            proba.setNrParticipantiInscrisi((long) inotResponse.getProbe(i).getNrParticipantiInscrisi());
//            probas[i] = proba;
//            System.out.println("Proba: " + proba);
//        }
//        return probas;
//    }
//
//    public static String getError(InotProtobufs.Response response){
//        String errorMessage=response.getError();
//        return errorMessage;
//    }
//
//    public static InotProtobufs.Response createGetAllInscriereResponse(Inscriere[] inscrieri) {
//        InotProtobufs.Response.Builder responseBuilder = InotProtobufs.Response.newBuilder().setType(InotProtobufs.Response.ResponseType.GET_ALL_INSCRIERE);
//        for (Inscriere inscriere : inscrieri) {
//            responseBuilder.addInscrieri(InotProtobufs.Inscriere.newBuilder().setId(inscriere.getId()).setIdProba(inscriere.getIdProba()).setNumeParticipant(inscriere.getNumeParticipant()).setVarstaParticipant(inscriere.getVarstaParticipant()).build());
//        }
//        return responseBuilder.build();
//    }
//
//    public static InotProtobufs.Response createGetAllProbaResponse(Proba[] probe) {
//        InotProtobufs.Response.Builder responseBuilder = InotProtobufs.Response.newBuilder().setType(InotProtobufs.Response.ResponseType.GET_ALL_PROBA);
//        for (Proba proba : probe) {
//            responseBuilder.addProbe(InotProtobufs.Proba.newBuilder().setId(proba.getId()).setDistanta(proba.getDistanta()).setStil(proba.getStil()).setNrParticipantiInscrisi(Math.toIntExact(proba.getNrParticipantiInscrisi())).build());
//        }
//        return responseBuilder.build();
//    }
//
//    public static InotProtobufs.Response createGetPersoanaByUsernameResponse(PersoanaOficiu persoanaOficiu) {
//        InotProtobufs.Response.Builder responseBuilder = InotProtobufs.Response.newBuilder().setType(InotProtobufs.Response.ResponseType.GET_PERSOANA_BY_USERNAME);
//        responseBuilder.setPersoanaOficiu(InotProtobufs.PersoanaOficiu.newBuilder().setId(persoanaOficiu.getId()).setUsername(persoanaOficiu.getUsername()).setPassword(persoanaOficiu.getPassword()).setLocation(persoanaOficiu.getLocation()).build());
//        return responseBuilder.build();
//    }
//
//    public static InotProtobufs.Response createInscriereAddedResponse(Inscriere inscriere) {
//        InotProtobufs.Inscriere inscriere1 = InotProtobufs.Inscriere.newBuilder().setId(inscriere.getId()).setIdProba(inscriere.getIdProba()).setNumeParticipant(inscriere.getNumeParticipant()).setVarstaParticipant(inscriere.getVarstaParticipant()).build();
//        return InotProtobufs.Response.newBuilder().setType(InotProtobufs.Response.ResponseType.INSCRIERE_ADDED).setInscriere(inscriere1).build();
//    }
//
//    public static InotProtobufs.Response createOkResponse(){
//        return InotProtobufs.Response.newBuilder()
//                .setType(InotProtobufs.Response.ResponseType.OK).build();
//    }
//
//    public static InotProtobufs.Response createErrorResponse(String text){
//        return InotProtobufs.Response.newBuilder()
//                .setType(InotProtobufs.Response.ResponseType.ERROR)
//                .setError(text).build();
//    }
//}
