/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.app.project;

import static com.app.project.Graphic.procInterface;

/**
 *
 * @author adiso
 */
public class Software {

    public static void main(String[] args) {
        // Funcion Suma
        procSuma();
        // Funcion Resultado
        procNumber();
        // Funcion Interfaz
        procInterface();
    }
    
    public static void procSuma() {
        System.out.println("Funcion Suma");
        // Declarar Variables
        int value;
        // Asignar Valores
        value = 2;
        // Ejecutar Funcion
        int resultado = execSuma(value);
        // Imprimir resultado
        System.out.println("Parametro: " + value);
        System.out.println("Resultado: " + resultado);
        System.out.println("\n");
    }
    
    public static int execSuma(int n) {
        int res = 0;
        if (n > 0) {
            res = execSuma(n - 1);
            if (n % 2 == 0) {
                res = res + n;
            }
        }
        return res;
    }
    
    public static void procNumber() {
        System.out.println("Funcion Numero");
        // Declarar Variables
        int value;
        // Asignar Valores
        value = 2;
        // Ejecutar Funcion
        int resultado = execNumber(value);
        // Imprimir resultado
        System.out.println("Parametro: " + value);
        System.out.println("Resultado: " + resultado);
        System.out.println("\n");
    }
    
    public static int execNumber(int n) {
        int res = 0;
        if (n > 0) {
            res = execNumber(n - 1);
            res = res + (n * 2);
        }
        return res;
    }
}
