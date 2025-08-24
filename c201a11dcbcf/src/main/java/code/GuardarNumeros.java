/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author adiso
 */
public class GuardarNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo donde guardara los numeros: ");
        String nombreArchivo = sc.nextLine();

        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            System.out.println("Ingrese numeros (escriba 'terminar' o 'finalizar' para salir):");

            while (true) {
                String entrada = sc.nextLine().trim();

                // Palabras clave para salir
                if (entrada.equalsIgnoreCase("terminar") ||
                    entrada.equalsIgnoreCase("finalizar")
                ) {
                    break;
                }

                try {
                    int num = Integer.parseInt(entrada); // intentar convertir a numero
                    pw.println(num);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida, ingrese un numero o 'terminar'.");
                }
            }

            System.out.println("Numeros guardados correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
