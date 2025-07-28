package Inot.Network.dto;

import java.io.Serializable;

public class InscriereDTO implements Serializable {
    private long idProba;
    private String numeParticipant;
    private int varstaParticipant;

    public InscriereDTO(long idProba, String numeParticipant, int varstaParticipant) {
        this.idProba = idProba;
        this.numeParticipant = numeParticipant;
        this.varstaParticipant = varstaParticipant;
    }

    public long getIdProba() {
        return idProba;
    }

    public void setIdProba(long idProba) {
        this.idProba = idProba;
    }

    public String getNumeParticipant() {
        return numeParticipant;
    }

    public void setNumeParticipant(String numeParticipant) {
        this.numeParticipant = numeParticipant;
    }

    public int getVarstaParticipant() {
        return varstaParticipant;
    }

    public void setVarstaParticipant(int varstaParticipant) {
        this.varstaParticipant = varstaParticipant;
    }

    @Override
    public String toString() {
        return "InscriereDTO [idProba=" + idProba + ", numeParticipant=" + numeParticipant;
    }
}
