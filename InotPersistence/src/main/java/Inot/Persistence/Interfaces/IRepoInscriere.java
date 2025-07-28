package Inot.Persistence.Interfaces;

import Inot.Model.Inscriere;

public interface IRepoInscriere extends IRepository<Long, Inscriere> {
    Iterable<Inscriere> findBetweenAge(int ageMin, int ageMax);
    Long findByNumeParticipant(String numeParticipant);
    Iterable<Inscriere> findByAge(int age);
}
