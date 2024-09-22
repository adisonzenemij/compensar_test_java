/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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

import com.app.project.model.mBenefit;

/**
 *
 * @author adiso
 */
public class vBenefit {
    private static JTable tblBenefit;
    private static DefaultTableModel dfltBenefit;
    private static mBenefit mdlBenefit = new mBenefit();

    // JTabbedPane del internal frame
    private static JTabbedPane tabbedPane;

    // Paneles del internal frame
    private static JPanel listPanel;
    private static JPanel actionPanel;
    private static JPanel newForm;
    private static JPanel newField;
    private static JPanel newAction;

    // Campos del formulario
    private static JLabel labelId;
    private static JLabel labelShop;
    private static JLabel labelRecreat;
    private static JTextField fieldId;
    private static JTextField fieldShop;
    private static JTextField fieldRecreat;

    // Botones de los paneles
    private static JButton createBtn;
    private static JButton updateBtn;
    private static JButton deleteBtn;
    private static JButton saveBtn;
    private static JButton cancelBtn;
    
    // Contador para generar ID autoincrementable
    private static int nextId = 1;
    // Controla si se está editando un registro
    private static boolean isEditing = false;
    // Índice de la fila que se está editando
    private static int editingRowIndex = -1;

    public static JTabbedPane tabbedPane() {
        // Crear un JTabbedPane
        tabbedPane = new JTabbedPane();
        
        // Crear un panel para una pestaña
        listPanel = new JPanel(new BorderLayout());

        // Modelo para el registro de beneficios
        String[] columns = tableColumn(); // Obtener las columnas
        dfltBenefit = new DefaultTableModel(columns, 0);
        tblBenefit = new JTable(dfltBenefit);
        listPanel.add(new JScrollPane(tblBenefit), BorderLayout.CENTER);

        // Formulario de acciones
        infoAction();

        // Añadir los paneles al JTabbedPane
        tabbedPane.addTab("Información", listPanel);

        // Utilizar el formulario
        formData();
        // Utilizar funcionalidades en la pestaña principal
        btnCreate(); btnUpdate(); btnDelete();
        // Utilizar funcionalidades en la pestaña formulario
        btnSave(); btnCancel();

        // Devolver el JTabbedPane
        return tabbedPane;
    }

    // Formulario del respectivo modelo
    public static void infoAction() {
        // Formulario de acciones
        actionPanel = new JPanel(new GridLayout(1,3));
        // Botones del panel principal
        createBtn = new JButton("Añadir Registro");
        updateBtn = new JButton("Actualizar Registro");
        deleteBtn = new JButton("Eliminar Registro");
        // Adicionar botones al panel
        actionPanel.add(createBtn);
        actionPanel.add(updateBtn);
        actionPanel.add(deleteBtn);
        // Añadir panel a otro panel con borde
        listPanel.add(actionPanel, BorderLayout.SOUTH);
    }

    // Formulario del respectivo modelo
    public static void formData() {
        // Crear un formulario para capturar valores
        newForm = new JPanel(new BorderLayout());

        // Crear un formulario para capturar valores
        newField = new JPanel(new GridLayout(10,2));

        labelId = new JLabel("Registro");
        fieldId = new JTextField();
        fieldId.setEditable(false); // Bloquear el campo

        labelShop = new JLabel("Tienda");
        fieldShop = new JTextField();
        fieldShop.setEditable(true); // Habilitar el campo

        labelRecreat = new JLabel("Recreación");
        fieldRecreat = new JTextField();
        fieldRecreat.setEditable(true); // Habilitar el campo

        newField.add(labelId); newField.add(fieldId);
        newField.add(labelShop); newField.add(fieldShop);
        newField.add(labelRecreat); newField.add(fieldRecreat);

        // Crear un panel para añadir botones de acciones
        newAction = new JPanel(new GridLayout(1,1));

        // Botones del panel formulario
        saveBtn = new JButton("Guardar Registro");
        cancelBtn = new JButton("Cancelar Registro");

        newAction.add(saveBtn);
        newAction.add(cancelBtn);

        newForm.add(newField, BorderLayout.NORTH);
        newForm.add(newAction, BorderLayout.SOUTH);
    }

    // Estabelcer valores vacio del formulario
    public static void btnCreate() {
        // Redireccionar al panel del formulario
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isEditing = false; // Edicion desactivada
                // Limpiar campos del formulario
                clearFields();
                // Asignar el próximo ID
                fieldId.setText(String.valueOf(nextId));
                // Añadir la pestaña del formulario
                tabbedPane.addTab("Formulario", newForm);
                // Remover la pestaña establecida según su titulo
                tabbedPane.removeTabAt(tabbedPane.indexOfTab("Información"));
                // Seleccionar la pestaña establecida según su titulo
                tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Formulario"));
            }
        });
    }

    // Actualizar el formulario con valores del modelo
    public static void btnUpdate() {
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblBenefit.getSelectedRow();
                if (selectedRow >= 0) {
                    isEditing = true; // Modo edición activada
                    editingRowIndex = selectedRow; // Guardar la fila que se está editando
                    // Llenar los campos con los valores seleccionados
                    fieldId.setText((String) tblBenefit.getValueAt(selectedRow, 0).toString());
                    fieldShop.setText((String) tblBenefit.getValueAt(selectedRow, 1));
                    fieldRecreat.setText((String) tblBenefit.getValueAt(selectedRow, 2));
                    // Añadir la pestaña del formulario
                    tabbedPane.addTab("Formulario", newForm);
                    // Remover la pestaña establecida según su titulo
                    tabbedPane.removeTabAt(tabbedPane.indexOfTab("Información"));
                    // Seleccionar la pestaña establecida según su titulo
                    tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Formulario"));
                }
            }
        });
    }

    // Eliminar el registro seleccionado del modelo
    public static void btnDelete() {
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblBenefit.getSelectedRow();
                if (selectedRow >= 0) {
                    dfltBenefit.removeRow(selectedRow);
                }
            }
        });
    }

    // Almacenar registro en el modelo
    public static void btnSave() {
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /// Usar el modelo para establecer los valores
                mdlBenefit.setShop(fieldShop.getText());
                mdlBenefit.setRecreat(fieldRecreat.getText());

                if (isEditing && editingRowIndex >= 0) {
                    // Actualizar registro existente
                    dfltBenefit.setValueAt(mdlBenefit.getShop(), editingRowIndex, 1);
                    dfltBenefit.setValueAt(mdlBenefit.getRecreat(), editingRowIndex, 2);
                } else {
                    // Crear nuevo registro
                    dfltBenefit.addRow(new Object[] {
                        nextId++, // ID autoincrementable
                        mdlBenefit.getShop(),
                        mdlBenefit.getRecreat()
                    });
                }

                // Limpiar campos del formulario
                clearFields();

                // Añadir la pestaña establecida según su titulo
                tabbedPane.addTab("Información", listPanel);
                // Remover la pestaña establecida según su titulo
                tabbedPane.removeTabAt(tabbedPane.indexOfTab("Formulario"));
                // Seleccionar la pestaña establecida según su titulo
                tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Información"));
            }
        });
    }

    // Cancelar registro del formulario
    public static void btnCancel() {
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar campos del formulario
                clearFields();

                // Añadir la pestaña establecida según su titulo
                tabbedPane.addTab("Información", listPanel);
                // Remover la pestaña establecida según su titulo
                tabbedPane.removeTabAt(tabbedPane.indexOfTab("Formulario"));
                // Seleccionar la pestaña establecida según su titulo
                tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("Información"));
            }
        });
    }

    // Retornar columnas para la tabla
    public static String[] tableColumn() {
        return new String[] {
            "Registro",
            "Tienda",
            "Recreación",
        };
    }

    // Limpiar los campos del formulario
    private static void clearFields() {
        fieldShop.setText("");
        fieldRecreat.setText("");
    }
}
