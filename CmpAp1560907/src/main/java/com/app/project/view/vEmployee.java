/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author adiso
 */
public class vEmployee {
    public static JTabbedPane tabbedPane() {
        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
                
        // Crear un panel para una pestaña
        JPanel employeeListPanel = new JPanel();
        employeeListPanel.add(new JLabel("Lista de Empleados")); // Aquí puedes agregar más contenido

        // Crear otro panel para otra pestaña
        JPanel employeeDetailsPanel = new JPanel();
        employeeDetailsPanel.add(new JLabel("Detalles de Empleados")); // Aquí puedes agregar más contenido

        // Añadir los paneles al JTabbedPane
        tabbedPane.addTab("Lista", employeeListPanel);
        tabbedPane.addTab("Detalles", employeeDetailsPanel);

        // Devolver el JTabbedPane
        return tabbedPane;
    }
}
