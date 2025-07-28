package Inot.Persistence.Interfaces;

import Inot.Model.Entity;

public interface IRepository<ID, E extends Entity<ID>> {
    E findOne(ID id);
    Iterable<E> findAll();
    void save(E entity);
    E delete(E entity);
    E update(E entity);
}
