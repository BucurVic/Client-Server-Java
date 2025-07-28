package Inot.Persistence;

import Inot.Model.Inscriere;
import Inot.Persistence.Interfaces.IRepoInscriere;
import org.hibernate.Session;

public class RepositoryInscriereHibernate implements IRepoInscriere {
    @Override
    public Iterable<Inscriere> findBetweenAge(int ageMin, int ageMax) {
        return null;
    }

    @Override
    public Long findByNumeParticipant(String numeParticipant) {
        return 0L;
    }

    @Override
    public Iterable<Inscriere> findByAge(int age) {
        return null;
    }

    @Override
    public Inscriere findOne(Long aLong) {
        return null;
    }

    @Override
    public Iterable<Inscriere> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Inscriere ", Inscriere.class).getResultList();
        }
    }

    @Override
    public void save(Inscriere entity) {
        HibernateUtils.getSessionFactory().inTransaction(session -> {session.persist(entity);});
    }

    @Override
    public Inscriere delete(Inscriere entity) {
        return null;
    }

    @Override
    public Inscriere update(Inscriere entity) {
        return null;
    }
}
