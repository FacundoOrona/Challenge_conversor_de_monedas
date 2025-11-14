package menu;

import com.google.gson.JsonObject;
import servicios.ConversorService;

import java.util.Scanner;

public class Menu {
    private final ConversorService conversorService = new ConversorService();
    private final Scanner scanner = new Scanner(System.in);

    public void mostrar() {
        try {
            JsonObject rates = conversorService.obtenerTasas();

            int opcion;
            do {
                mostrarMenu();
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> conversorService.convertir(scanner, rates, "USD", "ARS");
                    case 2 -> conversorService.convertir(scanner, rates, "ARS", "USD");
                    case 3 -> conversorService.convertir(scanner, rates, "USD", "BRL");
                    case 4 -> conversorService.convertir(scanner, rates, "BRL", "USD");
                    case 5 -> conversorService.convertir(scanner, rates, "USD", "COP");
                    case 6 -> conversorService.convertir(scanner, rates, "COP", "USD");
                    case 7 -> {
                        System.out.println("\n ==== HISTORIAL DE CONVERSIONES ====");
                        conversorService.getHistorial().forEach(System.out::println);
                        break;
                    }
                    case 8 -> System.out.println("Gracias por usar el programa de Conversor de monedas :)");
                    default -> System.out.println("Opcion no valida. Intente nuevamente");
                }


            } while (opcion != 8);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarMenu() {
        System.out.println("""
                ******************************************************
                Sea bienvenido/a al conversor de monedas :)
                
                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Real brasileño
                4) Real brasileño => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Salir
                
                Elija una opción válida:
                ******************************************************
                """);
    }

}
