package start;

import Inot.Model.Proba;
import inot.services.rest.ServiceException;
import org.springframework.web.client.RestClientException;
import rest.client.ProbeClient;


public class StartRestTemplateClient {
    private final static ProbeClient probeClient=new ProbeClient();
    public static void main(String[] args) {
        //  RestTemplate restTemplate=new RestTemplate();
        Proba proba = new Proba("test2025","133", 100);
        try{
            //  User result= restTemplate.postForObject("http://localhost:8080/chat/users",userT, User.class);

            //  System.out.println("Result received "+result);
      /*  System.out.println("Updating  user ..."+userT);
        userT.setName("New name 2");
        restTemplate.put("http://localhost:8080/chat/users/test124", userT);

*/
            // System.out.println(restTemplate.postForObject("http://localhost:8080/chat/users",userT, User.class));
            //System.out.println( restTemplate.postForObject("http://localhost:8080/chat/users",userT, User.class));
            System.out.println("Adding a new proba "+proba);
            show(()-> System.out.println(probeClient.create(proba)));
            System.out.println("\n  Printing all probe ...");
            show(()->{
                Proba[] res=probeClient.getAll();
                for(Proba u:res){
                    System.out.println(u.getId()+": "+u.getDistanta() + ", " + u.getStil() + ", " + u.getNrParticipantiInscrisi());
                }
            });
//            System.out.println("\nUpdating the new Proba "+proba);
//            Proba newProba = new Proba("updated2025","000", 200);
//            proba.setDistanta(newProba.getDistanta());
//            proba.setStil(newProba.getStil());
//            proba.setNrParticipantiInscrisi(newProba.getNrParticipantiInscrisi());
//            show(()-> probeClient.update(proba));
//
//            System.out.println("\nDeleting the new Proba ...");
//            show(()->{probeClient.delete(newProba.getId().toString());});
        } catch(RestClientException ex){
            System.out.println("Exception ... "+ex.getMessage());
        }

        System.out.println("\n  Info for Proba with id=2");
        show(()-> System.out.println(probeClient.getById("2")));
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
