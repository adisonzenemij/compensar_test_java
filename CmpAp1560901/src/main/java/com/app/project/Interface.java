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
    // Capturar Visitante
    private static int dataVisitor;
    private static double valueBase;
    private static String[] valueCtgr;
    
    // Capturar Datos Entrantes
    private static String inputVisitor;
    private static String inputDoc;
    private static String inputFull;
    private static String inputAge;
    private static String inputAfltn;
    private static String inputCtgr;
    private static String inputPrice;
    
    // Capturar Información Visitantes
    private static String[] visitorNames;
    private static int[] visitorDocs;
    private static int[] visitorAges;
    private static String[] visitorAfltn;
    private static String[] visitorCtgr;
    private static int[] visitorPrice;
    
    public static void procInterface() {
        System.out.println("Application Interfaz");
        valueBase = 30000; // Valor Base Museo
        valueCtgr = new String[]{"", "A", "B", "C"};
        capture(); // Capturar los datos de entrada
        //process(); // Procesar y mostrar el resultado
        message(); // Visualizar mensaje final
    }
    
    // Capturar Datos
    public static void capture() {
        // Validar Datos
        vldVisitor();
        if (dataVisitor > 0) {
            // Inicializar Arreglos Almacenamiento
            visitorNames = new String[dataVisitor];
            visitorDocs = new int[dataVisitor];
            visitorAges = new int[dataVisitor];
            visitorAfltn = new String[dataVisitor];
            visitorCtgr = new String[dataVisitor];
            visitorPrice = new int[dataVisitor];
            // Capturar Información Visitantes
            for (int i = 0; i < dataVisitor; i++) {                
                visitorDocs[i] = vldDoc();
                visitorNames[i] = vldFull();
                visitorAges[i] = vldAge();
                visitorAfltn[i] = vldAfltn();
                visitorCtgr[i] = vldCtgr();
                /*if (visitorAges[i] < 18) {
                    visitorPrice[i] = 5000;
                }
                if (visitorAges[i] >= 18) {
                    if (visitorAfltn[i] === "No") {
                        visitorPrice[i] = 30000;
                    }
                    if (visitorAfltn[i] === "Si") {
                    }
                }*/
            }
        }
    }
    
    public static void data() {
        double price = 0;
        if (vldAge() < 18) {
            price = 5000;
        }
        if (vldAge() >= 18) {
            price = 30000;
        }
    }
    
    public static void message() {
        System.out.println("\nInformación Visitantes:");
        for (int i = 0; i < dataVisitor; i++) {
            System.out.println("Visitante " + (i + 1) + ":");
            System.out.println("Nombre Completo: " + visitorNames[i]);
            System.out.println("Documento: " + visitorDocs[i]);
            System.out.println("Edad: " + visitorAges[i]);
            System.out.println("Afiliado: " + visitorAfltn[i]);
            System.out.println("Categoria: " + visitorCtgr[i]);
            System.out.println();
        }
    }
    
    public static void vldVisitor() {
        cptrVisitor();

        // Repetir hasta que el valor sea válido (número mayor a 0)
        while (true) {
            // Validar que el input sea un número válido
            if (!isValidNumber(inputVisitor)) {
                mssgNumber();
                cptrVisitor();
                continue; // Volver al inicio del ciclo si no es un número
            }

            // Validar que el número sea mayor a cero
            if (!isCountMin(inputVisitor)) {
                mssgCountMin();
                cptrVisitor();
                continue; // Volver al inicio del ciclo si el número no es mayor a 0
            }

            // Si pasa ambas validaciones, salir del ciclo
            break;
        }
        
        // Reemplazar puntos para conversion
        inputVisitor = inputVisitor.replace(".", "");
        // Reemplazar puntos para conversion
        dataVisitor = Integer.parseInt(inputVisitor);
    }
    
    public static int vldDoc() {
        cptrDoc();

        // Validar que el nombre solo contenga letras
        while (!isValidNumber(inputDoc)) {
            mssgNumber();
            cptrDoc();
        }
        
        // Reemplazar puntos para conversion
        inputDoc = inputDoc.replace(".", "");
        // Reemplazar puntos para conversion
        return Integer.parseInt(inputDoc);
    }
    
    public static String vldFull() {
        cptrFull();

        // Validar que el nombre solo contenga letras
        while (!isValidLetter(inputFull)) {
            mssgLetter();
            cptrFull();
        }
        // Asignar informacion correcta
        return inputFull;
    }
    
    public static int vldAge() {
        cptrAge();

        // Validar que el nombre solo contenga letras
        while (!isValidNumber(inputAge)) {
            mssgNumber();
            cptrAge();
        }
        
        // Reemplazar puntos para conversion
        inputAge = inputAge.replace(".", "");
        // Reemplazar puntos para conversion
        return Integer.parseInt(inputAge);
    }
    
    public static String vldAfltn() {
        boolean result = cptrAfltn();
        if (result) { inputAfltn = "Si"; }
        if (!result) { inputAfltn = "No"; }
        return inputAfltn;
    }
    
    public static String vldCtgr() {
        if ("No".equals(inputAfltn)) {
            inputCtgr = "";
        }
        if ("Si".equals(inputAfltn)) {
            inputCtgr = cptrCtgr();
            if ("".equals(inputCtgr)) {
                mssgEmpty();
                vldCtgr();
            } 
        }
        return inputCtgr;
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
        inputFull = JOptionPane.showInputDialog(
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
    
    public static boolean cptrAfltn() {
        // Captura Datos
        int response = JOptionPane.showConfirmDialog(
            null,
            "Afiliado",
            "Capturar Datos",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        // JOptionPane.YES_OPTION = 0, JOptionPane.NO_OPTION = 1
        return response == JOptionPane.YES_OPTION;
    }
    
    public static String cptrCtgr() {
        // Captura Datos
        String response = (String) JOptionPane.showInputDialog(
            null,
            "Selecciona una opción:",
            "Seleccionar Categoría",
            JOptionPane.QUESTION_MESSAGE,
            null,
            valueCtgr,
            valueCtgr[0] // Valor por defecto seleccionado
        );
        return response;
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
    
    public static void mssgEmpty() {
        JOptionPane.showMessageDialog(
null,
        "Únicamente se aceptan valores seleccionables.", // Mensaje de ayuda
        "Entrada Inválida", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
}
