package Inot.Persistence.Interfaces;

import Inot.Model.PersoanaOficiu;

public interface IRepoPersoanaOficiu extends IRepository<Long, PersoanaOficiu>{
    PersoanaOficiu findByUsername(String username);
    Iterable<PersoanaOficiu> findByLocation(String location);
}
