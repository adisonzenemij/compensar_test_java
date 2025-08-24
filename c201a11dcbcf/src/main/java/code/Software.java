
package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Software {

    public static void main(String[] args) {
        // Crear archivo message.dat al iniciar
        crearArchivoMessage();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            // Imprimir menu y ocpiones para el usuario
            System.out.println("\nMenu De Opciones");
            System.out.println("1. Copiar archivo (message.dat -> new.dat)");
            System.out.println("2. Abrir y mostrar archivo");
            System.out.println("3. Ingresar numeros y guardarlos en archivo");
            System.out.println("4. Leer archivo y mostrar numero mayor");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada invalida.");
                sc.nextLine(); 
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> CopiarArchivo.main(null);
                case 2 -> LeerArchivo.main(null);
                case 3 -> GuardarNumeros.main(null);
                case 4 -> NumeroMayor.main(null);
                case 0 -> System.out.println("Programa Finalizado");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    /**
     * Crea el archivo message.dat en la carpeta target del proyecto.
     * En caso de existir el archivo borrar y volver a generar el archivo con contenido.
     */
    private static void crearArchivoMessage() {
        // Ruta de la carpeta target del proyecto
        String basePath = System.getProperty("user.dir") + File.separator + "target";
        File carpetaTarget = new File(basePath);

        // Nos aseguramos que la carpeta exista
        if (!carpetaTarget.exists()) {
            carpetaTarget.mkdirs();
        }

        // Archivoq que se almacenará en la carpeta target
        File archivo = new File(carpetaTarget, "message.dat");

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
