import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;

public class ConversorMoneda extends PrincipalConBusqueda {
    HashMap<String, Double> tasas; // Este es el hashmap de las tasas que esta en la clase de PrincipalConBusqueda
    Scanner scanner = new Scanner(System.in);

    public ConversorMoneda() {
        try {
            tasas = obtenerTasasDeCambio(); // Aqui obtengo las tasas de cambio
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            tasas = new HashMap<>(); // En caso de error, aqui inicializa tasas vacías
        }
    }
    //Logica dell programa

    public void iniciarConversor() {
        int opcionUsuario=0;

        while (opcionUsuario != 8 ) {
            MenuDelConversor mostrarMenu = new MenuDelConversor();
            MenuDelConversor.mostrarMenu();
            System.out.println("Elije una opción valida");
            opcionUsuario = scanner.nextInt();

             if (opcionUsuario >= 1 && opcionUsuario <= 7) {
                 System.out.print("Ingresa la cantidad que deseas convertir: ");
                 double cantidadConvertida = 0;
                 double cantidad = scanner.nextDouble();
                 switch (opcionUsuario) {
                        case 1: // Dolar a Peso Argentino
                            cantidadConvertida = cantidad * tasas.get("ARS");
                            System.out.printf("El valor de %.2f Dólares (USD) es equivalente a: %.2f Pesos Argentinos (ARS)%n", cantidad, cantidadConvertida);
                            break;
                        case 2: // Peso Argentino a Dolar
                            cantidadConvertida = cantidad / tasas.get("ARS");
                            System.out.printf("El valor de %.2f Pesos Argentinos (ARS) es equivalente a: %.2f Dólares (USD)%n", cantidad, cantidadConvertida);
                            break;
                        case 3: // Dolar a Real Brasileño
                            cantidadConvertida = cantidad * tasas.get("BRL");
                            System.out.printf("El valor de %.2f Dólares (USD) es equivalente a: %.2f Reales Brasileños (BRL)%n", cantidad, cantidadConvertida);
                            break;
                        case 4: // Real Brasileño a Dolar
                            cantidadConvertida = cantidad / tasas.get("BRL");
                            System.out.printf("El valor de %.2f Reales Brasileños (BRL) es equivalente a: %.2f Dólares (USD)%n", cantidad, cantidadConvertida);
                            break;
                        case 5: // Dolar a Peso Colombiano
                            cantidadConvertida = cantidad * tasas.get("COP");
                            System.out.printf("El valor de %.2f Dólares (USD) es equivalente a: %.2f Pesos Colombianos (COP)%n", cantidad, cantidadConvertida);
                            break;
                        case 6: // Peso Colombiano a Dolar
                            cantidadConvertida = cantidad / tasas.get("COP");
                            System.out.printf("El valor de %.2f Pesos Colombianos (COP) es equivalente a: %.2f Dólares (USD)%n", cantidad, cantidadConvertida);
                            break;

                        case 7:
                            System.out.print("¡La conversión se hará desde Dólares (USD)!, ¿a que moneda quieres convertir?(por ejemplo, EUR, GBP, AUD): ");
                            scanner.nextLine();
                            String moneda = scanner.nextLine().toUpperCase();

                            if (tasas.containsKey(moneda)) {
                                double tasa = tasas.get(moneda);  // Aqui obtengo la tasa de la moneda seleccionada
                                double cantidadAconvertir = cantidad * tasa;
                                System.out.printf("El valor de %.2f Dólares (USD) es equivalente a: %.2f en %s%n", cantidad, cantidadAconvertir, moneda);
                            } else {
                                System.out.println("Moneda no encontrada. Por favor, intente con una moneda válida.");
                            }
                            break;

                        default:
                            System.out.println("Opción no válida. Por favor, intente nuevamente.");
                        }
                }
                else if (opcionUsuario == 8) {
                System.out.println("Gracias por tu visita, hasta luego.");
                }
                else{
                     System.out.println("Por favor elige una opcion valida o marca 8 para salir.");
                }
        }
            scanner.close();
    }
    //Aqui inicializo el programa llamando al main

    public static void main(String[] args) {
        ConversorMoneda conversor = new ConversorMoneda();
        conversor.iniciarConversor();
   }
}