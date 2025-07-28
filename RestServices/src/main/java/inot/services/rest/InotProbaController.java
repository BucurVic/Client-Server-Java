package inot.services.rest;

import Inot.Model.Proba;
import Inot.Network.dto.ProbaDTO;
import Inot.Persistence.Interfaces.IRepoProba;
import Inot.Persistence.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/inot/probe")
public class InotProbaController {

    private static final String template = "Hello, %s!";

    @Autowired
    private IRepoProba repoProba;

    @RequestMapping("/greeting")
    public  String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format(template, name);
    }


    @RequestMapping( method= RequestMethod.GET)
    public Proba[] getAll(){
        System.out.println("Get all Probe ...");
        Iterable<Proba> proba = repoProba.findAll();
        List<Proba> probaList = new ArrayList<>();
        proba.forEach(probaList::add);
        return probaList.toArray(new Proba[0]);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable String id){
        System.out.println("Get by id "+id);
        Proba proba = repoProba.findOne(Long.parseLong(id));
        if (proba==null)
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(proba, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProbaDTO create(@RequestBody ProbaDTO proba){
        System.out.println("Creating Proba ...");
        Proba newProba = new Proba(proba.getDistanta(), proba.getStil(), proba.getNrParticipantiInscrisi());
        repoProba.save(newProba);
        proba.setId(String.valueOf(newProba.getId()));
        return proba;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody ProbaDTO probaDTO, @PathVariable String id) {
        System.out.println("Updating Proba with id: " + probaDTO.getId());
        if (!id.equals(probaDTO.getId())) {
            return new ResponseEntity<String>("Path Id and Object Id do not match!", HttpStatus.BAD_REQUEST);
        }
        try {
            Proba proba = repoProba.findOne(Long.parseLong(probaDTO.getId()));
            if (proba == null)
                return new ResponseEntity<String>("Proba not found", HttpStatus.NOT_FOUND);
            else {
                proba.setDistanta(probaDTO.getDistanta());
                proba.setStil(probaDTO.getStil());
                proba.setNrParticipantiInscrisi(probaDTO.getNrParticipantiInscrisi());
                repoProba.update(proba);
                System.out.println("Proba updated ..." + probaDTO);
                return new ResponseEntity<ProbaDTO>(probaDTO, HttpStatus.OK);
            }
        } catch (RepositoryException ex){
            System.out.println("Ctrl Update Proba exception");
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id){
        System.out.println("Deleting Proba with id: " + id);
        try {
            Proba proba = repoProba.findOne(Long.parseLong(id));
            if (proba == null) {
                return new ResponseEntity<String>("Proba not found", HttpStatus.NOT_FOUND);
            }
            ProbaDTO probaDTO = new ProbaDTO();
            probaDTO.setId(String.valueOf(proba.getId()));
            probaDTO.setDistanta(proba.getDistanta());
            probaDTO.setStil(proba.getStil());
            probaDTO.setNrParticipantiInscrisi(proba.getNrParticipantiInscrisi());
            repoProba.delete(proba);
            System.out.println("Proba deleted ..." + probaDTO);
            return new ResponseEntity<ProbaDTO>(probaDTO, HttpStatus.OK);
        } catch (RepositoryException ex){
            System.out.println("Ctrl Delete Proba exception");
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(RepositoryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userError(RepositoryException e) {
        return e.getMessage();
    }
}