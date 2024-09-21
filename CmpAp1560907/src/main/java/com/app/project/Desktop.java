/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author adiso
 */
public class Desktop {

    public static void openInternal(JDesktopPane desktopPane) {
        // Crear un JInternalFrame para contener los botones
        JInternalFrame intFrame = new JInternalFrame(
            "Tablero de Control",
            false, // Redimensionar
            false, // Cerrar
            false, // Maximizar
            true // Minimizar
        );

        // Hacer visible el JInternalFrame
        intFrame.setVisible(true);
        // Establecer el layout
        intFrame.setLayout(new FlowLayout());
        // Colocar en la esquina superior izquierda
        intFrame.setLocation(0, 0);
        // Asegurar que el internal frame esté al frente
        intFrame.moveToFront();
        // Ajustar el tamaño del JInternalFrame al tamaño del desktopPane
        intFrame.setSize(desktopPane.getWidth(), desktopPane.getHeight());

        // Deshabilitar Movimientos
        disableInternal(intFrame);

        // Crear y añadir botones al JInternalFrame
        JButton btnEmployee = addButtons("Empleados");
        JButton btnProduct = addButtons("Productos");

        intFrame.add(btnEmployee);
        intFrame.add(btnProduct);

        // Añadir el JInternalFrame al JDesktopPane
        desktopPane.add(intFrame);
        // Forzar revalidación del desktopPane
        desktopPane.revalidate();
        // Forzar repaint del desktopPane
        desktopPane.repaint();
    }

    public static JButton addButtons(String title) {
        JButton dtButton = new JButton(title);
        dtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ejecutar función
            }
        });
        return dtButton; // Asegúrate de devolver el botón creado
    }

    public static void mainButtons(JDesktopPane desktopPane) {

        //openInternal(desktopPane);

        // Crear un JInternalFrame para contener los botones
        /*JInternalFrame buttonFrame = new JInternalFrame(
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
        desktopPane.repaint();*/
    }

    private static void openInternalFrame(String title, String content, JDesktopPane desktopPane) {
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
