/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project.view;

import com.app.project.model.mBenefit;
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

import com.app.project.model.mEmployee;
import com.app.project.model.mWorking;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author adiso
 */
public class vEmployee {
    private static JTable tblDataInfo;
    private static DefaultTableModel dfltDataModel;
    private static mEmployee mdlEmployee;

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
    private static JLabel labelDocument;
    private static JLabel labelNames;
    private static JLabel labelSrnms;
    private static JLabel labelAge;
    private static JLabel labelTime;
    private static JLabel labelBenefit;
    private static JLabel labelWorking;
    
    // Campos del formulario
    private static JTextField fieldId;
    private static JTextField fieldDocument;
    private static JTextField fieldNames;
    private static JTextField fieldSrnms;
    private static JFormattedTextField fieldAge;
    private static JFormattedTextField fieldTime;
    private static JComboBox<String> fieldBenefit;
    private static JComboBox<String> fieldWorking;

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

    private static Map<Integer, String> benefitMap = new HashMap<>();
    private static Map<Integer, String> workingMap = new HashMap<>();

    public static JTabbedPane tabbedPane(DefaultTableModel modelData, mEmployee employeeMdl) {
        dfltDataModel = modelData; mdlEmployee = employeeMdl;

        // Crear un JTabbedPane
        if (tabbedPane == null) { tabbedPane = new JTabbedPane(); }
        
        // Crear un panel para una pestaña
        if (listPanel == null) { listPanel = new JPanel(new BorderLayout()); }

        // Modelo para el registro de beneficios
        tblDataInfo = new JTable(modelData);
        tblDataInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblDataInfo.setCellSelectionEnabled(false);
        tblDataInfo.setRowSelectionAllowed(true);
        System.out.println("Beneficios: Registros:" + " " + dfltDataModel.getRowCount());
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

        labelDocument = new JLabel("Documento");
        fieldDocument = new JTextField();
        fieldDocument.setEditable(true); // Habilitar el campo

        labelNames = new JLabel("Nombres");
        fieldNames = new JTextField();
        fieldNames.setEditable(true); // Habilitar el campo

        labelSrnms = new JLabel("Apellidos");
        fieldSrnms = new JTextField();
        fieldSrnms.setEditable(true); // Habilitar el campo

        labelAge = new JLabel("Edad");
        //fieldAge = new JTextField();
        //fieldAge.setEditable(true); // Habilitar el campo
        fieldAge = new JFormattedTextField();
        fieldAge.setColumns(10); // Establece el número de columnas
        fieldAge.setEditable(true); // Habilitar el campo
        fieldAge.setValue(0); // Valor inicial
        fieldAge.setFocusLostBehavior(JFormattedTextField.PERSIST); // Persistir valor

        labelTime = new JLabel("Tiempo");
        //fieldTime = new JTextField();
        //fieldTime.setEditable(true); // Habilitar el campo
        fieldTime = new JFormattedTextField();
        fieldTime.setColumns(10); // Establece el número de columnas
        fieldTime.setEditable(true); // Habilitar el campo
        fieldTime.setValue(0); // Valor inicial
        fieldTime.setFocusLostBehavior(JFormattedTextField.PERSIST); // Persistir valor

        labelBenefit = new JLabel("Beneficio");
        fieldBenefit = new JComboBox<>();
        fieldBenefit.setEditable(true); // Habilitar el campo

        labelWorking = new JLabel("Jornada");
        fieldWorking = new JComboBox<>();
        fieldWorking.setEditable(true); // Habilitar el campo

        // Establecer el formato para que solo acepte números
        fieldAge.setFormatterFactory(
            new javax.swing.text.DefaultFormatterFactory(
                new javax.swing.text.NumberFormatter(
                    new java.text.DecimalFormat("#0")
                )
            )
        );
        fieldTime.setFormatterFactory(
            new javax.swing.text.DefaultFormatterFactory(
                new javax.swing.text.NumberFormatter(
                    new java.text.DecimalFormat("#0")
                )
            )
        );

        newField.add(labelId); newField.add(fieldId);
        newField.add(labelDocument); newField.add(fieldDocument);
        newField.add(labelNames); newField.add(fieldNames);
        newField.add(labelSrnms); newField.add(fieldSrnms);
        newField.add(labelAge); newField.add(fieldAge);
        newField.add(labelTime); newField.add(fieldTime);
        newField.add(labelBenefit); newField.add(fieldBenefit);
        newField.add(labelWorking); newField.add(fieldWorking);

        // Crear un panel para añadir botones de acciones
        newAction = new JPanel(new GridLayout(1,1));

        // Botones del panel formulario
        saveBtn = new JButton("Guardar Registro");
        cancelBtn = new JButton("Cancelar Registro");

        newAction.add(saveBtn);
        newAction.add(cancelBtn);

        newForm.add(newField, BorderLayout.NORTH);
        newForm.add(newAction, BorderLayout.SOUTH);

        formTime();
        workingList();
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
                if (selectedRow >= 0) {
                    isEditing = true; // Modo edición activada
                    editingRowIndex = selectedRow; // Guardar la fila que se está editando
                    // Llenar los campos con los valores seleccionados
                    fieldId.setText((String) tblDataInfo.getValueAt(selectedRow, 0).toString());
                    fieldDocument.setText((String) tblDataInfo.getValueAt(selectedRow, 1).toString());
                    fieldNames.setText((String) tblDataInfo.getValueAt(selectedRow, 2).toString());
                    fieldSrnms.setText((String) tblDataInfo.getValueAt(selectedRow, 3).toString());
                    fieldAge.setText((String) tblDataInfo.getValueAt(selectedRow, 4).toString());
                    fieldTime.setText((String) tblDataInfo.getValueAt(selectedRow, 5).toString());
                    fieldBenefit.setSelectedItem((String) tblDataInfo.getValueAt(selectedRow, 6).toString());
                    fieldWorking.setSelectedItem((String) tblDataInfo.getValueAt(selectedRow, 7).toString());

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
                if (selectedRow >= 0) {
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
                mdlEmployee.setDocument(fieldDocument.getText());
                mdlEmployee.setNames(fieldNames.getText());
                mdlEmployee.setSrnms(fieldSrnms.getText());
                mdlEmployee.setAge(Integer.parseInt(fieldAge.getText()));
                mdlEmployee.setTime(Integer.parseInt(fieldTime.getText()));
                
                // Obtener el valor seleccionado y buscar el ID
                String benefitData = fieldBenefit.getSelectedItem().toString();
                Integer benefitId = null;

                for (Map.Entry<Integer, String> entry : benefitMap.entrySet()) {
                    if (entry.getValue().equals(benefitData)) {
                        // Obtener el ID
                        benefitId = entry.getKey();
                        break;
                    }
                }
                // Guardar el ID en el modelo
                mdlEmployee.setBenefit(benefitId);
                
                // Obtener el valor seleccionado y buscar el ID
                String workingData = fieldWorking.getSelectedItem().toString();
                Integer workingId = null;

                for (Map.Entry<Integer, String> entry : workingMap.entrySet()) {
                    if (entry.getValue().equals(workingData)) {
                        // Obtener el ID
                        workingId = entry.getKey();
                        break;
                    }
                }
                // Guardar el ID en el modelo
                mdlEmployee.setWorking(workingId);

                if (isEditing && editingRowIndex >= 0) {
                    // Actualizar registro existente
                    dfltDataModel.setValueAt(mdlEmployee.getDocument(), editingRowIndex, 1);
                    dfltDataModel.setValueAt(mdlEmployee.getNames(), editingRowIndex, 2);
                    dfltDataModel.setValueAt(mdlEmployee.getSrnms(), editingRowIndex, 3);
                    dfltDataModel.setValueAt(mdlEmployee.getAge(), editingRowIndex, 4);
                    dfltDataModel.setValueAt(mdlEmployee.getTime(), editingRowIndex, 5);
                    dfltDataModel.setValueAt(benefitMap.get(mdlEmployee.getBenefit()), editingRowIndex, 6);
                    dfltDataModel.setValueAt(workingMap.get(mdlEmployee.getWorking()), editingRowIndex, 7);
                } else {
                    // Crear nuevo registro
                    dfltDataModel.addRow(new Object[] {
                        nextId++, // ID autoincrementable
                        mdlEmployee.getDocument(),
                        mdlEmployee.getNames(),
                        mdlEmployee.getSrnms(),
                        mdlEmployee.getAge(),
                        mdlEmployee.getTime(),
                        benefitMap.get(mdlEmployee.getBenefit()),
                        workingMap.get(mdlEmployee.getWorking()),
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
            "Documento",
            "Nombres",
            "Apellidos",
            "Edad",
            "Tiempo",
            "Beneficios",
            "Jornada",
        };
    }

    // Limpiar los campos del formulario
    private static void clearFields() {
        fieldDocument.setText("");
        fieldNames.setText("");
        fieldSrnms.setText("");
        fieldAge.setText("");
        fieldTime.setText("");
        fieldBenefit.setSelectedIndex(-1);
        fieldWorking.setSelectedIndex(-1);
    }

    public static List<mEmployee> getList() {
        List<mEmployee> employeeList = new ArrayList<>();
    
        // Recorrer las filas del DefaultTableModel
        for (int row = 0; row < dfltDataModel.getRowCount(); row++) {
            mEmployee employee = new mEmployee();
            employee.setId((int) dfltDataModel.getValueAt(row, 0));
            employee.setDocument((String) dfltDataModel.getValueAt(row, 1));
            employee.setNames((String) dfltDataModel.getValueAt(row, 2));
            employee.setSrnms((String) dfltDataModel.getValueAt(row, 3));
            employee.setAge((int) dfltDataModel.getValueAt(row, 4));
            employee.setTime((int) dfltDataModel.getValueAt(row, 5));
            employee.setBenefit((int) dfltDataModel.getValueAt(row, 6));
            employee.setWorking((int) dfltDataModel.getValueAt(row, 7));
            employeeList.add(employee);
        }
    
        return employeeList;
    }

    public static void benefitList(int valTime) {
        List<mBenefit> listOfBenefitData = vBenefit.getList();
        // Limpiar el JComboBox antes de agregar nuevos elementos
        fieldBenefit.removeAllItems();
        // Limpiar el mapa antes de llenarlo
        benefitMap.clear();
    
        for (mBenefit benefit : listOfBenefitData) {
            int ageMin = benefit.getAgeMin();
            int ageMax = benefit.getAgeMax();
            if (valTime >= ageMin && valTime <= ageMax) {
                // Guardar la relación
                benefitMap.put(benefit.getId(), benefit.getRebate());
                // Añadir el valor al JComboBox
                fieldBenefit.addItem(benefit.getRebate());
            }
        }
    }

    public static void workingList() {
        List<mWorking> listOfWorkingData = vWorking.getList();
        // Limpiar el JComboBox antes de agregar nuevos elementos
        fieldWorking.removeAllItems();
        // Limpiar el mapa antes de llenarlo
        workingMap.clear();
    
        for (mWorking working : listOfWorkingData) {
            // Guardar la relación
            workingMap.put(working.getId(), working.getName());
            // Añadir el valor al JComboBox
            fieldWorking.addItem(working.getName());
        }
    }

    public static void formTime() {
        // Añadir un ActionListener al campo fieldTime
        fieldTime.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                // Obtener el valor del campo "Tiempo"
                String timeValue = fieldTime.getText();
                if (timeValue == null) { timeValue = "0"; }
                if (timeValue.equals("")) { timeValue = "0"; }
                int timeFrmt = Integer.parseInt(timeValue);
                fieldBenefit.setSelectedIndex(-1);
                // Consultar funcion
                benefitList(timeFrmt);
            }
        });
    }
}
