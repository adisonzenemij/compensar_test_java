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

import com.app.project.model.mProduct;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

/**
 *
 * @author adiso
 */
public class vProduct {
    private static JTable tblDataInfo;
    private static DefaultTableModel dfltDataModel;
    private static mProduct mdlProduct;

    // JTabbedPane del internal frame
    private static JTabbedPane tabbedPane;

    // Paneles del internal frame
    private static JPanel listPanel;
    private static JPanel actionPanel;
    private static JPanel newForm;
    private static JPanel newField;
    private static JPanel newAction;

    // Etiquetas del formulario
    private static JLabel labelId;
    private static JLabel labelName;
    private static JLabel labelUnity;
    private static JLabel labelUnitary;
    private static JLabel labelIva;
    private static JLabel labelTotal;
    private static JLabel labelType;

    // Campos del formulario
    private static JTextField fieldId;
    private static JTextField fieldName;
    private static JTextField fieldUnity;
    private static JTextField fieldUnitary;
    private static JTextField fieldIva;
    private static JTextField fieldTotal;
    private static JTextField fieldType;

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
    private static int selectedRow;

    public static JTabbedPane tabbedPane(DefaultTableModel modelData, mProduct benefitMdl) {
        dfltDataModel = modelData; mdlProduct = benefitMdl;
        System.out.println("Productos: Modelo:" + " " + dfltDataModel);
        System.out.println("Productos: Datos:" + " " + mdlProduct);

        // Crear un JTabbedPane
        if (tabbedPane == null) { tabbedPane = new JTabbedPane(); }
        
        // Crear un panel para una pestaña
        if (listPanel == null) { listPanel = new JPanel(new BorderLayout()); }

        // Modelo para el registro de beneficios
        tblDataInfo = new JTable(modelData);
        tblDataInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblDataInfo.setCellSelectionEnabled(false);
        tblDataInfo.setRowSelectionAllowed(true);
        System.out.println("Productos: Registros:" + " " + dfltDataModel.getRowCount());
        listPanel.add(new JScrollPane(tblDataInfo), BorderLayout.CENTER);

        // Formulario de acciones
        infoAction();
        // Añadir los paneles al JTabbedPane
        tabPaneDflt();
        // Verificar fila seleccionada
        rowSelected();
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

        labelName = new JLabel("Nombre");
        fieldName = new JTextField();
        fieldName.setEditable(true); // Habilitar el campo

        labelUnity = new JLabel("Unidad");
        fieldUnity = new JTextField();
        fieldUnity.setEditable(true); // Habilitar el campo

        labelUnitary = new JLabel("Valor Unitario");
        fieldUnitary = new JTextField();
        fieldUnitary.setEditable(true); // Habilitar el campo

        labelIva = new JLabel("IVA");
        fieldIva = new JTextField();
        fieldIva.setEditable(true); // Habilitar el campo

        labelTotal = new JLabel("Total");
        fieldTotal = new JTextField();
        fieldTotal.setEditable(true); // Habilitar el campo

        labelType = new JLabel("Tipo");
        fieldType = new JTextField();
        fieldType.setEditable(true); // Habilitar el campo

        newField.add(labelId); newField.add(fieldId);
        newField.add(labelName); newField.add(fieldName);
        newField.add(labelUnity); newField.add(fieldUnity);
        newField.add(labelUnitary); newField.add(fieldUnitary);
        newField.add(labelIva); newField.add(fieldIva);
        newField.add(labelTotal); newField.add(fieldTotal);
        newField.add(labelType); newField.add(fieldType);

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
                //int selectedRow = tblDataInfo.getSelectedRow();
                System.out.println("selectedRow" + selectedRow);
                if (selectedRow >= 0) {
                    isEditing = true; // Modo edición activada
                    editingRowIndex = selectedRow; // Guardar la fila que se está editando
                    // Llenar los campos con los valores seleccionados
                    fieldId.setText((String) tblDataInfo.getValueAt(selectedRow, 0).toString());
                    fieldName.setText((String) tblDataInfo.getValueAt(selectedRow, 1).toString());
                    fieldUnity.setText((String) tblDataInfo.getValueAt(selectedRow, 2).toString());
                    fieldUnitary.setText((String) tblDataInfo.getValueAt(selectedRow, 3).toString());
                    fieldIva.setText((String) tblDataInfo.getValueAt(selectedRow, 4).toString());
                    fieldTotal.setText((String) tblDataInfo.getValueAt(selectedRow, 5).toString());
                    fieldType.setText((String) tblDataInfo.getValueAt(selectedRow, 6).toString());
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
                int selectedRow = tblDataInfo.getSelectedRow();
                if (selectedRow >= 0 || selectedRow != -1) {
                    dfltDataModel.removeRow(selectedRow);
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
                mdlProduct.setName(fieldName.getText());
                mdlProduct.setUnity(Integer.parseInt(fieldUnity.getText()));
                mdlProduct.setUnitary(Integer.parseInt(fieldUnitary.getText()));
                mdlProduct.setIva(Double.parseDouble(fieldIva.getText()));
                mdlProduct.setTotal(Double.parseDouble(fieldTotal.getText()));
                mdlProduct.setType(Integer.parseInt(fieldType.getText()));

                if (isEditing && editingRowIndex >= 0) {
                    // Actualizar registro existente
                    dfltDataModel.setValueAt(mdlProduct.getName(), editingRowIndex, 1);
                    dfltDataModel.setValueAt(mdlProduct.getUnity(), editingRowIndex, 2);
                    dfltDataModel.setValueAt(mdlProduct.getUnitary(), editingRowIndex, 3);
                    dfltDataModel.setValueAt(mdlProduct.getIva(), editingRowIndex, 4);
                    dfltDataModel.setValueAt(mdlProduct.getTotal(), editingRowIndex, 5);
                    dfltDataModel.setValueAt(mdlProduct.getType(), editingRowIndex, 6);
                } else {
                    // Crear nuevo registro
                    dfltDataModel.addRow(new Object[] {
                        nextId++, // ID autoincrementable
                        mdlProduct.getName(),
                        mdlProduct.getUnity(),
                        mdlProduct.getUnitary(),
                        mdlProduct.getIva(),
                        mdlProduct.getTotal(),
                        mdlProduct.getType(),
                    });
                }

                // Limpiar campos del formulario
                clearFields();
                tabPaneDflt();
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
                tabPaneDflt();
            }
        });
    }

    // Establecer paneles por defecto
    public static void tabPaneDflt() {
        // Añadir la pestaña establecida según su titulo
        tabbedPane.addTab("Información", listPanel);
        // Verificar si la pestaña "Formulario" existe antes de intentar eliminarla
        int indexFormulario = tabbedPane.indexOfTab("Formulario");
        if (indexFormulario >= 0) {
            // Remover la pestaña "Formulario" si existe
            tabbedPane.removeTabAt(indexFormulario);
        }
        // Seleccionar la pestaña "Información"
        int indexInformacion = tabbedPane.indexOfTab("Información");
        if (indexInformacion >= 0) {
            // Seleccionar la pestaña "Información" si existe
            tabbedPane.setSelectedIndex(indexInformacion);
        }
    }

    // Verificar la seleccion de la fila
    public static void rowSelected() {
        tblDataInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = tblDataInfo.rowAtPoint(e.getPoint());
                System.out.println("Row Selected:" + " " + selectedRow);
            }
        });
    }

    // Retornar columnas para la tabla
    public static String[] tableColumn() {
        return new String[] {
            "Registro",
            "Nombre",
            "Unidad",
            "Valor Unitario",
            "IVA",
            "Valor Total",
            "Tipo",
        };
    }

    // Limpiar los campos del formulario
    private static void clearFields() {
        fieldName.setText("");
        fieldUnity.setText("");
        fieldUnitary.setText("");
        fieldIva.setText("");
        fieldTotal.setText("");
        fieldType.setText("");
    }
}
