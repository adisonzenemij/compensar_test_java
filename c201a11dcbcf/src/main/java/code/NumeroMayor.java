/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author adiso
 */
public class NumeroMayor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo a leer: ");
        String nombreArchivo = sc.nextLine();

        try (Scanner fileScanner = new Scanner(new File(nombreArchivo))) {
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
