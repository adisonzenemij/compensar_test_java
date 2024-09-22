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

/**
 *
 * @author adiso
 */
public class Desktop {

    // Mantener una referencia al JInternalFrame
    private static JInternalFrame dataFrame;
    // Mantener una referencia al JTabbedPane
    private static JTabbedPane tabbedPane;

    private static JButton btnBenefit;
    private static JButton btnEmployee;
    private static JButton btnProduct;
    private static JButton btnProdType;
    private static JButton btnWorking;

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
        labelDevelop.setFont(new Font("Arial", Font.BOLD, 12)); // Cambiar la fuente si es necesario
        labelDevelop.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JLabel
        dataFrame.add(labelDevelop); // Añadir el label al JInternalFrame
    }

    public static void titleWebPage() {
        // Crear y añadir el label para el título de pagina web
        labelWebMain = new JLabel("www.adisonjimenez.net | www.engsoft.app", SwingConstants.CENTER);
        labelWebMain.setFont(new Font("Arial", Font.BOLD, 12)); // Cambiar la fuente si es necesario
        labelWebMain.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JLabel
        dataFrame.add(labelWebMain); // Añadir el label al JInternalFrame
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
                dataFrame.setSize(600, 400);
                dataFrame.setLayout(new BorderLayout());

                // Obtener el JTabbedPane desde vBenefit
                JTabbedPane tabbedPane = (JTabbedPane) vBenefit.tabbedPane();

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
                dataFrame.setSize(600, 400);
                dataFrame.setLayout(new BorderLayout());

                // Obtener el JTabbedPane desde vEmployee
                JTabbedPane tabbedPane = (JTabbedPane) vEmployee.tabbedPane();

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
}
