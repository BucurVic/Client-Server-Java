package Inot.Network.dto;

import Inot.Model.Inscriere;
import Inot.Model.PersoanaOficiu;
import Inot.Model.Proba;

public class DTOUtils {
    public static PersoanaOficiu getFromDTO(PersoanaOficiuDTO persoanaOficiuDTO) {
        String username = persoanaOficiuDTO.getUsername();
        String password = persoanaOficiuDTO.getPassword();
        String location = persoanaOficiuDTO.getLocation();
        return new PersoanaOficiu(username, password, location);
    }

    public static PersoanaOficiuDTO getDTO(PersoanaOficiu persoanaOficiu) {
        String username = persoanaOficiu.getUsername();
        String password = persoanaOficiu.getPassword();
        String location = persoanaOficiu.getLocation();
        return new PersoanaOficiuDTO(username, password, location);
    }

    public static Proba getFromDTO(ProbaDTO probaDTO) {
        String distanta = probaDTO.getDistanta();
        String stil = probaDTO.getStil();
        Long nrParticipantiInscrisi = probaDTO.getNrParticipantiInscrisi();
        Proba proba = new Proba(distanta, stil, nrParticipantiInscrisi);
        proba.setId(Long.parseLong(probaDTO.getId()));
        return proba;
    }

    public static ProbaDTO getDTO(Proba proba) {
        String id = proba.getId().toString();
        String distanta = proba.getDistanta();
        String stil = proba.getStil();
        Long nrParticipantiInscrisi = proba.getNrParticipantiInscrisi();
        return new ProbaDTO(id ,distanta, stil, nrParticipantiInscrisi);
    }

    public static Inscriere getFromDTO(InscriereDTO inscriere) {
        long idProba = inscriere.getIdProba();
        String numeParticipant = inscriere.getNumeParticipant();
        int varstaParticipant = inscriere.getVarstaParticipant();
        return new Inscriere(idProba, numeParticipant, varstaParticipant);
    }

    public static InscriereDTO getDTO(Inscriere inscriere) {
        long idProba = inscriere.getIdProba();
        String numeParticipant = inscriere.getNumeParticipant();
        int varstaParticipant = inscriere.getVarstaParticipant();
        return new InscriereDTO(idProba, numeParticipant, varstaParticipant);
    }


    public static ProbaDTO[] getDTO(Proba[] probas){
        ProbaDTO[] probaDTOS=new ProbaDTO[probas.length];
        for(int i=0;i<probas.length;i++)
            probaDTOS[i]=getDTO(probas[i]);
        return probaDTOS;
    }

    public static Proba[] getFromDTO(ProbaDTO[] probaDTOS) {
        Proba[] probas =new Proba[probaDTOS.length];
        for(int i=0;i<probaDTOS.length;i++){
            probas[i]=getFromDTO(probaDTOS[i]);
        }
        return probas;
    }

    public static InscriereDTO[] getDTO(Inscriere[] inscrieres) {
        InscriereDTO[] inscriereDTOS=new InscriereDTO[inscrieres.length];
        for(int i=0;i<inscrieres.length;i++)
            inscriereDTOS[i]=getDTO(inscrieres[i]);
        return inscriereDTOS;
    }

    public static Inscriere[] getFromDTO(InscriereDTO[] inscriereDTOS) {
        Inscriere[] inscrieres =new Inscriere[inscriereDTOS.length];
        for(int i=0;i<inscriereDTOS.length;i++){
            inscrieres[i]=getFromDTO(inscriereDTOS[i]);
        }
        return inscrieres;
    }

}
