
package code;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NumeroMayor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo a leer: ");
        String nombreArchivo = sc.nextLine();

        // Siempre busca dentro de target/
        String rutaArchivo = "target/" + nombreArchivo;

        try (Scanner fileScanner = new Scanner(new File(rutaArchivo))) {
            int mayor = Integer.MIN_VALUE;
            System.out.print("La lista es: ");
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                System.out.print(num + " ");
                if (num > mayor) {
                    mayor = num;
                }
            }
            System.out.println("\nEl numero mas grande de la lista es: " + mayor);
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}
