/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author adiso
 */
public class Software {

    public static void main(String[] args) {
        // Crear archivo message.dat al iniciar
        crearArchivoMessage();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENU DE OPCIONES ===");
            System.out.println("1. Copiar archivo (message.dat -> new.dat)");
            System.out.println("2. Abrir y mostrar archivo");
            System.out.println("3. Ingresar numeros y guardarlos en archivo");
            System.out.println("4. Leer archivo y mostrar numero mayor");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    CopiarArchivo.main(null);
                    break;
                case 2:
                    LeerArchivo.main(null);
                    break;
                case 3:
                    GuardarNumeros.main(null);
                    break;
                case 4:
                    NumeroMayor.main(null);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    /**
     * Crea el archivo message.dat en la carpeta de ejecución.
     * Si ya existe, lo borra y lo vuelve a generar con contenido de ejemplo.
     */
    private static void crearArchivoMessage() {
        String basePath = System.getProperty("user.dir");
        File archivo = new File(basePath, "message.dat");

        if (archivo.exists()) { archivo.delete(); }

        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write("When an apple fell, Newton was disturbed\n");
            fw.write("but when he found that all apples fell\n");
            fw.write("it was gravitation and he was satisfied\n");
            System.out.println("Archivo message.dat generado en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al crear message.dat: " + e.getMessage());
        }
    }
}
