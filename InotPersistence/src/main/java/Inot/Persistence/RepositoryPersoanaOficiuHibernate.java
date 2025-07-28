package Inot.Persistence;

import Inot.Model.PersoanaOficiu;
import Inot.Persistence.Interfaces.IRepoPersoanaOficiu;
import org.hibernate.Session;

public class RepositoryPersoanaOficiuHibernate implements IRepoPersoanaOficiu {
    @Override
    public PersoanaOficiu findByUsername(String username) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM PersoanaOficiu WHERE username =: usrname", PersoanaOficiu.class)
                    .setParameter("usrname", username)
                    .getSingleResult();
        }
    }

    @Override
    public Iterable<PersoanaOficiu> findByLocation(String location) {
        return null;
    }

    @Override
    public PersoanaOficiu findOne(Long aLong) {
        return null;
    }

    @Override
    public Iterable<PersoanaOficiu> findAll() {
        return null;
    }

    @Override
    public void save(PersoanaOficiu entity) {

    }

    @Override
    public PersoanaOficiu delete(PersoanaOficiu entity) {
        return null;
    }

    @Override
    public PersoanaOficiu update(PersoanaOficiu entity) {
        return null;
    }
}
