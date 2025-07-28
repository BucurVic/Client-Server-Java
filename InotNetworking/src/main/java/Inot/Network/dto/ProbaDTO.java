package Inot.Network.dto;

import java.io.Serializable;

public class ProbaDTO implements Serializable {
    private String id;
    private String distanta;
    private String stil;
    private Long nrParticipantiInscrisi;

    public ProbaDTO() {}

    public ProbaDTO(String id, String distanta, String stil, Long nrParticipantiInscrisi) {
        this.id = id;
        this.distanta = distanta;
        this.stil = stil;
        this.nrParticipantiInscrisi = nrParticipantiInscrisi;
    }


    public String getDistanta() {
        return distanta;
    }

    public String getStil() {
        return stil;
    }

    public Long getNrParticipantiInscrisi() {
        return nrParticipantiInscrisi;
    }

    @Override
    public String toString() {
        return "ProbaDTO["+ distanta + ", " + stil + ", " + nrParticipantiInscrisi + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDistanta(String distanta) {
        this.distanta = distanta;
    }

    public void setStil(String stil) {
        this.stil = stil;
    }

    public void setNrParticipantiInscrisi(Long nrParticipantiInscrisi) {
        this.nrParticipantiInscrisi = nrParticipantiInscrisi;
    }
}
