/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
public class Compensar extends JFrame {
    private JTable empleadosTable, productosTable;
    private DefaultTableModel empleadosModel, productosModel;
    
    /*public static void main(String[] args) {
        new Compensar().setVisible(true);
    }*/
    
    public static void test() {
        new Compensar().setVisible(true);
    }
    
    public Compensar() {
        setTitle("Tienda Compensar");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Panel para el registro de empleados
        JPanel empleadosPanel = new JPanel(new BorderLayout());
        String [] empleadosColumnas = {"Nombres", "Identificacion", "Edad", "Jornada", "Tiempo en Compensar", "Beneficios"};
        // Modelo para el registro de empleados
        empleadosModel = new DefaultTableModel(empleadosColumnas, 0);
        empleadosTable = new JTable(empleadosModel);
        empleadosPanel.add(new JScrollPane(empleadosTable), BorderLayout.CENTER);
        
        // Formulario de empleados
        JPanel empleadosForm = new JPanel(new GridLayout(7,2));
        // Campos del formulario
        JLabel nombreLabel = new JLabel("Nombre");
        JTextField nombreField = new JTextField();
        // Campos del formulario
        JLabel idLabel = new JLabel("Identificacion");
        JTextField idField = new JTextField();
        // Campos del formulario
        JLabel edadLabel = new JLabel("Edad");
        JTextField edadField = new JTextField();
        // Campos del formulario
        JLabel jornadaLabel = new JLabel("Jornada");
        JComboBox<String> jornadaBox = new JComboBox<>(new String[]{"Diurno","Nocturno"});
        // Campos del formulario
        JLabel tiempoLabel = new JLabel("Tiempo en Compensar");
        JTextField tiempoField = new JTextField();
        // Botones del formulario
        JButton addEmpleadoButton = new JButton("Agregar Empleado");
        JButton editEmpleadoButton = new JButton("Editar Empleado");
        JButton deleteEmpleadoButton = new JButton("Eliminar Empleado");
        
        // Añadir Empleados
        addEmpleadoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String id = idField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String jornada = (String) jornadaBox.getSelectedItem();
                int tiempo = Integer.parseInt(tiempoField.getText());
                String beneficios = calcularBeneficios(tiempo);
                
                empleadosModel.addRow(new Object[]{nombre,id,edad,jornada,tiempo,beneficios});
            }
        });
        
        // Editar Empleados
        editEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = empleadosTable.getSelectedRow();
                if (selectedRow != -1) {
                    empleadosModel.setValueAt(nombreField.getText(), selectedRow,0);
                    empleadosModel.setValueAt(idField.getText(), selectedRow,1);
                    empleadosModel.setValueAt(Integer.parseInt(edadField.getText()), selectedRow,2);
                    empleadosModel.setValueAt(jornadaBox.getSelectedItem(), selectedRow,3);
                    empleadosModel.setValueAt(Integer.parseInt(tiempoField.getText()), selectedRow,4);
                    empleadosModel.setValueAt(calcularBeneficios(Integer.parseInt(tiempoField.getText())), selectedRow,5);
                }
            }
        });
        
        // Eliminar Empleados
        deleteEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = empleadosTable.getSelectedRow();
                if (selectedRow != -1) {
                    empleadosModel.removeRow(selectedRow);
                }
            }
        });
        
        empleadosForm.add(nombreLabel);
        empleadosForm.add(nombreField);
        
        empleadosForm.add(idLabel);
        empleadosForm.add(idField);
        
        empleadosForm.add(edadLabel);
        empleadosForm.add(edadField);
        
        empleadosForm.add(jornadaLabel);
        empleadosForm.add(jornadaBox);
        
        empleadosForm.add(tiempoLabel);
        empleadosForm.add(tiempoField);
        
        empleadosForm.add(addEmpleadoButton);
        empleadosForm.add(addEmpleadoButton);
        
        empleadosForm.add(editEmpleadoButton);
        empleadosForm.add(editEmpleadoButton);
        
        empleadosForm.add(deleteEmpleadoButton);
        empleadosForm.add(deleteEmpleadoButton);
        
        empleadosPanel.add(empleadosForm, BorderLayout.SOUTH);
        
        
        
        // Panel para el registro de productos
        JPanel productosPanel = new JPanel(new BorderLayout());
        String [] productosColumnas = {"Nombre", "Tipo", "Unidad", "Valor Unitario", "IVA", "Valor Total"};
        // Modelo para el registro de empleados
        productosModel = new DefaultTableModel(productosColumnas, 0);
        productosTable = new JTable(productosModel);
        productosPanel.add(new JScrollPane(productosTable), BorderLayout.CENTER);
        
        // Formulario de productos
        JPanel productosForm = new JPanel(new GridLayout(7,2));
        // Campos del formulario
        JLabel prdNombreLabel = new JLabel("Nombre");
        JTextField prdNombreField = new JTextField();
        // Campos del formulario
        JLabel prdTipoLabel = new JLabel("Tipo de Producto");
        JComboBox<String> prdTipoBox = new JComboBox<>(new String[]{"Aseo","Papeleria","Viveres","Mascotas","Otros"});
        // Campos del formulario
        JLabel prdUnidaddesLabel = new JLabel("Unidades");
        JTextField prdUnidaddesField = new JTextField();
        // Campos del formulario
        JLabel prdUnitarioLabel = new JLabel("Valor Unitario");
        JTextField prdUnitarioField = new JTextField();
        // Botones del formulario
        JButton addProductoButton = new JButton("Agregar Producto");
        JButton editProductoButton = new JButton("Editar Producto");
        JButton deleteProductoButton = new JButton("Eliminar Producto");
        
        // Añadir Productos
        addProductoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = prdNombreField.getText();
                String tipo = (String) prdTipoBox.getSelectedItem();
                int unidad = Integer.parseInt(prdUnidaddesField.getText());
                double unitario = Double.parseDouble(prdUnitarioField.getText());
                double iva = calcularIVA(tipo);
                double total = unidad * unitario * (1 + iva);
                
                productosModel.addRow(new Object[]{nombre,tipo,unidad,unitario,iva * 100 + "%", total});
            }
        });
        
        // Añadir Productos
        editProductoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productosTable.getSelectedRow();
                if (selectedRow != -1) {
                    productosModel.setValueAt(prdNombreField.getText(), selectedRow,0);
                    productosModel.setValueAt(prdTipoBox.getSelectedItem(), selectedRow,1);
                    productosModel.setValueAt(Integer.parseInt(prdUnidaddesField.getText()), selectedRow,2);
                    productosModel.setValueAt(Double.parseDouble(prdUnitarioField.getText()), selectedRow,3);
                    double iva = calcularIVA((String)prdTipoBox.getSelectedItem());
                    double total = Integer.parseInt(prdUnidaddesField.getText()) * Double.parseDouble(prdUnitarioField.getText()) * iva;
                    productosModel.setValueAt(iva * 100 + "%", selectedRow,4);
                    productosModel.setValueAt(total, selectedRow,5);
                }
            }
        });
        
        // Eliminar Productos
        deleteProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productosTable.getSelectedRow();
                if (selectedRow != -1) {
                    productosModel.removeRow(selectedRow);
                }
            }
        });
        
        productosForm.add(prdNombreLabel);
        productosForm.add(prdNombreField);
        
        productosForm.add(prdTipoLabel);
        productosForm.add(prdTipoBox);
        
        productosForm.add(prdUnidaddesLabel);
        productosForm.add(prdUnidaddesField);
        
        productosForm.add(prdUnitarioLabel);
        productosForm.add(prdUnitarioField);
        
        productosForm.add(addProductoButton);
        productosForm.add(addProductoButton);
        
        productosForm.add(editProductoButton);
        productosForm.add(editProductoButton);
        
        productosForm.add(deleteProductoButton);
        productosForm.add(deleteProductoButton);
        
        productosPanel.add(productosForm, BorderLayout.SOUTH);
        
        // Agregar paneles al tabbed pane
        tabbedPane.addTab("Registro Empleados", empleadosPanel);
        tabbedPane.addTab("Registro Productos", productosPanel);
        add(tabbedPane);
    }
    
    private String calcularBeneficios(int tiempo) {
        if (tiempo < 1) {
            return "15% descuento en tienda, 20% en centros recreacionales";
        } else if (tiempo <= 5) {
            return "30% descuento en tienda, 30% en centros recreacionales";
        } else {
            return "50% descuento en tienda, 60% en centros recreacionales";
        }
    }
    
    private double calcularIVA(String tipo) {
        switch (tipo.toLowerCase()) {
            case "aseo": return 0.19;
            case "papeleria": return 0.09;
            case "viveres": return 0.15;
            case "mascotas": return 0.16;
            default: return 0.10;
        }
    }
}
