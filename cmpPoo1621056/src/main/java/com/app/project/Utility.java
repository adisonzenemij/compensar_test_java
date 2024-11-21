
package com.app.project;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

public class Utility {
    // Constructor
    private Utility() {}
    
    public static void internalSize(
        JDesktopPane paneDesktop,
        JInternalFrame frameInternal
    ) {
        // Calcular el tamaño del internal frame como un porcentaje del JDesktopPane
        int frameWidth = (int) (paneDesktop.getWidth() * 0.5);
        int frameHeight = (int) (paneDesktop.getHeight() * 0.5);
        frameInternal.setSize(frameWidth, frameHeight);

        // Calcular la posición centrada
        int x = (paneDesktop.getWidth() - frameWidth) / 2;
        int y = (paneDesktop.getHeight() - frameHeight) / 2;
        frameInternal.setLocation(x, y);
    }

    public static JButton addButtons(String title) {
        // Devolver el botón creado
        return new JButton(title);
    }

    public static void disableComponent(
        JDesktopPane paneDesktop,
        JInternalFrame frameInternal
    ) {
        // Obtener el tamaño actual del JInternalFrame
        int frameWidth = frameInternal.getWidth();
        int frameHeight = frameInternal.getHeight();
    
        // Calcular la posición centrada
        int x = (paneDesktop.getWidth() - frameWidth) / 2;
        int y = (paneDesktop.getHeight() - frameHeight) / 2;
    
        // Deshabilitar el movimiento del JInternalFrame
        frameInternal.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                // Restablecer la posición
                frameInternal.setLocation(x, y);
            }
        });
    }

    public static void disableInternal(JInternalFrame frameInternal) {
        // Quitar el borde del iframe
        //frameInternal.setBorder(BorderFactory.createEmptyBorder());

        // Evitar que se mueva el internal frame
        frameInternal.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Cancelar el movimiento
                frameInternal.setLocation(0, 0);
            }
        });

        frameInternal.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Cancelar el movimiento
                frameInternal.setLocation(0, 0);
            }
        });

        // Añadir un MouseListener que ignore los eventos de movimiento
        frameInternal.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Cancelar el movimiento
                // Mantener la posición actual
                frameInternal.setLocation(frameInternal.getX(), frameInternal.getY());
            }
        });

        frameInternal.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Cancelar el movimiento
                // Mantener la posición actual
                frameInternal.setLocation(frameInternal.getX(), frameInternal.getY());
            }
        });
    }

    // Método para centrar el JInternalFrame dentro del JDesktopPane
    public static void centerFrame(
        JDesktopPane paneDesktop,
        JInternalFrame frameInternal
    ) {
        // Obtener el tamaño del JDesktopPane y del JInternalFrame
        Dimension desktopSize = paneDesktop.getSize();
        Dimension frameSize = frameInternal.getSize();
    
        // Calcular las coordenadas para centrar el JInternalFrame
        int x = (desktopSize.width - frameSize.width) / 2;
        int y = (desktopSize.height - frameSize.height) / 2;
    
        // Establecer la ubicación centrada
        frameInternal.setLocation(x, y);
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

    // Modelo de tabla no editable
    public static class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Hacer que las celdas no sean editables
        }
    }
}
