package com.app.project;

import java.util.Scanner;

public class Software {
    // Utilizacion del scanner global en el codigo
    private static Scanner sc = new Scanner(System.in);
    // Incializacion de variables globales
    private static int cntStudent;
    private static String[] stNames;
    private static double[] stNote;
    
    /* Funcion principal para validar si el usuario digita la cantidad de estudiantes correctos */
    public static void main(String[] args) {
        do {
            System.out.print("Ingrese el número de estudiantes: ");
            cntStudent = sc.nextInt();
            
            if (cntStudent < 1 || cntStudent > 5) {
                System.out.println("Error: El número de estudiantes debe ser minimo 1 o maximo 5");
            }
            
        } while (cntStudent < 1 || cntStudent > 5);
        sc.nextLine();
        // Llamar funciones para capturar los estudiates y sus notas
        cptData();
        cptNote();
        // Imprimir el resultado final del promedio y estudiantes por debajo del promedio
        printData();
    }
    
    /* Funcion para capturar los datos de los estudiantes segun la cantidad de estudiantes */
    public static void cptData() {
        stNames = new String[cntStudent];
        
        for (int i = 0; i < cntStudent; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            stNames[i] = sc.nextLine();
        }
    }
    
    // Funcion para capturar las notas de los estudiantes segun la cantidad de estudiantes
    // Adicional se añade validacion para saber si la nota del estudiante está en el rango de 1 y 10
    public static void cptNote() {
        stNote = new double[cntStudent];
        
        for (int i = 0; i < cntStudent; i++) {
            
            do {
                System.out.print("Ingrese la nota del estudiante " + (i + 1) + ": ");
                stNote[i] = sc.nextDouble();

                if (stNote[i] < 1.0 || stNote[i] > 10.0) {
                    System.out.println("Error: La nota debe ser minimo 1.00 o maximo 10.0");
                }

            } while (stNote[i] < 1.0 || stNote[i] > 10.0);
        }
    }
    
    // Funcion para imprimir el promedio de la nota calculada
    // Imprimir estudiantes que esten por debajo del promedio
    public static void printData() {
        double avrg = average();
        System.out.println("Promedio del curso: " + avrg);
        
        System.out.println("Estudiantes con notas debajo del promedio");
        for (int i = 0; i < cntStudent; i++) {
            if (stNote[i] < avrg) {
                System.out.println(
                    "Estudiante: " + (i + 1) + ": " +
                    stNames[i] + " " +
                    "Nota: " + stNote[i] + " "
                );
            }
        }
    }
    
    // Funcion para calcular el promedio segun la cantidad de estudiantes y sus notas
    public static double average() {
        double sum = 0;
        for (int i = 0; i < cntStudent; i++) {
            sum += stNote[i];
        }
        return sum / cntStudent;
    }
}
