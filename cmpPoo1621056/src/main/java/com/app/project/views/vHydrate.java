
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

import com.app.project.entities.EHydrate;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;

import com.app.project.Message;
import com.app.project.defaults.DHydrate;

public class VHydrate {
    private static JTable tblDataInfo;
    private static DefaultTableModel dfltDataModel;
    private static EHydrate mdlHydrate;

    // JTabbedPane del internal frame
    private static JTabbedPane tabbedPane;

    // Paneles del internal frame
    private static JPanel listPanel;
    private static JPanel newForm;

    // Campos del formulario
    private static JTextField fieldId;
    private static JTextField fieldName;
    private static JTextField fieldDetail;
    private static JTextField fieldPrice;
    private static JTextField fieldBenefit;
    private static JTextField fieldCalorie;
    private static JTextField fieldNutrient;
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
    private VHydrate() {}

    public static JTabbedPane tabbedPane(DefaultTableModel modelData, EHydrate hydrateMdl) {
        dfltDataModel = modelData; mdlHydrate = hydrateMdl;

        // Crear un JTabbedPane
        if (tabbedPane == null) { tabbedPane = new JTabbedPane(); }
        
        // Crear un panel para una pestaña
        if (listPanel == null) { listPanel = new JPanel(new BorderLayout()); }

        // Modelo para el registro de beneficios
        tblDataInfo = new JTable(modelData);
        tblDataInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblDataInfo.setCellSelectionEnabled(false);
        tblDataInfo.setRowSelectionAllowed(true);
        System.out.println("Hidratos de Carbono: Registros:" + " " + dfltDataModel.getRowCount());
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
        JPanel actionPanel = new JPanel(new GridLayout(1,3));
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
        JPanel newField = new JPanel(new GridLayout(10,2));

        JLabel labelId = new JLabel("Registro");
        fieldId = new JTextField();
        fieldId.setEditable(false); // Bloquear el campo

        JLabel labelName = new JLabel("Nombre");
        fieldName = new JTextField();
        fieldName.setEditable(true); // Habilitar el campo

        JLabel labelDetail = new JLabel("Detalle");
        fieldDetail = new JTextField();
        fieldDetail.setEditable(true); // Habilitar el campo

        JLabel labelPrice = new JLabel("Precio");
        fieldPrice = new JTextField();
        fieldPrice.setEditable(true); // Habilitar el campo

        JLabel labelBenefit = new JLabel("Beneficio");
        fieldBenefit = new JTextField();
        fieldBenefit.setEditable(true); // Habilitar el campo

        JLabel labelCalorie = new JLabel("Caloria");
        fieldCalorie = new JTextField();
        fieldCalorie.setEditable(true); // Habilitar el campo

        JLabel labelNutrient = new JLabel("Nutriente");
        fieldNutrient = new JTextField();
        fieldNutrient.setEditable(true); // Habilitar el campo

        JLabel labelCondition = new JLabel("Condicion");
        fieldCondition = new JTextField();
        fieldCondition.setEditable(true); // Habilitar el campo

        JLabel labelTemperature = new JLabel("Temperatura");
        fieldTemperature = new JTextField();
        fieldTemperature.setEditable(true); // Habilitar el campo

        JLabel labelHumidity = new JLabel("Humedad");
        fieldHumidity = new JTextField();
        fieldHumidity.setEditable(true); // Habilitar el campo

        newField.add(labelId); newField.add(fieldId);
        newField.add(labelName); newField.add(fieldName);
        newField.add(labelDetail); newField.add(fieldDetail);
        newField.add(labelPrice); newField.add(fieldPrice);
        newField.add(labelBenefit); newField.add(fieldBenefit);
        newField.add(labelCalorie); newField.add(fieldCalorie);
        newField.add(labelNutrient); newField.add(fieldNutrient);
        newField.add(labelCondition); newField.add(fieldCondition);
        newField.add(labelTemperature); newField.add(fieldTemperature);
        newField.add(labelHumidity); newField.add(fieldHumidity);

        // Crear un panel para añadir botones de acciones
        JPanel newAction = new JPanel(new GridLayout(1,1));

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
                    fieldBenefit.setText((String) tblDataInfo.getValueAt(selectedRow, 4).toString());
                    fieldCalorie.setText((String) tblDataInfo.getValueAt(selectedRow, 5).toString());
                    fieldNutrient.setText((String) tblDataInfo.getValueAt(selectedRow, 6).toString());
                    fieldTemperature.setText((String) tblDataInfo.getValueAt(selectedRow, 7).toString());
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
                mdlHydrate.setName(fieldName.getText());
                mdlHydrate.setDetail(fieldDetail.getText());
                mdlHydrate.setPrice(Integer.parseInt(fieldPrice.getText()));
                mdlHydrate.setBenefit(fieldBenefit.getText());
                mdlHydrate.setCalorie(fieldCalorie.getText());
                mdlHydrate.setNutrient(fieldNutrient.getText());
                mdlHydrate.setCondition(fieldCondition.getText());
                mdlHydrate.setTemperature(Double.parseDouble(fieldTemperature.getText()));
                mdlHydrate.setHumidity(Double.parseDouble(fieldHumidity.getText()));

                if (isEditing && editingRowIndex >= 0) {
                    // Actualizar registro existente
                    dfltDataModel.setValueAt(mdlHydrate.getName(), editingRowIndex, 1);
                    dfltDataModel.setValueAt(mdlHydrate.getDetail(), editingRowIndex, 2);
                    dfltDataModel.setValueAt(mdlHydrate.getPrice(), editingRowIndex, 3);
                    dfltDataModel.setValueAt(mdlHydrate.getBenefit(), editingRowIndex, 4);
                    dfltDataModel.setValueAt(mdlHydrate.getCalorie(), editingRowIndex, 5);
                    dfltDataModel.setValueAt(mdlHydrate.getNutrient(), editingRowIndex, 6);
                    dfltDataModel.setValueAt(mdlHydrate.getCondition(), editingRowIndex, 7);
                    dfltDataModel.setValueAt(mdlHydrate.getTemperature(), editingRowIndex, 8);
                    dfltDataModel.setValueAt(mdlHydrate.getHumidity(), editingRowIndex, 9);
                } else {
                    // Crear nuevo registro
                    dfltDataModel.addRow(new Object[] {
                        nextId++, // ID autoincrementable
                        mdlHydrate.getName(),
                        mdlHydrate.getDetail(),
                        mdlHydrate.getPrice(),
                        mdlHydrate.getBenefit(),
                        mdlHydrate.getCalorie(),
                        mdlHydrate.getNutrient(),
                        mdlHydrate.getCondition(),
                        mdlHydrate.getTemperature(),
                        mdlHydrate.getHumidity(),
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
            "Beneficio",
            "Caloria",
            "Nutriente",
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
        fieldBenefit.setText("");
        fieldCalorie.setText("");
        fieldNutrient.setText("");
        fieldCondition.setText("");
        fieldTemperature.setText("");
        fieldHumidity.setText("");
    }

    public static List<EHydrate> getList() {
        List<EHydrate> hydrateList = new ArrayList<>();
    
        // Recorrer las filas del DefaultTableModel
        for (int row = 0; row < dfltDataModel.getRowCount(); row++) {
            // Obtener valores directamente del modelo
            int id = (int) dfltDataModel.getValueAt(row, 0);
            String name = (String) dfltDataModel.getValueAt(row, 1);
            String detail = (String) dfltDataModel.getValueAt(row, 2);
            int price = (int) dfltDataModel.getValueAt(row, 3);
            String benefit = (String) dfltDataModel.getValueAt(row, 4);
            String calorie = (String) dfltDataModel.getValueAt(row, 5);
            String nutrient = (String) dfltDataModel.getValueAt(row, 6);
            String condition = (String) dfltDataModel.getValueAt(row, 7);
            double temperature = (double) dfltDataModel.getValueAt(row, 8);
            double humidity = (double) dfltDataModel.getValueAt(row, 9);
    
            // Crear una instancia del modelo usando el constructor
            EHydrate hydrate = new EHydrate(
                id,
                name,
                detail,
                price,
                benefit,
                calorie,
                nutrient,
                condition,
                temperature,
                humidity
            );
    
            // Agregar el objeto a la lista
            hydrateList.add(hydrate);
        }
    
        return hydrateList;
    }

    // Método para validar el valor y mostrar los productos permitidos
    private static boolean validateList(String value) {
        // Convertir el valor ingresado para comparar correctamente
        String valueLower = value.toLowerCase();
    
        // Verificar si el producto es de grasas
        if (!DHydrate.isValue(valueLower)) {
            // Obtener la lista de productos permitidos
            List<String> allowedProducts = DHydrate.getValue();
            
            // Crear el mensaje con los productos permitidos
            StringBuilder messageBuilder = new StringBuilder();
            messageBuilder.append("Hidrado de carbono no permitido.\n\n");
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
