/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import static com.app.project.Validation.isCountMin;
import static com.app.project.Validation.isValidLetter;
import static com.app.project.Validation.isValidNumber;
import javax.swing.JOptionPane;

/**
 *
 * @author adiso
 */
public class Interface {
    // Capturar Visitantes
    private static String inputVisitor;
    // Capturar Documento
    private static String inputDoc;
    // Capturar Edad
    private static String inputAge;
    
    // Capturar Visitante
    private static int dataVisitor;
    // Capturar Documento
    private static int dataDoc;
    // Capturar Nombre Completo
    private static String dataFull;
    // Capturar Edad
    private static int dataAge;
    // Capturar Categoria
    private static double dataCategory;
    
    // Capturar Valor
    private static int dataValue;
    
    public static void procInterface() {
        System.out.println("Application Interfaz");
        capture(); // Capturar los datos de entrada
        //process(); // Procesar y mostrar el resultado
        //message(); // Visualizar mensaje final
    }
    
    // Capturar Datos
    public static void capture() {
        // Validar Datos
        vldVisitor();
        vldDoc();
        vldFull();
        vldAge();
    }
    
    public static void vldVisitor() {
        // Captura el nombre completo
        cptrVisitor();

        // Repetir hasta que el valor sea válido (número mayor a 0)
        while (true) {
            // Validar que el input sea un número válido
            if (!isValidNumber(inputVisitor)) {
                mssgNumber();
                cptrVisitor();
                continue;  // Volver al inicio del ciclo si no es un número
            }

            // Validar que el número sea mayor a cero
            if (!isCountMin(inputVisitor)) {
                mssgCountMin();
                cptrVisitor();
                continue;  // Volver al inicio del ciclo si el número no es mayor a 0
            }

            // Si pasa ambas validaciones, salir del ciclo
            break;
        }
        
        // Reemplazar puntos para conversion
        inputVisitor = inputVisitor.replace(".", "");
        // Reemplazar puntos para conversion
        dataVisitor = Integer.parseInt(inputVisitor);
    }
    
    public static void vldDoc() {
        // Captura el nombre completo
        cptrDoc();

        // Validar que el nombre solo contenga letras
        while (!isValidNumber(inputDoc)) {
            mssgNumber();
            cptrDoc();
        }
        
        // Reemplazar puntos para conversion
        inputDoc = inputDoc.replace(".", "");
        // Reemplazar puntos para conversion
        dataDoc = Integer.parseInt(inputDoc);
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
    
    public static void cptrVisitor() {
        // Captura Datos
        inputVisitor = JOptionPane.showInputDialog(
null,
        "Cantidad Visitantes",
        "Capturar Datos", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrDoc() {
        // Captura Datos
        inputDoc = JOptionPane.showInputDialog(
null,
        "Documento",
        "Capturar Datos", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrFull() {
        // Captura Datos
        dataFull = JOptionPane.showInputDialog(
        null,
        "Nombre Completo",
        "Capturar Datos", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrAge() {
        // Captura Datos
        inputAge = JOptionPane.showInputDialog(
null,
        "Edad",
        "Capturar Datos", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgCountMin() {
        JOptionPane.showMessageDialog(
null,
        "Únicamente se aceptan valores mayor a cero.", // Mensaje de ayuda
        "Entrada Inválida", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
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
