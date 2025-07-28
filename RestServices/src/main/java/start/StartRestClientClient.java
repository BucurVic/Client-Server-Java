package start;

import Inot.Network.dto.ProbaDTO;
import inot.services.rest.ServiceException;
import org.springframework.web.client.RestClientException;
import rest.client.NewProbeClient;

import java.util.Scanner;

public class StartRestClientClient {
    private final static NewProbeClient probeClient = new NewProbeClient();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProbaDTO probaDTO = new ProbaDTO();
        probaDTO.setDistanta("800m");
        probaDTO.setStil("liber");
        probaDTO.setNrParticipantiInscrisi(5L);
        try {
            System.out.println("Adding a new proba " + probaDTO);
            ProbaDTO addedProba = probeClient.create(probaDTO);
            show(() -> System.out.println(addedProba));
            scanner.nextLine();

            System.out.println("\nPrinting all Probe ...");
            show(() -> {
                ProbaDTO[] res = probeClient.getAll();
                for(ProbaDTO t: res){
                    System.out.println(t.getId() + ": " + t.getDistanta());
                }
            });
            scanner.nextLine();

            System.out.println("\nInfo for Proba with id = 2");
            show(() -> System.out.println(probeClient.getById(2L)));
            scanner.nextLine();

            System.out.println("\nUpdating Proba with id = " + addedProba.getId());
            ProbaDTO updatedProbaDTO = new ProbaDTO();
            updatedProbaDTO.setId(addedProba.getId());
            updatedProbaDTO.setDistanta("updated800m");
            updatedProbaDTO.setStil("updatedliber");
            updatedProbaDTO.setNrParticipantiInscrisi(25L);
            ProbaDTO updatedTrip = probeClient.update(updatedProbaDTO);
            show(() -> System.out.println(updatedTrip));
            scanner.nextLine();

            System.out.println("\nDeleting user with id = " + addedProba.getId());
            show(() -> probeClient.delete(updatedProbaDTO.getId()));
        } catch (RestClientException ex) {
            System.out.println("Exception ... " + ex.getMessage());
        }
    }

    private static void show(Runnable task) {
        try {
            task.run();
        } catch (ServiceException e) {
            //  LOG.error("Service exception", e);
            System.out.println("Service exception"+ e);
        }
    }
}