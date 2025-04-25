
package code;

import java.util.Scanner;

public class Software {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int cantidadFamilias = pedirCantidadFamilias();

        double[] agua = new double[cantidadFamilias];
        double[] luz = new double[cantidadFamilias];
        double[] gas = new double[cantidadFamilias];
        int[] estratos = new int[cantidadFamilias];

        recolectarDatos(cantidadFamilias, agua, luz, gas, estratos);
        aplicarDescuentos(cantidadFamilias, agua, luz, gas, estratos);
        mostrarTotales(cantidadFamilias, agua, luz, gas);
    }

    public static int pedirCantidadFamilias() {
        System.out.print("Ingrese la cantidad de familias: ");
        return scanner.nextInt();
    }

    public static void recolectarDatos(
        int cantidad,
        double[] agua,
        double[] luz,
        double[] gas,
        int[] estratos
    ) {
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nFamilia #" + (i + 1));
            System.out.print("Ingrese el valor del servicio de agua: ");
            agua[i] = scanner.nextDouble();

            System.out.print("Ingrese el valor del servicio de luz: ");
            luz[i] = scanner.nextDouble();

            System.out.print("Ingrese el valor del servicio de gas: ");
            gas[i] = scanner.nextDouble();

            System.out.print("Ingrese el estrato (1, 2 o 3+): ");
            estratos[i] = scanner.nextInt();
        }
    }

    public static void aplicarDescuentos(
        int cantidad,
        double[] agua,
        double[] luz,
        double[] gas,
        int[] estratos
    ) {
        for (int i = 0; i < cantidad; i++) {
            double descuento = obtenerDescuentoPorEstrato(estratos[i]);
            agua[i] -= agua[i] * descuento;
            luz[i] -= luz[i] * descuento;
            gas[i] -= gas[i] * descuento;
        }
    }

    public static double obtenerDescuentoPorEstrato(int estrato) {
        return switch (estrato) {
            case 1 -> 0.20;
            case 2 -> 0.15;
            default -> 0.09;
        };
    }

    public static void mostrarTotales(
        int cantidad,
        double[] agua,
        double[] luz,
        double[] gas
    ) {
        double totalAgua = 0;
        double totalLuz = 0;
        double totalGas = 0;

        for (int i = 0; i < cantidad; i++) {
            totalAgua += agua[i];
            totalLuz += luz[i];
            totalGas += gas[i];
        }

        System.out.println("\nResumen Total a Pagar:");
        System.out.printf("Total Agua: $%.2f\n", totalAgua);
        System.out.printf("Total Luz: $%.2f\n", totalLuz);
        System.out.printf("Total Gas: $%.2f\n", totalGas);
    }
}
