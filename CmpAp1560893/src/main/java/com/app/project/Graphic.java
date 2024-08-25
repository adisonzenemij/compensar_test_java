/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JOptionPane;

/**
 *
 * @author adiso
 */
public class Graphic {
    // Declarar Variables Globales
    
    // Capturar salario
    private static String inputAge;
    // Capturar salario
    private static String inputSalary;
    
    // Capturar nombre completo
    private static String dataFull;
    // Capturar edad
    private static int dataAge;
    // Capturar salario
    private static double dataSalary;
    // Capturar porcentaje
    private static double percent;
    // Capturar incremento
    private static double increase;
    // Obtener nuevo sueldo
    private static double salaries;
    
    public static void procInterface() {
        System.out.println("Funcion Interfaz");
        capture(); // Capturar los datos de entrada
        process(); // Procesar y mostrar el resultado
        message(); // Visualizar mensaje final
    }
    
    // Capturar Datos
    public static void capture() {
        // Validar Datos
        vldFull();
        vldAge();
        vldSalary();
    }
    
    public static void vldFull() {
        // Captura el nombre completo
        cptrFull();

        // Validar que el nombre solo contenga letras
        while (!isValidLetter(dataFull)) {
            mssgLetter();
            cptrFull();
        }
    }
    
    public static void vldAge() {
        // Captura el nombre completo
        cptrAge();

        // Validar que el nombre solo contenga letras
        while (!isValidNumber(inputAge)) {
            mssgNumber();
            cptrAge();
        }
        
        // Reemplazar puntos para conversion
        inputAge = inputAge.replace(".", "");
        // Reemplazar puntos para conversion
        dataAge = Integer.parseInt(inputAge);
    }
    
    public static void vldSalary() {
        // Captura el nombre completo
        cptrSalary();

        // Validar que el nombre solo contenga letras
        while (!isValidNumber(inputSalary)) {
            mssgNumber();
            cptrSalary();
        }
        
        // Reemplazar puntos para conversion
        inputSalary = inputSalary.replace(".", "");
        // Reemplazar puntos para conversion
        dataSalary = Double.parseDouble(inputSalary);
    }
    
    public static void cptrFull() {
        // Captura nombre completo
        dataFull = JOptionPane.showInputDialog(
        null,
        "Nombre Completo",
        "Capturar Datos", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrAge() {
        // Captura nombre completo
        inputAge = JOptionPane.showInputDialog(
null,
        "Edad",
        "Capturar Datos", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrSalary() {
        inputSalary = JOptionPane.showInputDialog(
    null,
        "Salario Actual:",
        "Capturar Datos", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    // Procesar Datos
    public static void process() {
        // 10% de incremento para mayores de 30 años
        if (dataAge > 30) { percent = 10; }
        // 5% de incremento para menores o iguales a 30 años
        if (dataAge <= 30) { percent = 5; }
        // Calcular incremento
        increase = dataSalary * percent;
        // Obtener resultado de incremento
        salaries = dataSalary + increase;
    }
    
    // Imprimir Resultado
    public static void message() {
        // Crear formateador para usar punto como separador de miles
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        // Definir punto como separador de miles
        symbols.setGroupingSeparator('.');
        // Definir coma como separador decimal
        symbols.setDecimalSeparator(',');
        // Formatear resultado final
        DecimalFormat formatter = new DecimalFormat("#,###.##", symbols);

        // Formatear Mensaje Final
        String message = String.format(
            "Persona: %s\n\n" +
            "Edad: %d años\n" +
            "Salario Actual: %s\n" +
            "Incremento Aplicado: %s\n" +
            "Nuevo Salario: %s",
            dataFull,
            dataAge,
            formatter.format(dataSalary),
            formatter.format(increase),
            formatter.format(salaries)
        );

        // Mostrar Mensaje Final
        JOptionPane.showMessageDialog(null, message);
    }

    // Verificar si la entrada contiene solo letras
    private static boolean isValidLetter(String input) {
        // Expresión regular para validar solo letras y espacios
        return input != null && input.matches("[a-zA-Z\\s]+");
    }

    // Verificar si la entrada contiene solo numeros
    private static boolean isValidNumber(String input) {
        // Expresión regular para validar números positivos con opción de punto decimal
        return input != null && input.matches("\\d+(\\.\\d+)?");
    }
    
    public static void mssgLetter() {
        JOptionPane.showMessageDialog(
null,
        "Únicamente se aceptan letras.", // Mensaje de ayuda
        "Entrada Inválida", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgNumber() {
        JOptionPane.showMessageDialog(
null,
        "Únicamente se aceptan números.", // Mensaje de ayuda
        "Entrada Inválida", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
}
