
package com.app.project.views;

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

import com.app.project.entities.EGrease;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;

import com.app.project.Message;
import com.app.project.defaults.DGrease;

public class VGrease {
    private static JTable tblDataInfo;
    private static DefaultTableModel dfltDataModel;
    private static EGrease mdlGrease;

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
    private static JLabel labelDetail;
    private static JLabel labelPrice;
    private static JLabel labelDensity;
    private static JLabel labelOrigin;
    private static JLabel labelState;
    private static JLabel labelCondition;
    private static JLabel labelTemperature;
    private static JLabel labelHumidity;

    // Campos del formulario
    private static JTextField fieldId;
    private static JTextField fieldName;
    private static JTextField fieldDetail;
    private static JTextField fieldPrice;
    private static JTextField fieldDensity;
    private static JTextField fieldOrigin;
    private static JTextField fieldState;
    private static JTextField fieldCondition;
    private static JTextField fieldTemperature;
    private static JTextField fieldHumidity;

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

    // Constructor
    private VGrease() {}

    public static JTabbedPane tabbedPane(DefaultTableModel modelData, EGrease greaseMdl) {
        dfltDataModel = modelData; mdlGrease = greaseMdl;

        // Crear un JTabbedPane
        if (tabbedPane == null) { tabbedPane = new JTabbedPane(); }
        
        // Crear un panel para una pestaña
        if (listPanel == null) { listPanel = new JPanel(new BorderLayout()); }

        // Modelo para el registro de beneficios
        tblDataInfo = new JTable(modelData);
        tblDataInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblDataInfo.setCellSelectionEnabled(false);
        tblDataInfo.setRowSelectionAllowed(true);
        System.out.println("Grasas: Registros:" + " " + dfltDataModel.getRowCount());
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

        labelDetail = new JLabel("Detalle");
        fieldDetail = new JTextField();
        fieldDetail.setEditable(true); // Habilitar el campo

        labelPrice = new JLabel("Precio");
        fieldPrice = new JTextField();
        fieldPrice.setEditable(true); // Habilitar el campo

        labelDensity = new JLabel("Densidad");
        fieldDensity = new JTextField();
        fieldDensity.setEditable(true); // Habilitar el campo

        labelOrigin = new JLabel("Origen");
        fieldOrigin = new JTextField();
        fieldOrigin.setEditable(true); // Habilitar el campo

        labelState = new JLabel("Estado");
        fieldState = new JTextField();
        fieldState.setEditable(true); // Habilitar el campo

        labelCondition = new JLabel("Condicion");
        fieldCondition = new JTextField();
        fieldCondition.setEditable(true); // Habilitar el campo

        labelTemperature = new JLabel("Temperatura");
        fieldTemperature = new JTextField();
        fieldTemperature.setEditable(true); // Habilitar el campo

        labelHumidity = new JLabel("Humedad");
        fieldHumidity = new JTextField();
        fieldHumidity.setEditable(true); // Habilitar el campo

        newField.add(labelId); newField.add(fieldId);
        newField.add(labelName); newField.add(fieldName);
        newField.add(labelDetail); newField.add(fieldDetail);
        newField.add(labelPrice); newField.add(fieldPrice);
        newField.add(labelDensity); newField.add(fieldDensity);
        newField.add(labelOrigin); newField.add(fieldOrigin);
        newField.add(labelState); newField.add(fieldState);
        newField.add(labelCondition); newField.add(fieldCondition);
        newField.add(labelTemperature); newField.add(fieldTemperature);
        newField.add(labelHumidity); newField.add(fieldHumidity);

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
                if (selectedRow >= 0) {
                    isEditing = true; // Modo edición activada
                    editingRowIndex = selectedRow; // Guardar la fila que se está editando
                    // Llenar los campos con los valores seleccionados
                    fieldId.setText((String) tblDataInfo.getValueAt(selectedRow, 0).toString());
                    fieldName.setText((String) tblDataInfo.getValueAt(selectedRow, 1).toString());
                    fieldDetail.setText((String) tblDataInfo.getValueAt(selectedRow, 2).toString());
                    fieldPrice.setText((String) tblDataInfo.getValueAt(selectedRow, 3).toString());
                    fieldDensity.setText((String) tblDataInfo.getValueAt(selectedRow, 4).toString());
                    fieldOrigin.setText((String) tblDataInfo.getValueAt(selectedRow, 5).toString());
                    fieldState.setText((String) tblDataInfo.getValueAt(selectedRow, 6).toString());
                    fieldCondition.setText((String) tblDataInfo.getValueAt(selectedRow, 7).toString());
                    fieldTemperature.setText((String) tblDataInfo.getValueAt(selectedRow, 8).toString());
                    fieldHumidity.setText((String) tblDataInfo.getValueAt(selectedRow, 9).toString());
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
                String valueName = fieldName.getText();
                // Verificar si el valor es o no permitido
                if (!validateList(valueName)) { return; }
                /// Usar el modelo para establecer los valores
                mdlGrease.setName(fieldName.getText());
                mdlGrease.setDetail(fieldDetail.getText());
                mdlGrease.setPrice(Integer.parseInt(fieldPrice.getText()));
                mdlGrease.setDensity(fieldDensity.getText());
                mdlGrease.setOrigin(fieldOrigin.getText());
                mdlGrease.setState(fieldState.getText());
                mdlGrease.setCondition(fieldCondition.getText());
                mdlGrease.setTemperature(Double.parseDouble(fieldTemperature.getText()));
                mdlGrease.setHumidity(Double.parseDouble(fieldHumidity.getText()));

                if (isEditing && editingRowIndex >= 0) {
                    // Actualizar registro existente
                    dfltDataModel.setValueAt(mdlGrease.getName(), editingRowIndex, 1);
                    dfltDataModel.setValueAt(mdlGrease.getDetail(), editingRowIndex, 2);
                    dfltDataModel.setValueAt(mdlGrease.getPrice(), editingRowIndex, 3);
                    dfltDataModel.setValueAt(mdlGrease.getDensity(), editingRowIndex, 4);
                    dfltDataModel.setValueAt(mdlGrease.getOrigin(), editingRowIndex, 5);
                    dfltDataModel.setValueAt(mdlGrease.getState(), editingRowIndex, 6);
                    dfltDataModel.setValueAt(mdlGrease.getCondition(), editingRowIndex, 7);
                    dfltDataModel.setValueAt(mdlGrease.getTemperature(), editingRowIndex, 8);
                    dfltDataModel.setValueAt(mdlGrease.getHumidity(), editingRowIndex, 9);
                } else {
                    // Crear nuevo registro
                    dfltDataModel.addRow(new Object[] {
                        nextId++, // ID autoincrementable
                        mdlGrease.getName(),
                        mdlGrease.getDetail(),
                        mdlGrease.getPrice(),
                        mdlGrease.getDensity(),
                        mdlGrease.getOrigin(),
                        mdlGrease.getState(),
                        mdlGrease.getCondition(),
                        mdlGrease.getTemperature(),
                        mdlGrease.getHumidity(),
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
            "Detalle",
            "Precio",
            "Densidad",
            "Origen",
            "Estado",
            "Condicion",
            "Temperatura",
            "Humedad",
        };
    }

    // Limpiar los campos del formulario
    private static void clearFields() {
        fieldName.setText("");
        fieldDetail.setText("");
        fieldPrice.setText("");
        fieldDensity.setText("");
        fieldOrigin.setText("");
        fieldState.setText("");
        fieldCondition.setText("");
        fieldTemperature.setText("");
        fieldHumidity.setText("");
    }

    public static List<EGrease> getList() {
        List<EGrease> greaseList = new ArrayList<>();
    
        // Recorrer las filas del DefaultTableModel
        for (int row = 0; row < dfltDataModel.getRowCount(); row++) {
            // Obtener valores directamente del modelo
            int id = (int) dfltDataModel.getValueAt(row, 0);
            String name = (String) dfltDataModel.getValueAt(row, 1);
            String detail = (String) dfltDataModel.getValueAt(row, 2);
            int price = (int) dfltDataModel.getValueAt(row, 3);
            String density = (String) dfltDataModel.getValueAt(row, 4);
            String origin = (String) dfltDataModel.getValueAt(row, 5);
            String state = (String) dfltDataModel.getValueAt(row, 6);
            String condition = (String) dfltDataModel.getValueAt(row, 7);
            double temperature = (double) dfltDataModel.getValueAt(row, 8);
            double humidity = (double) dfltDataModel.getValueAt(row, 9);
    
            // Crear una instancia del modelo usando el constructor
            EGrease grease = new EGrease(
                id,
                name,
                detail,
                price,
                density,
                origin,
                state,
                condition,
                temperature,
                humidity
            );
    
            // Agregar el objeto a la lista
            greaseList.add(grease);
        }
    
        return greaseList;
    }

    // Método para validar el valor y mostrar los productos permitidos
    private static boolean validateList(String value) {
        // Convertir el valor ingresado para comparar correctamente
        String valueLower = value.toLowerCase();
    
        // Verificar si el producto es de grasas
        if (!DGrease.isValue(valueLower)) {
            // Obtener la lista de productos permitidos
            List<String> allowedProducts = DGrease.getValue();
            
            // Crear el mensaje con los productos permitidos
            StringBuilder messageBuilder = new StringBuilder();
            messageBuilder.append("Grasa no permitida.\n\n");
            messageBuilder.append("Productos Permitidos:\n\n");
            
            // Comparar todos los productos de la lista en minúsculas
            for (String product : allowedProducts) {
                if (product.toLowerCase().equals(valueLower)) {
                    // Si encuentra una coincidencia, es un producto permitido
                    return true; // No es necesario continuar si el valor es válido
                }
                messageBuilder.append(product).append("\n");
            }
    
            // Mostrar el mensaje en una ventana JOption
            String message = messageBuilder.toString();
            Message.mssgError(message);
            
            // Retornar false si el producto no es permitido
            return false;
        }
        
        // Retornar true si el producto es permitido
        return true;
    }
}
