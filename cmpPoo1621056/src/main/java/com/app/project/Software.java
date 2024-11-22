
package com.app.project;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.app.project.models.MUserData;

public class Software {
    public static void main(String[] args) {
        // Acceder
        access();
    }
    
    public static void access() {
        // Inicializar el modelo de usuario
        MUserData.initializeModel();
        // Crear el marco principal
        JFrame dataFrame = new JFrame("Compensar: Aplicacion Software");
        // Establece la operación de cierre predeterminada
        dataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establece el tamaño de la ventana
        dataFrame.setSize(1000, 800);
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
        Access.openInternal(desktopPane);
    }
    
    public static void addTabs(JTabbedPane tabbedPane) {
        // Crear algunos paneles para las pestañas
        JPanel contentPanel = new JPanel();
        // Añadir una etiqueta con el texto personalizado
        contentPanel.add(new JLabel("Contenido"));
        // Añadir pestañas al tabbed pane
        tabbedPane.addTab("Pestaña", contentPanel);
    }
}
