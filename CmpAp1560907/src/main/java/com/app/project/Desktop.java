/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import com.app.project.view.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import com.app.project.model.mBenefit;
import com.app.project.model.mEmployee;
import com.app.project.model.mProdType;
import com.app.project.model.mProduct;
import com.app.project.model.mWorking;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adiso
 */
public class Desktop {

    // Mantener una referencia al JInternalFrame
    private static JInternalFrame dataFrame;
    // Mantener una referencia al JTabbedPane
    private static JTabbedPane tabbedPane;

    // Datos para el modelo de beneficios
    private static mBenefit benefitModel;
    private static DefaultTableModel dfltBenefit;

    // Datos para el modelo de beneficios
    private static mEmployee employeeModel;
    private static DefaultTableModel dfltEmployee;

    // Datos para el modelo de beneficios
    private static mProdType prodTypeModel;
    private static DefaultTableModel dfltProdType;

    // Datos para el modelo de beneficios
    private static mProduct productModel;
    private static DefaultTableModel dfltProduct;

    // Datos para el modelo de beneficios
    private static mWorking workingModel;
    private static DefaultTableModel dfltWorking;

    // Botones para llamar internal frame
    private static JButton btnBenefit;
    private static JButton btnEmployee;
    private static JButton btnProduct;
    private static JButton btnProdType;
    private static JButton btnWorking;

    // Titulos para el interna frame principal
    private static JLabel labelTitle;
    private static JLabel labelDevelop;
    private static JLabel labelWebMain;

    public static void openInternal(JDesktopPane desktopPane) {
        // Crear solo si no existe
        if (dataFrame == null || !dataFrame.isVisible()) {
            // Crear un JInternalFrame para contener los botones
            dataFrame = new JInternalFrame(
                "",
                false, // No redimensionar
                false, // No cerrar
                false, // No maximizar
                false  // Minimizar
            );

            internalSize(dataFrame, desktopPane);
            disableComponent(dataFrame, desktopPane);
            disableInternal(dataFrame);

            // Establecer el layout & centrar los componentes
            dataFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

            // Cambiar el layout a BoxLayout en el eje Y
            dataFrame.setLayout(new BoxLayout(dataFrame.getContentPane(), BoxLayout.Y_AXIS));

            titleWelcome();
            // Añadir espacio entre títulos
            dataFrame.add(Box.createVerticalStrut(60));
            buttonAction();
            // Añadir espacio entre el segundo título y los botones
            dataFrame.add(Box.createVerticalStrut(60));
            titleDevelop();
            // Añadir espacio entre el segundo título y los botones
            dataFrame.add(Box.createVerticalStrut(10));
            titleWebPage();

            // Hacer visible el JInternalFrame
            dataFrame.setVisible(true);
            dataFrame.moveToFront();

            // Añadir el JInternalFrame al JDesktopPane
            desktopPane.add(dataFrame);
            // Forzar revalidación del desktopPane
            desktopPane.revalidate();
            // Forzar repaint del desktopPane
            desktopPane.repaint();

            actBenefit(desktopPane);
            actEmployee(desktopPane);
            actProduct(desktopPane);
            actProdType(desktopPane);
            actWorking(desktopPane);

            // Imprimir los datos del modelo
            printDefaultData(dfltBenefit);
            printDefaultData(dfltEmployee);
            printDefaultData(dfltProdType);
            printDefaultData(dfltProduct);
            printDefaultData(dfltWorking);
            
            // Imprimir los datos del modelo
            //printModelData(benefitModel);
            //printModelData(employeeModel);
            //printModelData(prodTypeModel);
            //printModelData(productModel);
            //printModelData(workingModel);
        }
    }

    public static void buttonAction() {
        // Crear y añadir botones al internal frame
        btnBenefit = addButtons("Beneficios");
        btnEmployee = addButtons("Empleados");
        btnProduct = addButtons("Productos");
        btnProdType = addButtons("Tipos de Productos");
        btnWorking = addButtons("Jornadas");

        // Centrar botones al internal frame
        btnBenefit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEmployee.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProduct.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProdType.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnWorking.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir los botones
        dataFrame.add(btnBenefit);
        // Espacio entre los botones
        dataFrame.add(Box.createVerticalStrut(10));
        dataFrame.add(btnEmployee);
        // Espacio entre los botones
        dataFrame.add(Box.createVerticalStrut(10));
        dataFrame.add(btnProduct);
        // Espacio entre los botones
        dataFrame.add(Box.createVerticalStrut(10));
        dataFrame.add(btnProdType);
        // Espacio entre los botones
        dataFrame.add(Box.createVerticalStrut(10));
        dataFrame.add(btnWorking);
    }

    public static void titleWelcome() {
        // Crear y añadir el label para el título principal
        labelTitle = new JLabel("Bienvenidos", SwingConstants.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 15));
        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataFrame.add(labelTitle);
    }

    public static void titleDevelop() {
        // Crear y añadir el label para el título desarrollador
        labelDevelop = new JLabel("Desarrollador Por Adison Jimenez", SwingConstants.CENTER);
        labelDevelop.setFont(new Font("Arial", Font.BOLD, 12));
        labelDevelop.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataFrame.add(labelDevelop); 
    }

    public static void titleWebPage() {
        // Crear y añadir el label para el título de pagina web
        labelWebMain = new JLabel("www.adisonjimenez.net | www.engsoft.app", SwingConstants.CENTER);
        labelWebMain.setFont(new Font("Arial", Font.BOLD, 12));
        labelWebMain.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataFrame.add(labelWebMain);
    }

    public static void actBenefit(JDesktopPane desktopPane) {
        btnBenefit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Beneficios",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());

                // Verificar si el modelo ya existe, si no, inicializarlo
                 if (benefitModel == null) {
                    benefitModel = new mBenefit();
                    String[] columns = vBenefit.tableColumn();
                    dfltBenefit = new DefaultTableModel(columns, 0);
                }

                // Añadir el JTabbedPane con el modelo existente
                tabbedPane = vBenefit.tabbedPane(dfltBenefit, benefitModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void actEmployee(JDesktopPane desktopPane) {
        btnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Empleados",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());

                // Verificar si el modelo ya existe, si no, inicializarlo
                 if (employeeModel == null) {
                    employeeModel = new mEmployee();
                    String[] columns = vEmployee.tableColumn();
                    dfltEmployee = new DefaultTableModel(columns, 0);
                }

                // Añadir el JTabbedPane con el modelo existente
                tabbedPane = vEmployee.tabbedPane(dfltEmployee, employeeModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void actProdType(JDesktopPane desktopPane) {
        btnProdType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Tipos",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());

                // Verificar si el modelo ya existe, si no, inicializarlo
                 if (prodTypeModel == null) {
                    prodTypeModel = new mProdType();
                    String[] columns = vProdType.tableColumn();
                    dfltProdType = new DefaultTableModel(columns, 0);
                }

                // Añadir el JTabbedPane con el modelo existente
                tabbedPane = vProdType.tabbedPane(dfltProdType, prodTypeModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void actProduct(JDesktopPane desktopPane) {
        btnProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Productos",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());

                // Verificar si el modelo ya existe, si no, inicializarlo
                 if (productModel == null) {
                    productModel = new mProduct();
                    String[] columns = vProduct.tableColumn();
                    dfltProduct = new DefaultTableModel(columns, 0);
                }

                // Añadir el JTabbedPane con el modelo existente
                tabbedPane = vProduct.tabbedPane(dfltProduct, productModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void actWorking(JDesktopPane desktopPane) {
        btnWorking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Jornadas",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());

                // Verificar si el modelo ya existe, si no, inicializarlo
                 if (workingModel == null) {
                    workingModel = new mWorking();
                    String[] columns = vWorking.tableColumn();
                    dfltWorking = new DefaultTableModel(columns, 0);
                }

                // Añadir el JTabbedPane con el modelo existente
                tabbedPane = vWorking.tabbedPane(dfltWorking, workingModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void internalSize(
        JInternalFrame intFrame,
        JDesktopPane desktopPane
    ) {
        // Calcular el tamaño del internal frame como un porcentaje del JDesktopPane
        int frameWidth = (int) (desktopPane.getWidth() * 0.5);
        int frameHeight = (int) (desktopPane.getHeight() * 0.5);
        intFrame.setSize(frameWidth, frameHeight);

        // Calcular la posición centrada
        int x = (desktopPane.getWidth() - frameWidth) / 2;
        int y = (desktopPane.getHeight() - frameHeight) / 2;
        intFrame.setLocation(x, y);
    }

    public static JButton addButtons(String title) {
        JButton dtButton = new JButton(title);
        dtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ejecutar función
            }
        });
        // Devolver el botón creado
        return dtButton;
    }

    private static void disableComponent(
        JInternalFrame intFrame,
        JDesktopPane desktopPane
    ) {
        // Obtener el tamaño actual del JInternalFrame
        int frameWidth = intFrame.getWidth();
        int frameHeight = intFrame.getHeight();
    
        // Calcular la posición centrada
        int x = (desktopPane.getWidth() - frameWidth) / 2;
        int y = (desktopPane.getHeight() - frameHeight) / 2;
    
        // Deshabilitar el movimiento del JInternalFrame
        intFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                // Restablecer la posición
                intFrame.setLocation(x, y);
            }
        });
    }

    private static void disableInternal(JInternalFrame frame) {
        // Quitar el borde del iframe
        //frame.setBorder(BorderFactory.createEmptyBorder());

        // Evitar que se mueva el internal frame
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Cancelar el movimiento
                frame.setLocation(0, 0);
            }
        });

        frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Cancelar el movimiento
                frame.setLocation(0, 0);
            }
        });

        // Añadir un MouseListener que ignore los eventos de movimiento
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Cancelar el movimiento
                // Mantener la posición actual
                frame.setLocation(frame.getX(), frame.getY());
            }
        });

        frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Cancelar el movimiento
                // Mantener la posición actual
                frame.setLocation(frame.getX(), frame.getY());
            }
        });
    }

    public static void printDefaultData(DefaultTableModel model) {
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        
        System.out.println("Datos del modelo:");
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                System.out.print(model.getValueAt(row, col) + "\t");
            }
            // Salto de línea al final de cada fila
            System.out.println();
        }
    }

    public static void printModelData(mEmployee dataMdl) {
        // Suponiendo que el objeto `mEmployee` tiene métodos `get` para acceder a sus datos
        System.out.println("Datos del objeto mEmployee:");
        System.out.println("Registro: " + dataMdl.getId());
    }
}
