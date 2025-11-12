package servicios;

import com.google.gson.JsonObject;
import util.ApiClient;

import java.util.Scanner;

public class ConversorService {
    private static final String API_KEY = "c05a908faa935c534e31a0fe";

    public JsonObject obtenerTasas() throws Exception {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
        String response = ApiClient.get(url);

        // Parsear correctamente el JSON y extraer el objeto conversion_rates
        JsonObject json = com.google.gson.JsonParser.parseString(response).getAsJsonObject();
        JsonObject rates = json.getAsJsonObject("conversion_rates");

        return rates;
    }


    public JsonObject obtenerTasasCast() throws Exception {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
        String response = ApiClient.get(url);
        return (JsonObject) com.google.gson.JsonParser.parseString(response)
                .getAsJsonObject()
                .getAsJsonObject("coversion_rates");
    }

    public void convertir (Scanner scanner, JsonObject rates, String from, String to) {
        System.out.printf("Ingrese el valor en %s: ", from);
        double monto = scanner.nextDouble();

        double fromRate = rates.get(from).getAsDouble();
        double toRate = rates.get(to).getAsDouble();

        double resultado = (monto / fromRate) * toRate;
        System.out.printf("%.2f %s equivalen a %.2f %s%n%n", monto, from, resultado, to);
    }
}
