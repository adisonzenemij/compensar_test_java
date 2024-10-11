/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.app.project;

import java.util.Scanner;

/**
 *
 * @author adiso
 */
public class Software {
    
    private static Scanner sc = new Scanner(System.in);

    private static int cntStudent;
    private static String[] stNames;
    private static double[] stNote;
    
    public static void main(String[] args) {
        do {
            System.out.print("Ingrese el número de estudiantes: ");
            cntStudent = sc.nextInt();
            
            if (cntStudent < 1 || cntStudent > 5) {
                System.out.println("Error: El número de estudiantes debe ser minimo 1 o maximo 5");
            }
            
        } while (cntStudent < 1 || cntStudent > 5);
        sc.nextLine();
        
        cptData();
        cptNote();
        printData();
    }
    
    public static void cptData() {
        stNames = new String[cntStudent];
        
        for (int i = 0; i < cntStudent; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            stNames[i] = sc.nextLine();
        }
    }
    
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
    
    public static double average() {
        double sum = 0;
        for (int i = 0; i < cntStudent; i++) {
            sum += stNote[i];
        }
        return sum / cntStudent;
    }
    
}
