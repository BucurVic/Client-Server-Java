package Inot.Services;

import Inot.Model.Inscriere;
import Inot.Model.PersoanaOficiu;
import Inot.Model.Proba;

public interface IInotServices {
    void login (PersoanaOficiu persoana, IInotObserver client) throws InotException;
    Proba findProbaById (Long id) throws InotException;
    PersoanaOficiu findByUsernameService(String username) throws InotException;
    Proba[] findAllProba() throws InotException;
    void addInscriere(Inscriere inscriere) throws InotException;
    Inscriere[] findAllInscriere() throws InotException;
    void logout (PersoanaOficiu persoana, IInotObserver client) throws InotException;

}
