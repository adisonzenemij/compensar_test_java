
package com.app.project;

import javax.swing.JOptionPane;

public class Message {
    public static void mssgError(String message) {
        String result = "Error";
        JOptionPane.showMessageDialog(
null,
        result + ":" + " " + message, // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.ERROR_MESSAGE // Tipo de mensaje
        );
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
    
    public static void mssgWarning(String message) {
        String result = "Advertencia";
        JOptionPane.showMessageDialog(
null,
        result + ":" + " " + message, // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgField(String data) {
        JOptionPane.showMessageDialog(
null,
            "Campo (" + data + ") Obligatorio.", // Mensaje de ayuda
        "Application Software", // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
    
    public static String cptrData(String field) {
        String value = JOptionPane.showInputDialog(
        null,
        field,
        "Application Software", // Título de la ventana
            JOptionPane.QUESTION_MESSAGE // Tipo de mensaje
        );
        return value;
    }
}
