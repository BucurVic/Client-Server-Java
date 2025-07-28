package Inot.Services;

import Inot.Model.Inscriere;

public interface IInotObserver {
    void inscriereAdded(Inscriere inscriere) throws InotException;
}
