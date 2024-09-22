/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.app.project;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author adiso
 */
public class Software {

    private static JFrame dataFrame;

    private static JPanel contentPanel;

    public static void main(String[] args) {
        System.out.println("App Software");
        //Compensar.test();
        desktop();
    }
    
    public static void desktop() {
        // Crear el marco principal
        dataFrame = new JFrame("Compensar: Aplicacion Software");
        dataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dataFrame.setSize(1000, 800);

        // Desactivar la maximización
        // Deshabilitar el redimensionamiento
        dataFrame.setResizable(false);
        
        // Crear el JDesktopPane
        JDesktopPane desktopPane = new JDesktopPane();
        
        // Añadir el JDesktopPane al marco
        dataFrame.add(desktopPane);
        
        // Hacer visible el marco
        dataFrame.setVisible(true);
        
        // Centrar el marco en la pantalla
        dataFrame.setLocationRelativeTo(null);
        
        // Abrir internal frame
        Desktop.openInternal(desktopPane);
    }
    
    public static void addTabs(JTabbedPane tabbedPane) {
        // Crear algunos paneles para las pestañas
        contentPanel = new JPanel();
        contentPanel.add(new JLabel("Contenido"));
        
        // Añadir pestañas al tabbed pane
        tabbedPane.addTab("Pestaña", contentPanel);
    }
}
