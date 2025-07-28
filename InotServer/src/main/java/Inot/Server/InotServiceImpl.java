package Inot.Server;

import Inot.Model.Inscriere;
import Inot.Model.PersoanaOficiu;
import Inot.Model.Proba;
import Inot.Persistence.Interfaces.IRepoInscriere;
import Inot.Persistence.Interfaces.IRepoPersoanaOficiu;
import Inot.Persistence.Interfaces.IRepoProba;
import Inot.Services.IInotObserver;
import Inot.Services.IInotServices;
import Inot.Services.InotException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InotServiceImpl implements IInotServices {
    private static final Logger logger = LogManager.getLogger();

    private final IRepoPersoanaOficiu repoPersoanaOficiu;
    private final IRepoProba repoProba;
    private final IRepoInscriere repoInscriere;

    private Map<String, IInotObserver> persoaneLogate;
    public InotServiceImpl(IRepoPersoanaOficiu repoPersoana, IRepoProba iRepoProba, IRepoInscriere iRepoInscriere) {
        this.repoPersoanaOficiu = repoPersoana;
        this.repoProba = iRepoProba;
        this.repoInscriere = iRepoInscriere;
        persoaneLogate = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized void login(PersoanaOficiu persoana, IInotObserver client) throws InotException {
        PersoanaOficiu persoanaOficiu = findByUsernameService(persoana.getUsername());
        if (persoanaOficiu != null) {
            if (persoaneLogate.get(persoanaOficiu.getUsername()) != null) {
                throw new InotException("Already logged in");
            }
            if (persoanaOficiu.getPassword().equals(persoana.getPassword())) {
                persoaneLogate.put(persoanaOficiu.getUsername(), client);
            }
            else{
                throw new InotException("Wrong password");
            }
        }
        else {
            throw new InotException("No account found");
        }
    }

    @Override
    public Proba findProbaById(Long id) throws InotException {
//        return repoProba.findOne(id).orElseThrow(() -> new InotException("Eroare la cautare inscriere"));
        return repoProba.findOne(id);
    }

    public PersoanaOficiu findByUsernameService(String username) {
        logger.traceEntry("Enter Service findByUsernameService");
        return repoPersoanaOficiu.findByUsername(username);
    }

    public Proba[] findAllProba() {
        logger.traceEntry("Enter Service findAllProba");
        Iterable<Proba> proba = repoProba.findAll();
        List<Proba> probaSet = new ArrayList<>();
        proba.forEach(probaSet::add);
        return probaSet.toArray(new Proba[0]);
    }

    public void addInscriere(Inscriere inscriere) throws InotException {
        logger.traceEntry("Enter Service addInscriere");
        Proba proba = findProbaById(inscriere.getIdProba());
        proba.setNrParticipantiInscrisi(proba.getNrParticipantiInscrisi() + 1);
        repoProba.update(proba);
        repoInscriere.save(inscriere);
        for (IInotObserver observer : persoaneLogate.values()) {
            try{
                observer.inscriereAdded(inscriere);
            }catch (InotException e){
                System.err.println("Eroare notificare Client" + e.getMessage());
                logger.error("Eroare notificare Client" + e.getMessage());
            }
        }
        logger.traceExit("Exit Service addInscriere");
    }

    public Inscriere[] findAllInscriere() {
        logger.traceEntry("Enter Service findAllInscriere");
        Iterable<Inscriere> inscrieres = repoInscriere.findAll();
        List<Inscriere> inscriereSet = new ArrayList<>();
        inscrieres.forEach(inscriereSet::add);
        return inscriereSet.toArray(new Inscriere[0]);
    }

    @Override
    public void logout(PersoanaOficiu persoana, IInotObserver client) throws InotException {
        IInotObserver localClient = persoaneLogate.remove(persoana.getUsername());
        if (localClient == null) {
            throw new InotException("User" + persoana.getUsername() + "Not logged in");
        }
    }
}
