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

    public static void openInternal(JDesktopPane desktopPane) {
        // Crear un JInternalFrame para contener los botones
        JInternalFrame intFrame = new JInternalFrame(
            "",
            false, // No redimensionar
            false, // No cerrar
            false, // No maximizar
            false  // Minimizar
        );

        internalSize(intFrame, desktopPane);
        disableComponent(intFrame, desktopPane);
        disableInternal(intFrame);

        // Establecer el layout & centrar los componentes
        intFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Cambiar el layout a BoxLayout en el eje Y
        intFrame.setLayout(new BoxLayout(intFrame.getContentPane(), BoxLayout.Y_AXIS));

        // Crear y añadir el primer JLabel para el primer título
        JLabel labelTitle = new JLabel("Bienvenidos", SwingConstants.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 15)); // Cambiar la fuente si es necesario
        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JLabel
        intFrame.add(labelTitle); // Añadir el JLabel al JInternalFrame

        // Añadir espacio entre títulos
        intFrame.add(Box.createVerticalStrut(60));

        // Crear y añadir botones al JInternalFrame
        JButton btnBenefit = addButtons("Beneficios");
        JButton btnEmployee = addButtons("Empleados");
        JButton btnProduct = addButtons("Productos");
        JButton btnProdType = addButtons("Tipos de Productos");
        JButton btnWorking = addButtons("Jornadas");

        btnBenefit.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón
        btnEmployee.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón
        btnProduct.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón
        btnProdType.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón
        btnWorking.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón

        // Añadir los botones
        intFrame.add(btnBenefit);
        intFrame.add(Box.createVerticalStrut(10)); // Espacio entre los botones
        intFrame.add(btnEmployee);
        intFrame.add(Box.createVerticalStrut(10)); // Espacio entre los botones
        intFrame.add(btnProduct);
        intFrame.add(Box.createVerticalStrut(10)); // Espacio entre los botones
        intFrame.add(btnProdType);
        intFrame.add(Box.createVerticalStrut(10)); // Espacio entre los botones
        intFrame.add(btnWorking);

        // Añadir evento al botón "Empleados"
        btnEmployee.addActionListener(new ActionListener() {
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

                // Obtener el JTabbedPane desde Benefit
                JTabbedPane tabbedPane = (JTabbedPane) Benefit.tabbedPane();

                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);

                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);

                // Añadir el nuevo JInternalFrame al JDesktopPane
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });

        // Añadir evento al botón "Empleados"
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

                // Obtener el JTabbedPane desde Employee
                JTabbedPane tabbedPane = (JTabbedPane) Employee.tabbedPane();

                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);

                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);

                // Añadir el nuevo JInternalFrame al JDesktopPane
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });

        // Añadir espacio entre el segundo título y los botones
        intFrame.add(Box.createVerticalStrut(60));

        // Crear y añadir un segundo JLabel para el segundo título
        JLabel labelDevelop = new JLabel("Desarrollador Por Adison Jimenez", SwingConstants.CENTER);
        labelDevelop.setFont(new Font("Arial", Font.BOLD, 12)); // Cambiar la fuente si es necesario
        labelDevelop.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JLabel
        intFrame.add(labelDevelop); // Añadir el JLabel al JInternalFrame

        // Añadir espacio entre el segundo título y los botones
        intFrame.add(Box.createVerticalStrut(10));

        // Crear y añadir un segundo JLabel para el segundo título
        JLabel labelWebMain = new JLabel("www.adisonjimenez.net | www.engsoft.app", SwingConstants.CENTER);
        labelWebMain.setFont(new Font("Arial", Font.BOLD, 12)); // Cambiar la fuente si es necesario
        labelWebMain.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JLabel
        intFrame.add(labelWebMain); // Añadir el JLabel al JInternalFrame

        // Hacer visible el JInternalFrame
        intFrame.setVisible(true);
        intFrame.moveToFront();

        // Añadir el JInternalFrame al JDesktopPane
        desktopPane.add(intFrame);
        // Forzar revalidación del desktopPane
        desktopPane.revalidate();
        // Forzar repaint del desktopPane
        desktopPane.repaint();
    }

    public static void internalSize(
        JInternalFrame intFrame,
        JDesktopPane desktopPane
    ) {
        // Calcular el tamaño del JInternalFrame como un porcentaje del JDesktopPane
        int frameWidth = (int) (desktopPane.getWidth() * 0.5);  // 60% del ancho
        int frameHeight = (int) (desktopPane.getHeight() * 0.5); // 30% de la altura
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

    /*public static void openTab(JDesktopPane desktopPane) {
        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregar una pestaña al JTabbedPane
        tabbedPane.addTab("Tablero", new JLabel("Contenido del Tablero"));

        // Limpiar el layout del desktopPane y asegurarte que sea un BorderLayout
        desktopPane.setLayout(new BorderLayout());

        // Añadir el JTabbedPane al JDesktopPane en el centro
        desktopPane.add(tabbedPane, BorderLayout.CENTER);

        // Forzar revalidación y repaint
        desktopPane.revalidate();
        desktopPane.repaint();
    }*/

    /*private static void frameInternal(String title, String content, JDesktopPane desktopPane) {
        // Crear un JInternalFrame
        JInternalFrame internalFrame = new JInternalFrame(
            title,
            false,
            true,
            false,
            true);
        internalFrame.setSize(300, 200);
        internalFrame.setLayout(new BorderLayout());
        internalFrame.add(new JLabel(content, SwingConstants.CENTER), BorderLayout.CENTER);
        
        // Ajustar la posición inicial
        internalFrame.setLocation(50, 50);
        internalFrame.setVisible(true);
        
        // Añadir el JInternalFrame al JDesktopPane
        desktopPane.add(internalFrame);
        // Asegurar que el internal frame esté al frente
        internalFrame.moveToFront();
    }*/

    /*public static void mainButtons(JDesktopPane desktopPane) {
        //openInternal(desktopPane);

        // Crear un JInternalFrame para contener los botones
        JInternalFrame buttonFrame = new JInternalFrame(
            "Tablero de Control",
            false, // No redimensionar
            false, // No cerrar
            false, // No maximizar
            true   // Minimizar
        );
        
        // Establecer el layout
        buttonFrame.setLayout(new FlowLayout());
        
        // Crear los botones
        JButton empleadosButton = new JButton("Empleados");
        JButton productosButton = new JButton("Productos");

        // Añadir acción a los botones
        empleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInternalFrame("Empleados", "Contenido de Empleados", desktopPane);
            }
        });

        productosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInternalFrame("Productos", "Contenido de Productos", desktopPane);
            }
        });

        // Hacer visible el JInternalFrame
        buttonFrame.setVisible(true);

        // Añadir botones al JInternalFrame
        buttonFrame.add(empleadosButton);
        buttonFrame.add(productosButton);

        // Ajustar el tamaño del JInternalFrame al tamaño del desktopPane
        buttonFrame.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        // Colocar en la esquina superior izquierda
        buttonFrame.setLocation(0, 0);

        // Deshabilitar Movimientos
        disableInternal(buttonFrame);

        // Añadir el JInternalFrame al JDesktopPane
        desktopPane.add(buttonFrame);
        // Forzar revalidación del desktopPane
        desktopPane.revalidate();
        // Forzar repaint del desktopPane
        desktopPane.repaint();
    }*/
}
