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

    public static void main(String[] args) {
        System.out.println("App Software");
        //Compensar.test();
        desktop();
    }
    
    public static void desktop() {
        // Crear el marco principal
        JFrame frame = new JFrame("Compensar: Aplicacion Software");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        // Desactivar la maximización
        // Deshabilitar el redimensionamiento
        frame.setResizable(false);
        
        // Crear el JDesktopPane
        JDesktopPane desktopPane = new JDesktopPane();
        
        // Añadir el JDesktopPane al marco
        frame.add(desktopPane);
        
        // Hacer visible el marco
        frame.setVisible(true);
        
        // Centrar el marco en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Abrir JInternalFrame
        Desktop.openInternal(desktopPane);
    }
    
    
    
    
    
    
    
    
    
    
    public static void desktop_() {
        // Crear el marco principal
        JFrame frame = new JFrame("Compensar: Aplicacion Software");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        // Crear el JDesktopPane
        JDesktopPane desktopPane = new JDesktopPane();
        
        // Crear el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Llamar a la función para agregar pestañas
        addTabs(tabbedPane);
        
        // Ajustar el tamaño y posición del JTabbedPane
        tabbedPane.setBounds(0, 0, 800, 600); // Ajustar según sea necesario
        
        // Añadir el JTabbedPane al JDesktopPane
        desktopPane.add(tabbedPane);
        
        // Añadir el JDesktopPane al marco
        frame.add(desktopPane);
        
        // Centrar el marco en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Hacer visible el marco
        frame.setVisible(true);
    }
    
    public static void addTabs(JTabbedPane tabbedPane) {
        // Crear algunos paneles para las pestañas
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Contenido de la Pestaña 1"));
        
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Contenido de la Pestaña 2"));
        
        // Añadir pestañas al JTabbedPane
        tabbedPane.addTab("Pestaña 1", panel1);
        tabbedPane.addTab("Pestaña 2", panel2);
    }
}
