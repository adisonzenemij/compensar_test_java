/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adiso
 */
public class Benefit {
    private static JTable tblBenefit;
    private static DefaultTableModel mdlBenefit;

    public static JTabbedPane tabbedPane() {
        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        




        // Crear un panel para una pestaña
        JPanel listPanel = new JPanel(new BorderLayout());
        // Ajuste para que el JLabel esté en la parte superior
        //listPanel.add(new JLabel("Registros"), BorderLayout.NORTH);

        // Modelo para el registro de beneficios
        String[] columns = tableColumn(); // Obtener las columnas
        mdlBenefit = new DefaultTableModel(columns, 0);
        tblBenefit = new JTable(mdlBenefit);
        listPanel.add(new JScrollPane(tblBenefit), BorderLayout.CENTER);

        // Formulario de empleados
        JPanel actionPanel = new JPanel(new GridLayout(1,3));

        // Botones del panel principal
        JButton createBtn = new JButton("Añadir Registro");
        JButton updateBtn = new JButton("Actualizar Registro");
        JButton deleteBtn = new JButton("Eliminar Registro");

        actionPanel.add(createBtn);
        actionPanel.add(updateBtn);
        actionPanel.add(deleteBtn);

        listPanel.add(actionPanel, BorderLayout.SOUTH);

        // Añadir los paneles al JTabbedPane
        tabbedPane.addTab("Información", listPanel);





        // Crear un formulario para capturar valores
        JPanel newForm = new JPanel(new BorderLayout());

        // Crear un formulario para capturar valores
        JPanel newField = new JPanel(new GridLayout(10,2));

        JLabel labelShop = new JLabel("Tienda");
        JTextField fieldShop = new JTextField();

        JLabel labelRecreat = new JLabel("Recreación");
        JTextField fieldRecreat = new JTextField();

        newField.add(labelShop); newField.add(fieldShop);
        newField.add(labelRecreat); newField.add(fieldRecreat);

        // Crear un panel para añadir botones de acciones
        JPanel newAction = new JPanel(new GridLayout(1,1));
        JButton saveBtn = new JButton("Guardar Registro");
        newAction.add(saveBtn);

        newForm.add(newField, BorderLayout.NORTH);
        newForm.add(newAction, BorderLayout.SOUTH);
        
        // Añadir el panel del formulario al JTabbedPane
        tabbedPane.addTab("Formulario", newForm);





        // Redireccionar al panel del formulario con valores vacios
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        // Redireccionar al panel del formulario con valores llenos
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        // Eliminar el registro seleccionado del modelo
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        // Almacenar registro en el modelo
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = 0;
                shop = fieldShop.getText();
                recreat = fieldRecreat.getText();
                mdlBenefit.addRow(
                    new Object[] {
                        id,
                        shop,
                        recreat,
                    }
                );
            }
        });






        // Devolver el JTabbedPane
        return tabbedPane;
    }

    public static String[] tableColumn() {
        return new String[] {
            "Registro",
            "Tienda",
            "Recreación",
        };
    }
}
