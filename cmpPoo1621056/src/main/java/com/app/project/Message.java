
package com.app.project;

import javax.swing.JOptionPane;

public class Message {
    private static String title;

    // Constructor
    private Message() {}
    
    // Obtener valores de titulo
    public static String getTitle() {
        return title;
    }

    // Mapear valores de titulo
    public static void setTitle(String title) {
        // Acceder de manera estática
        Message.title = title;
    }

    public static void mssgError(String message) {
        String result = "Error";
        JOptionPane.showMessageDialog(
null,
        result + ":" + " " + message, // Mensaje de ayuda
        getTitle(), // Título de la ventana
            JOptionPane.ERROR_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgSuccess(String message) {
        String result = "Exito";
        JOptionPane.showMessageDialog(
null,
        result + ":" + " " + message, // Mensaje de ayuda
        getTitle(), // Título de la ventana
            JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgWarning(String message) {
        String result = "Advertencia";
        JOptionPane.showMessageDialog(
null,
        result + ":" + " " + message, // Mensaje de ayuda
        getTitle(), // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
    
    public static void mssgField(String data) {
        JOptionPane.showMessageDialog(
null,
            "Campo (" + data + ") Obligatorio.", // Mensaje de ayuda
        getTitle(), // Título de la ventana
            JOptionPane.WARNING_MESSAGE // Tipo de mensaje
        );
    }
}
