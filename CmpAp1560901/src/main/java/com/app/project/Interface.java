/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static com.app.project.DateFormat.getDateTime;
import static com.app.project.Validation.isCountMin;
import static com.app.project.Validation.isValidLetter;
import static com.app.project.Validation.isValidNumber;
import java.awt.Dimension;

/**
 *
 * @author adiso
 */
public class Interface {
    // Variables Adicionales
    private static String dateTimeStamp;

    // Capturar Visitante
    private static int dataVisitor;
    private static double valueBase;
    private static String[] valueCtgr;
    private static double totalPrice;
    private static int countUnder;
    private static int countOver;
    
    // Capturar Datos Entrantes
    private static String inputVisitor;
    private static String inputDoc;
    private static String inputNames;
    private static String inputSurns;
    private static String inputAge;
    private static String inputAfltn;
    private static String inputCtgr;
    
    // Capturar Información Visitantes
    private static int[] visitorDocs;
    private static String[] visitorNames;
    private static String[] visitorSurns;
    private static int[] visitorAges;
    private static String[] visitorAfltn;
    private static String[] visitorCtgr;
    private static double[] visitorPrice;
    
    public static void procInterface() {
        System.out.println("Application Interfaz");

        dateTimeStamp = getDateTime();
        valueBase = 30000; // Valor Base Museo
        valueCtgr = new String[]{"", "A", "B", "C"};

        capture(); // Capturar Datos Entrantes
        process(); // Procesar Informacion
        message(); // Visualizar Informacion
        //saveFile(); // Exportar Informacion
    }
    
    // Capturar Datos
    public static void capture() {
        // Validar Datos
        vldVisitor();
        if (dataVisitor > 0) {
            // Inicializar Arreglos Almacenamiento
            visitorDocs = new int[dataVisitor];
            visitorNames = new String[dataVisitor];
            visitorSurns = new String[dataVisitor];
            visitorAges = new int[dataVisitor];
            visitorAfltn = new String[dataVisitor];
            visitorCtgr = new String[dataVisitor];
            visitorPrice = new double[dataVisitor];
            // Capturar Información Visitantes
            for (int i = 0; i < dataVisitor; i++) {                
                visitorDocs[i] = vldDoc();
                visitorNames[i] = vldNames();
                visitorSurns[i] = vldSurns();
                visitorAges[i] = vldAge();
                visitorAfltn[i] = vldAfltn();
                visitorCtgr[i] = vldCtgr();
                visitorPrice[i] = vldPrice(
                    visitorAges[i],
                    visitorAfltn[i],
                    visitorCtgr[i]
                );
            }
        }
    }
    
    public static void process() {
        System.out.println("\nInformación Visitantes:");
        totalPrice = 0;
        for (int i = 0; i < dataVisitor; i++) {
            // Acumular Precio Unitario
            totalPrice += visitorPrice[i];
            // Contar Edades Visitantes
            if (visitorAges[i] < 18) { countUnder++; }
            if (visitorAges[i] >= 18) { countOver++; }
        }
        // Imprimir Precio Total
        System.out.printf("Precio Total: %.2f%n", totalPrice);
        System.out.printf("Menores de Edad: %d%n", countUnder);
        System.out.printf("Mayores de Edad: %df%n", countOver);
    }
    
    // Imprimir Resultado
    public static void message() {
        // Crear las columnas de la tabla
        String[] columnNames = {
            "Documento",
            "Nombres",
            "Apellidos",
            "Edad",
            "Afiliado",
            "Categoría",
            "Precio"
        };

        // Crear el modelo de tabla para visitantes
        DefaultTableModel visitorModel = new DefaultTableModel(columnNames, 0);
        // Formateador para usar punto como separador de miles
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        // Definir punto como separador de miles
        symbols.setGroupingSeparator('.');
        // Definir coma como separador decimal
        symbols.setDecimalSeparator(',');
        // Formatear resultado final
        DecimalFormat formatter = new DecimalFormat("#,###.##", symbols);

        // Rellenar los datos de la tabla de visitantes
        for (int i = 0; i < dataVisitor; i++) {
            Object[] row = {
                visitorDocs[i],
                visitorNames[i],
                visitorSurns[i],
                visitorAges[i],
                visitorAfltn[i],
                visitorCtgr[i],
                formatter.format(visitorPrice[i])
            };
            visitorModel.addRow(row);
        }

        // Crear la tabla de visitantes
        JTable visitorTable = new JTable(visitorModel);
        visitorTable.setPreferredScrollableViewportSize(new Dimension(500, 150));  // Ajustar la altura de la tabla de visitantes
        JScrollPane visitorScrollPane = new JScrollPane(visitorTable);

        // Crear las columnas para la tabla de totales
        String[] totalColumnNames = {"Total Precio", "Menores de Edad", "Mayores de Edad"};

        // Crear el modelo de tabla para los totales
        DefaultTableModel totalModel = new DefaultTableModel(totalColumnNames, 0);
        Object[] totalRow = {
            formatter.format(totalPrice),  // Precio total
            countUnder,                    // Menores de edad
            countOver                      // Mayores de edad
        };
        totalModel.addRow(totalRow);

        // Crear la tabla de totales
        JTable totalTable = new JTable(totalModel);
        totalTable.setPreferredScrollableViewportSize(new Dimension(500, 40));  // Ajustar la altura de la tabla de totales
        JScrollPane totalScrollPane = new JScrollPane(totalTable);

        // Crear el botón de exportar
        JButton exportButton = new JButton("Exportar");
        exportButton.addActionListener(e -> saveFile());  // Llamar a la función saveFile() cuando se presione el botón

        // Crear el panel para organizar las tablas y el botón
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(visitorScrollPane, BorderLayout.CENTER); // Añadir la tabla de visitantes
        panel.add(totalScrollPane, BorderLayout.NORTH);    // Añadir la tabla de totales encima
        panel.add(exportButton, BorderLayout.SOUTH);       // Añadir el botón debajo de las tablas

        // Mostrar el panel en un JOptionPane
        JOptionPane.showMessageDialog(
            null,
            panel,  // Mostrar el panel que contiene las tablas y el botón
            "Resumen Visitantes",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public static void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Archivo");

        // Establecer el nombre del archivo predeterminado en el cuadro de diálogo
        String defaultFileName = "CmpAp1560901_" + dateTimeStamp + ".txt";
        fileChooser.setSelectedFile(new File(defaultFileName));

        // Mostrar el diálogo de guardar archivo
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(fileToSave)) {
                writer.write("Registro Visitantes%n%n");
                writer.write(String.format("Precio Total: %s%n", totalPrice));
                writer.write(String.format("Menores de Edad: %s%n", countUnder));
                writer.write(String.format("Mayores de Edad: %s%n%n", countOver));
                for (int i = 0; i < dataVisitor; i++) {
                    writer.write(String.format("Visitante %d:%n", (i + 1)));
                    writer.write(String.format("Documento: %s%n", visitorDocs[i]));
                    writer.write(String.format("Nombres: %s%n", visitorNames[i]));
                    writer.write(String.format("Apellidos: %s%n", visitorSurns[i]));
                    writer.write(String.format("Edad: %d%n", visitorAges[i]));
                    writer.write(String.format("Afiliado: %s%n", visitorAfltn[i]));
                    writer.write(String.format("Categoría: %s%n", visitorCtgr[i]));
                    writer.write(String.format("Precio: %.2f%n%n", visitorPrice[i]));
                }

                // Mostrar mensaje de éxito al usuario
                String message = "Archivo almacenado correctamente en:\n" + fileToSave.getAbsolutePath();
                JOptionPane.showMessageDialog(null, message, "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                // Manejo mejorado de errores
                String errorMessage = "Error al guardar el archivo: " + e.getMessage();
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
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
    
    public static String vldNames() {
        cptrNames();

        // Validar que el nombre solo contenga letras
        while (!isValidLetter(inputNames)) {
            mssgLetter();
            cptrNames();
        }
        // Asignar informacion correcta
        return inputNames;
    }
    
    public static String vldSurns() {
        cptrSurns();

        // Validar que el nombre solo contenga letras
        while (!isValidLetter(inputSurns)) {
            mssgLetter();
            cptrSurns();
        }
        // Asignar informacion correcta
        return inputSurns;
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
    
    public static double vldPrice(int ages, String afltn, String ctgr) {
        double price = 0;
        if (ages < 18) { price = 5000; }
        if (ages >= 18 && "No".equals(afltn)) {
            price = valueBase;
        }
        if (ages >= 18 && "Si".equals(afltn)) {
            price = switch (ctgr.toUpperCase()) {
                case "A" -> valueBase * 0.85;
                case "B" -> valueBase * 0.70;
                case "C" -> valueBase * 0.50;
                default -> valueBase;
            };
        }
        System.out.println("valueBase:" + " " + valueBase);
        return price;
    }
    
    public static void cptrVisitor() {
        // Captura Datos
        inputVisitor = JOptionPane.showInputDialog(
null,
        "Cantidad Visitantes",
        "Application Software", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrDoc() {
        // Captura Datos
        inputDoc = JOptionPane.showInputDialog(
null,
        "Documento",
        "Application Software", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrNames() {
        // Captura Datos
        inputNames = JOptionPane.showInputDialog(
        null,
        "Nombres",
        "Application Software", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrSurns() {
        // Captura Datos
        inputSurns = JOptionPane.showInputDialog(
        null,
        "Apellidos",
        "Application Software", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void cptrAge() {
        // Captura Datos
        inputAge = JOptionPane.showInputDialog(
null,
        "Edad",
        "Application Software", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static boolean cptrAfltn() {
        // Captura Datos
        int response = JOptionPane.showConfirmDialog(
            null,
            "Afiliado",
            "Application Software",
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
    
    public static void mssgSuccess(String message) {
        String result = "Exito";
        JOptionPane.showMessageDialog(
null,
        result + ":" + " " + message, // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgError(String message) {
        String result = "Identificamos Errores";
        JOptionPane.showMessageDialog(
null,
        result + ":" + " " + message, // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.ERROR_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgCountMin() {
        JOptionPane.showMessageDialog(
null,
        "Únicamente se aceptan valores mayor a cero.", // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgLetter() {
        JOptionPane.showMessageDialog(
null,
        "Únicamente se aceptan letras.", // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgNumber() {
        JOptionPane.showMessageDialog(
null,
        "Únicamente se aceptan números.", // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgEmpty() {
        JOptionPane.showMessageDialog(
null,
        "Únicamente se aceptan valores seleccionables.", // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
}
