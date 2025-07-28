package rest.client;

import Inot.Model.Proba;
import Inot.Model.Proba;
import inot.services.rest.ServiceException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;


public class ProbeClient {
    public static final String URL = "http://localhost:8080/inot/probe";

    private RestTemplate restTemplate = new RestTemplate();

    private <T> T execute(Callable<T> callable) {
        try {
            return callable.call();
        } catch (ResourceAccessException | HttpClientErrorException e) { // server down, resource exception
            throw new ServiceException(e);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Proba[] getAll() {
        return execute(() -> restTemplate.getForObject(URL, Proba[].class));
    }

    public Proba getById(String id) {
        return execute(() -> restTemplate.getForObject(String.format("%s/%s", URL, id), Proba.class));
    }

    public Proba create(Proba user) {
        return execute(() -> restTemplate.postForObject(URL, user, Proba.class));
    }

    public void update(Proba user) {
        execute(() -> {
            restTemplate.put(String.format("%s/%s", URL, user.getId()), user);
            return null;
        });
    }

    public void delete(String id) {
        execute(() -> {
            restTemplate.delete(String.format("%s/%s", URL, id));
            return null;
        });
    }

}
