package Inot.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table (name = "Probe")
public class Proba extends Entity<Long> implements Comparable<Proba> {
    private String distanta;
    private String stil;
    private Long nrParticipantiInscrisi;

    public Proba() {}

    public Proba(String distanta, String stil, long nrParticipantiInscrisi) {
        this.distanta = distanta;
        this.stil = stil;
        this.nrParticipantiInscrisi = nrParticipantiInscrisi;
    }


    @Column (name = "distanta")
    public String getDistanta() {
        return distanta;
    }

    public void setDistanta(String distanta) {
        this.distanta = distanta;
    }

    @Column (name = "stil")
    public String getStil() {
        return stil;
    }

    public void setStil(String stil) {
        this.stil = stil;
    }

    @Column (name = "nr_participanti_inscrisi")
    public Long getNrParticipantiInscrisi() {
        return nrParticipantiInscrisi;
    }

    public void setNrParticipantiInscrisi(Long nrParticipantiInscrisi) {
        this.nrParticipantiInscrisi = nrParticipantiInscrisi;
    }

    @Override
    public int compareTo(Proba o) {
//        return this.distanta.compareTo(o.distanta);
        return 0;
    }

    @Override
    public String toString() {
        return "Proba{" +
                "distanta='" + distanta + '\'' +
                ", stil='" + stil + '\'' +
                ", nrParticipantiInscrisi=" + nrParticipantiInscrisi +
                '}';
    }
}
