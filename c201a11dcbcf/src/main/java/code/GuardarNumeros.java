
package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GuardarNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = sc.nextLine().trim();

        // Definir carpeta target dentro del proyecto
        String rutaCarpeta = "target";
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs(); // crea la carpeta si no existe
        }

        // Construir la ruta completa
        String rutaCompleta = rutaCarpeta + File.separator + nombreArchivo;

        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaCompleta))) {
            System.out.println("Ingrese numeros (escriba 'terminar' o 'finalizar' para salir):");

            while (true) {
                String entrada = sc.nextLine().trim();

                if (entrada.equalsIgnoreCase("terminar") ||
                    entrada.equalsIgnoreCase("finalizar")) {
                    break;
                }

                try {
                    int num = Integer.parseInt(entrada);
                    pw.println(num);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida, ingrese un numero o 'terminar'.");
                }
            }

            System.out.println("Numeros guardados correctamente en " + rutaCompleta);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
