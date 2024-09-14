/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.app.project;

import java.util.Scanner;
import static com.app.project.Interface.procInterface;
import static com.app.project.Scanner.procScanner;
import static com.app.project.Validation.isValidLetter;

/**
 *
 * @author adiso
 */
public class Software {
    
    public static void main(String[] args) {
        System.out.println("Application Software\n");
        application();
    }
    
    public static void application() {
        System.out.println("Interfaz | Scanner | Finalizar");
        Scanner scanner = new Scanner(System.in);
        String appMethod = null;
        
        // Ciclo para capturar un valor válido
        while (!isValidLetter(appMethod)) {
            System.out.println("Seleccionar Aplicacion:");
            // Capturar Entada Usuario
            appMethod = scanner.nextLine();
            if (!isValidLetter(appMethod)) {
                // Visualizar Entrada Invalida
                appLetter();
            }
            System.out.print("\n");
        }
        
        switch(appMethod) {
            case "Interfaz" -> procInterface();
            case "Scanner" -> procScanner();
            case "Finalizar" -> {
                System.out.println("App Finalizada");
                // Finalizar Ejecucion Progama
                System.exit(0);
            }
            default -> {
                System.out.println("Opcion Invalida");
                System.out.print("\n");
                application();
            }
        }
    }
    
    public static void appLetter() {
        String message = "Únicamente se aceptan letras.";
        System.out.println(message);
    }
}
