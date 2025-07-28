package Inot.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "Inscrieri")
public class Inscriere extends Entity<Long> implements Comparable<Inscriere> {
    private long idProba;
    private String numeParticipant;
    private int varstaParticipant;

    public Inscriere(long idProba, String numeParticipant, int varstaParticipant) {
        this.idProba = idProba;
        this.numeParticipant = numeParticipant;
        this.varstaParticipant = varstaParticipant;
    }

    public Inscriere() {}

    @Column(name = "id_proba")
    public long getIdProba() {
        return idProba;
    }
    public void setIdProba(long idProba) {
        this.idProba = idProba;
    }

    @Column(name = "nume_participant")
    public String getNumeParticipant() {
        return numeParticipant;
    }
    public void setNumeParticipant(String numeParticipant) {
        this.numeParticipant = numeParticipant;
    }

    @Column(name = "varsta_participant")
    public int getVarstaParticipant() {
        return varstaParticipant;
    }
    public void setVarstaParticipant(int varstaParticipant) {
        this.varstaParticipant = varstaParticipant;
    }

    @Override
    public String toString() {
        return "Inscriere{" +
                "idProba=" + idProba +
                ", numeParticipant='" + numeParticipant + '\'' +
                ", varstaParticipant='" + varstaParticipant + '\'' +
                '}';
    }

    @Override
    public int compareTo(Inscriere o) {
//        return this.numeParticipant.compareTo(o.numeParticipant);
        return 0;
    }
}
