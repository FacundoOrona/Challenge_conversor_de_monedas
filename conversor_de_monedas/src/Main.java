import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String apiKey = "c05a908faa935c534e31a0fe";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            // Interfaz simple de consola
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Conversor de Monedas ===");
            System.out.print("Ingrese moneda origen (ej: ARS): ");
            String from = scanner.next().toUpperCase();
            System.out.print("Ingrese moneda destino (ej: BRL): ");
            String to = scanner.next().toUpperCase();
            System.out.print("Ingrese monto a convertir: ");
            double amount = scanner.nextDouble();

            // Tasas
            double fromRate = rates.get(from).getAsDouble();
            double toRate = rates.get(to).getAsDouble();

            // Conversión
            double converted = convert(amount, fromRate, toRate);

            System.out.printf("%.2f %s equivalen a %.2f %s%n", amount, from, converted, to);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Metodo reutilizable
    private static double convert(double amount, double fromRate, double toRate) {
        return (amount / fromRate) * toRate;
    }
}
