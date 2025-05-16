
package code;

import java.util.Scanner;

public class Software {

    /*public static void main(String[] args) {
        System.out.println("Hello World!");
    }*/

    static String[][] libros = new String[100][5];
    static int totalLibros = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Sistema Biblioteca ===");
            System.out.println("1. Registrar libro");
            System.out.println("2. Actualizar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Buscar libro");
            System.out.println("5. Ordenar libros");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1: registrarLibro(); break;
                case 2: actualizarLibro(); break;
                case 3: eliminarLibro(); break;
                case 4: buscarLibro(); break;
                case 5: ordenarLibros(); break;
                case 6: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

    static void registrarLibro() {
        if (totalLibros >= libros.length) {
            System.out.println("No se pueden registrar más libros.");
            return;
        }
        System.out.println("Registro de nuevo libro:");
        System.out.print("Código: "); libros[totalLibros][0] = scanner.nextLine();
        System.out.print("Nombre: "); libros[totalLibros][1] = scanner.nextLine();
        System.out.print("Autor: "); libros[totalLibros][2] = scanner.nextLine();
        System.out.print("Materia: "); libros[totalLibros][3] = scanner.nextLine();
        System.out.print("Número de páginas: "); libros[totalLibros][4] = scanner.nextLine();
        totalLibros++;
        System.out.println("Libro registrado exitosamente.");
    }

    static void actualizarLibro() {
        System.out.print("Ingrese el código del libro a actualizar: ");
        String codigo = scanner.nextLine();
        int pos = buscarSecuencial("código", codigo);
        if (pos == -1) {
            System.out.println("Libro no encontrado.");
            return;
        }
        System.out.println("Actualización de libro:");
        System.out.print("Nuevo nombre: "); libros[pos][1] = scanner.nextLine();
        System.out.print("Nuevo autor: "); libros[pos][2] = scanner.nextLine();
        System.out.print("Nueva materia: "); libros[pos][3] = scanner.nextLine();
        System.out.print("Nuevo número de páginas: "); libros[pos][4] = scanner.nextLine();
        System.out.println("Libro actualizado.");
    }

    static void eliminarLibro() {
        System.out.print("Ingrese el código del libro a eliminar: ");
        String codigo = scanner.nextLine();
        int pos = buscarSecuencial("código", codigo);
        if (pos == -1) {
            System.out.println("Libro no encontrado.");
            return;
        }
        for (int i = pos; i < totalLibros - 1; i++) {
            libros[i] = libros[i + 1];
        }
        totalLibros--;
        System.out.println("Libro eliminado.");
    }

    static void buscarLibro() {
        System.out.print("Ingrese campo para búsqueda (código, nombre, autor): ");
        String campo = scanner.nextLine();
        System.out.print("Ingrese valor a buscar: ");
        String valor = scanner.nextLine();
        System.out.print("Tipo de búsqueda (1: Secuencial, 2: Binaria): ");
        int tipo = scanner.nextInt(); scanner.nextLine();
        int resultado = (tipo == 2) ? buscarBinaria(campo, valor) : buscarSecuencial(campo, valor);

        if (resultado != -1) {
            mostrarLibro(resultado);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    static void ordenarLibros() {
        System.out.print("Ingrese campo para ordenar (código, nombre, autor): ");
        String campo = scanner.nextLine();
        System.out.print("Método de ordenamiento (1: Burbuja, 2: Selección): ");
        int metodo = scanner.nextInt(); scanner.nextLine();
        if (metodo == 1) {
            ordenarBurbuja(campo);
        } else {
            ordenarSeleccion(campo);
        }
        System.out.println("Libros ordenados por " + campo + ".");
        librosOrdenados();
    }

    // ==== Métodos auxiliares ====

    static int obtenerIndiceCampo(String campo) {
        return switch (campo.toLowerCase()) {
            case "código" -> 0;
            case "nombre" -> 1;
            case "autor" -> 2;
            case "materia" -> 3;
            case "páginas", "numero de paginas" -> 4;
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
        System.out.println("Código: " + libros[i][0]);
        System.out.println("Nombre: " + libros[i][1]);
        System.out.println("Autor: " + libros[i][2]);
        System.out.println("Materia: " + libros[i][3]);
        System.out.println("Páginas: " + libros[i][4]);
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
                ". Código: " + libros[i][0] +
                " | Nombre: " + libros[i][1] +
                " | Autor: " + libros[i][2] +
                " | Materia: " + libros[i][3] +
                " | Páginas: " + libros[i][4]
            );
        }
    }

}
