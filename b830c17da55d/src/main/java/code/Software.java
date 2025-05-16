
package code;

import java.util.Scanner;

public class Software {

    static String[][] libros = new String[100][5];
    static int totalLibros = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n=== Sistema Biblioteca ===");
            System.out.println("1. Registrar libro");
            System.out.println("2. Actualizar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Buscar libro");
            System.out.println("5. Ordenar libros");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            // Verificación de entrada segura
            String input = scanner.nextLine();
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida.");
                continue;
            }

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> actualizarLibro();
                case 3 -> eliminarLibro();
                case 4 -> buscarLibro();
                case 5 -> ordenarLibros();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 6);
    }

    static void registrarLibro() {
        if (totalLibros >= libros.length) {
            System.out.println("No se pueden registrar mas libros.");
            return;
        }
        System.out.println("Registro de nuevo libro:");
        System.out.print("Codigo: "); libros[totalLibros][0] = scanner.nextLine();
        System.out.print("Nombre: "); libros[totalLibros][1] = scanner.nextLine();
        System.out.print("Autor: "); libros[totalLibros][2] = scanner.nextLine();
        System.out.print("Materia: "); libros[totalLibros][3] = scanner.nextLine();
        System.out.print("Numero de paginas: "); libros[totalLibros][4] = scanner.nextLine();
        totalLibros++;
        System.out.println("Libro registrado exitosamente.");
    }

    static void actualizarLibro() {
        System.out.print("Ingrese el codigo del libro a actualizar: ");
        String codigo = scanner.nextLine();
        int pos = buscarSecuencial("codigo", codigo);
        if (pos == -1) { librosVacios(); return; }
        System.out.println("Actualizacion de libro:");
        System.out.print("Nuevo nombre: "); libros[pos][1] = scanner.nextLine();
        System.out.print("Nuevo autor: "); libros[pos][2] = scanner.nextLine();
        System.out.print("Nueva materia: "); libros[pos][3] = scanner.nextLine();
        System.out.print("Nuevo numero de paginas: "); libros[pos][4] = scanner.nextLine();
        System.out.println("Libro actualizado.");
    }

    static void eliminarLibro() {
        System.out.print("Ingrese el codigo del libro a eliminar: ");
        String codigo = scanner.nextLine();
        int pos = buscarSecuencial("codigo", codigo);
        if (pos == -1) {
            librosVacios();
            return;
        }
        for (int i = pos; i < totalLibros - 1; i++) {
            libros[i] = libros[i + 1];
        }
        totalLibros--;
        System.out.println("Libro eliminado.");
    }

    static void buscarLibro() {
        System.out.print("Ingrese campo para busqueda (codigo, nombre, autor): ");
        String campo = scanner.nextLine();
        System.out.print("Ingrese valor a buscar: ");
        String valor = scanner.nextLine();
        System.out.print("Tipo de busqueda (1: Secuencial, 2: Binaria): ");
        int tipo = scanner.nextInt(); scanner.nextLine();
        int resultado = (tipo == 2) ? buscarBinaria(campo, valor) : buscarSecuencial(campo, valor);
        if (resultado != -1) { mostrarLibro(resultado); } else { librosVacios(); }
    }

    static void ordenarLibros() {
        System.out.print("Ingrese campo para ordenar (codigo, nombre, autor): ");
        String campo = scanner.nextLine().trim().toLowerCase();

        int metodo = 0;
        do {
            System.out.println("\n=== Metodo de Ordenamiento ===");
            System.out.println("1. Burbuja");
            System.out.println("2. Seleccion");
            System.out.print("Seleccione una opcion: ");

            String input = scanner.nextLine();
            try {
                metodo = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida.");
                continue;
            }

            switch (metodo) {
                case 1 -> ordenarBurbuja(campo);
                case 2 -> ordenarSeleccion(campo);
                default -> {
                    System.out.println("Opción invalida. Intente de nuevo.");
                    metodo = 0; // Reinicia para repetir el ciclo
                }
            }
        } while (metodo < 1 || metodo > 2);

        System.out.println("Libros ordenados por " + campo + ".");
        librosOrdenados();
    }


    static int obtenerIndiceCampo(String campo) {
        return switch (campo.toLowerCase()) {
            case "codigo" -> 0;
            case "nombre" -> 1;
            case "autor" -> 2;
            case "materia" -> 3;
            case "paginas", "numero de paginas" -> 4;
            default -> -1;
        };
    }

    static int buscarSecuencial(String campo, String valor) {
        int idx = obtenerIndiceCampo(campo);
        if (idx == -1) return -1;
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i][idx].equalsIgnoreCase(valor)) return i;
        }
        return -1;
    }

    static int buscarBinaria(String campo, String valor) {
        int idx = obtenerIndiceCampo(campo);
        if (idx == -1) return -1;
        ordenarBurbuja(campo); // ordenar antes de buscar binaria
        int izq = 0, der = totalLibros - 1;
        while (izq <= der) {
            int mid = (izq + der) / 2;
            int cmp = libros[mid][idx].compareToIgnoreCase(valor);
            if (cmp == 0) return mid;
            if (cmp < 0) izq = mid + 1;
            else der = mid - 1;
        }
        return -1;
    }

    static void ordenarBurbuja(String campo) {
        int idx = obtenerIndiceCampo(campo);
        for (int i = 0; i < totalLibros - 1; i++) {
            for (int j = 0; j < totalLibros - i - 1; j++) {
                if (libros[j][idx].compareToIgnoreCase(libros[j + 1][idx]) > 0) {
                    String[] temp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temp;
                }
            }
        }
    }

    static void ordenarSeleccion(String campo) {
        int idx = obtenerIndiceCampo(campo);
        for (int i = 0; i < totalLibros - 1; i++) {
            int min = i;
            for (int j = i + 1; j < totalLibros; j++) {
                if (libros[j][idx].compareToIgnoreCase(libros[min][idx]) < 0) {
                    min = j;
                }
            }
            String[] temp = libros[i];
            libros[i] = libros[min];
            libros[min] = temp;
        }
    }

    static void mostrarLibro(int i) {
        System.out.println("\n--- Detalles del Libro ---");
        System.out.println("Codigo: " + libros[i][0]);
        System.out.println("Nombre: " + libros[i][1]);
        System.out.println("Autor: " + libros[i][2]);
        System.out.println("Materia: " + libros[i][3]);
        System.out.println("Paginas: " + libros[i][4]);
    }

    static void librosOrdenados() {
        if (totalLibros == 0) {
            System.out.println("No hay libros registrados.");
            return;
        }
        System.out.println("\n--- Lista de Libros ---");
        for (int i = 0; i < totalLibros; i++) {
            System.out.println(
                (i + 1) +
                ". Codigo: " + libros[i][0] +
                " | Nombre: " + libros[i][1] +
                " | Autor: " + libros[i][2] +
                " | Materia: " + libros[i][3] +
                " | Paginas: " + libros[i][4]
            );
        }
    }

    static void librosVacios() {
        System.out.println(
            "Libro no encontrado."
        );
    }
}
