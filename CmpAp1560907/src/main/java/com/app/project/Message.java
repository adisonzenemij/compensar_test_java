/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import javax.swing.JOptionPane;

/**
 *
 * @author adiso
 */
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
}
