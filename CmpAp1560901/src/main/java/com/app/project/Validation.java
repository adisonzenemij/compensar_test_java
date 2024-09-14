/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

/**
 *
 * @author adiso
 */
public class Validation {
    // Verificar si el número es mayor que 0
    public static boolean isCountMin(String input) {
        // Expresión regular para validar solo letras y espacios
        return Integer.parseInt(input) > 0;
    }

    // Verificar si la entrada contiene solo letras
    public static boolean isValidLetter(String input) {
        // Expresión regular para validar solo letras y espacios
        return input != null && input.matches("[a-zA-Z\\s]+");
    }

    // Verificar si la entrada contiene solo numeros
    public static boolean isValidNumber(String input) {
        // Expresión regular para validar números positivos con opción de punto decimal
        return input != null && input.matches("\\d+(\\.\\d+)?");
    }
}
