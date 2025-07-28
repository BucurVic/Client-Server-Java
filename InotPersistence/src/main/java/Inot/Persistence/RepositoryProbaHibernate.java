package Inot.Persistence;

import Inot.Model.Proba;
import Inot.Persistence.Interfaces.IRepoProba;
import org.hibernate.Session;

public class RepositoryProbaHibernate implements IRepoProba {
    @Override
    public Iterable<Proba> findByNrParticipanti(int nrParticipantiInscrisi) {
        return null;
    }

    @Override
    public Iterable<Proba> findByDistanta(String distanta) {
        return null;
    }

    @Override
    public Proba findOne(Long aLong) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Proba WHERE id=:id1", Proba.class)
                    .setParameter("id1", aLong)
                    .getSingleResult();
        }
    }

    @Override
    public Iterable<Proba> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Proba", Proba.class).getResultList();
        }
    }

    @Override
    public void save(Proba entity) {

    }

    @Override
    public Proba delete(Proba entity) {
        return null;
    }

    @Override
    public Proba update(Proba entity) {
        HibernateUtils.getSessionFactory().inTransaction(session -> {
            if (session.find(Proba.class, entity.getId()) != null) {
                session.merge(entity);
                session.flush();
            }
        });
        return entity;
    }
}
