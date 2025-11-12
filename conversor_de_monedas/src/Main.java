import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {

        String apiKey = "c05a908faa935c534e31a0fe";
        // Moneda base (por ejemplo USD)
        String baseCurrency = "USD";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

        //Creacion de cliente
        HttpClient client = HttpClient.newHttpClient();

        //Cracion de solicitud
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        //Obteniendo Respuesta
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}