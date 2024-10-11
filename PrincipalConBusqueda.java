import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;
import org.json.JSONObject;

public class PrincipalConBusqueda {
    // Este Metodo ayuda a obtener las tasas de cambio
    public HashMap<String, Double> obtenerTasasDeCambio() throws IOException, InterruptedException {

        // Asi creo el cliente  en HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Aqui informamos la URL de la API y crea el buid
        String https = "https://v6.exchangerate-api.com/v6/52951cbaa6e9ad97ad952792/latest/USD";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(https))
                .build();

        // Envio la solicitud y recibo la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parsear la respuesta en JSON
        JSONObject jsonResponse = new JSONObject(response.body());

        // Obtengo las tasas de cambio
        JSONObject rates = jsonResponse.getJSONObject("conversion_rates");

        // Convierto las rate a HashMap
        HashMap<String, Double> tasas = new HashMap<>();
        for (String key : rates.keySet()) {
            tasas.put(key, rates.getDouble(key));
        }
        return tasas;
    }
}