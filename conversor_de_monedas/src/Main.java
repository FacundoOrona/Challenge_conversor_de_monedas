import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Main {

    public static void main(String[] args) {

        String api_key = "c05a908faa935c534e31a0fe";
        String url = "https://v6.exchangerate-api.com/v6/"+
                api_key+"/pair/";

        //Creacion de cliente
        HttpClient client = HttpClient.newHttpClient();

        //Cracion de solicitud
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

    }

}