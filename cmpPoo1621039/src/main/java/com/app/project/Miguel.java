/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import java.util.Scanner;

/**
 *
 * @author adiso
 */
public class Miguel {
    // Función que solicita el nombre y la nota de cada estudiante
    public static void ingresarDatos(String[] nombres, double[] notas, int cantidadEstudiantes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre y la nota de cada estudiante:");
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.print("Nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
            
            boolean notaValida = false;
            while (!notaValida) {
                System.out.print("Nota del estudiante " + (i + 1) + " (entre 1.0 y 10.0): ");
                double nota = scanner.nextDouble();
                scanner.nextLine(); 

                if (nota >= 1.0 && nota <= 10.0) {
                    notas[i] = nota;
                    notaValida = true;
                } else {
                    System.out.println("Error: La nota debe estar entre 1.0 y 10.0.");
                }
            }
        }
    }

     public static double calcPromedio(double[] notas) {
        //System.out.println("Notas:" + notas);
        double suma = 0;
        for (double nota : notas) {
            System.out.println("Notas:" + nota);
            suma += nota;
        }
        return suma / notas.length;
    }

    public static void EstudiantesbajoPromedio(String[] nombres, double[] notas, double promedio) {
        System.out.println("\nPromedio del curso: " + promedio);
        System.out.println("Estudiantes con notas por debajo del promedio:");
        boolean hayEstudiantesPorDebajo = false;

        for (int i = 0; i < nombres.length; i++) {
            if (notas[i] < promedio) {
                System.out.println(nombres[i] + " - Nota: " + notas[i]);
                hayEstudiantesPorDebajo = true;
            }
        }

        if (!hayEstudiantesPorDebajo) {
            System.out.println("No hay estudiantes con notas por debajo del promedio.");
        }
    }

    public static void principal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de estudiantes: ");
        int numEstudiantes = scanner.nextInt();
        scanner.nextLine(); 

        if (numEstudiantes > 0) {
            String[] nombres = new String[numEstudiantes];
            double[] notas = new double[numEstudiantes];

            ingresarDatos(nombres, notas, numEstudiantes);

            double promedio = calcPromedio(notas);
            EstudiantesbajoPromedio(nombres, notas, promedio);
        } else {
            System.out.println("Error: El número de estudiantes debe ser mayor que 0.");
        }
    }
}
