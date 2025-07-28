package Inot.Persistence.Interfaces;

import Inot.Model.Proba;

public interface IRepoProba extends IRepository<Long, Proba> {
    Iterable<Proba> findByNrParticipanti(int nrParticipantiInscrisi);
    Iterable<Proba> findByDistanta(String distanta);
}
