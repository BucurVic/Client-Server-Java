package rest.client;

import Inot.Network.dto.ProbaDTO;
import inot.services.rest.ServiceException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.concurrent.Callable;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class NewProbeClient {
    RestClient restClient = RestClient.builder().
            requestInterceptor(new CustomRestClientInterceptor()).
            build();

    public static final String URL = "http://localhost:8080/inot/probe";
    private <T> T execute(Callable<T> callable) {
        try {
            return callable.call();
        } catch (ResourceAccessException | HttpClientErrorException e) { // server down, resource exception
            throw new ServiceException(e);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    public ProbaDTO[] getAll() {
        return execute(() -> restClient.get().uri(URL).retrieve().body(ProbaDTO[].class));
    }

    public ProbaDTO getById(Long id) {
        return execute(() -> restClient.get().uri(String.format("%s/%s", URL, id)).retrieve().body(ProbaDTO.class));
    }

    public ProbaDTO create(ProbaDTO user) {
        return execute(() -> restClient.post().uri(URL).contentType(APPLICATION_JSON).body(user).retrieve().body(ProbaDTO.class));
    }

    public void delete(String id){
        execute(() -> restClient.delete().uri(String.format("%s/%s", URL, id)).retrieve().toBodilessEntity());
    }

    public ProbaDTO update(ProbaDTO probaDTO) {
        return execute(() -> restClient.put().uri(String.format("%s/%s", URL, probaDTO.getId())).contentType(APPLICATION_JSON).body(probaDTO).retrieve().body(ProbaDTO.class));
    }

    public class CustomRestClientInterceptor
            implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(
                HttpRequest request,
                byte[] body,
                ClientHttpRequestExecution execution) throws IOException {
            System.out.println("Sending a "+request.getMethod()+ " request to "+request.getURI()+ " and body ["+new String(body)+"]");
            ClientHttpResponse response=null;
            try {
                response = execution.execute(request, body);
                System.out.println("Got response code " + response.getStatusCode());
            }catch(IOException ex){
                System.err.println("Eroare executie "+ex);
            }
            return response;
        }
    }
}