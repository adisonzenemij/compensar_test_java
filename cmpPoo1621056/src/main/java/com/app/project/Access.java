
package com.app.project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.app.project.models.MUserData;

public class Access {
    // Destokp Panel de la aplicacion principal
    private static JDesktopPane desktopPane;

    // Mantener una referencia al JInternalFrame
    private static JInternalFrame dataFrame;

    // Campos del formulario
    private static JTextField fieldLogin;
    private static JTextField fieldPass;

    // Botones para llamar internal frame
    private static JButton btnUserData;

    // Constructor
    private Access() {}

    public static void openInternal(JDesktopPane paneDesktop) {
        desktopPane = paneDesktop;
        // Crear solo si no existe
        if (dataFrame == null || !dataFrame.isVisible()) {
            // Crear un JInternalFrame para contener los botones
            dataFrame = new JInternalFrame(
                "", // Titulo
                false, // No redimensionar
                false, // No cerrar
                false, // No maximizar
                false  // Minimizar
            );

            Utility.internalSize(desktopPane, dataFrame);
            Utility.disableComponent(desktopPane, dataFrame);
            Utility.disableInternal(dataFrame);

            // Establecer el layout & centrar los componentes
            dataFrame.setLayout(
                new FlowLayout(
                    FlowLayout.CENTER
                )
            );

            // Cambiar el layout a BoxLayout en el eje Y
            dataFrame.setLayout(
                new BoxLayout(
                    dataFrame.getContentPane(),
                    BoxLayout.Y_AXIS
                )
            );

            titleWelcome();
            // Añadir espacio entre el boton y las cajas de texto
            dataFrame.add(Box.createVerticalStrut(60));
            fieldAction();
            // Añadir espacio entre títulos
            dataFrame.add(Box.createVerticalStrut(60));
            buttonAction();
            // Añadir espacio entre el título y los botones
            dataFrame.add(Box.createVerticalStrut(60));
            titleDevelop();
            // Añadir espacio entre el título y los botones
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

            actAuthData();
        }
    }

    public static void fieldAction() {
        // Crear un formulario para capturar valores
        JPanel newForm = new JPanel(new BorderLayout());
        // Crear un panel para capturar los valores
        JPanel newField = new JPanel();

        // Usar BoxLayout en el eje Y
        newField.setLayout(new BoxLayout(newField, BoxLayout.Y_AXIS));
    
        // Crear las etiquetas y campos de texto
        JLabel labelLogin = new JLabel("Acceso");
        // Centrar etiqueta
        labelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Establecer un ancho fijo para el campo
        fieldLogin = new JTextField(20);
        fieldLogin.setEditable(true);
        // Centrar el campo
        fieldLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel labelPass = new JLabel("Clave");
        // Centrar etiqueta
        labelPass.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Establecer un ancho fijo para el campo
        fieldPass = new JTextField(20);
        fieldPass.setEditable(true);
        // Centrar el campo
        fieldPass.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        // Añadir las etiquetas y campos de texto al panel
        newField.add(labelLogin);
         // Espacio entre componentes
        newField.add(Box.createVerticalStrut(10));
        newField.add(fieldLogin);
         // Espacio entre componentes
        newField.add(Box.createVerticalStrut(20));
        newField.add(labelPass);
         // Espacio entre componentes
        newField.add(Box.createVerticalStrut(10));
        newField.add(fieldPass);
    
        // Añadir el panel al formulario
        newForm.add(newField, BorderLayout.CENTER);
    
        // Añadir el formulario al frame
        dataFrame.add(newForm);
    }    

    public static void buttonAction() {
        // Crear y añadir botones al internal frame
        btnUserData = Utility.addButtons("Iniciar Sesión");
        // Centrar botones al internal frame
        btnUserData.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Añadir los botones
        dataFrame.add(btnUserData);
    }

    public static void titleWelcome() {
        String message = "Bienvenidos";
        // Crear y añadir el label para el título principal
        JLabel labelTitle = new JLabel(message, SwingConstants.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 15));
        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataFrame.add(labelTitle);
    }

    public static void titleDevelop() {
        String message = "Programacion Orientada a Objetos";
        // Crear y añadir el label para el título desarrollador
        JLabel labelDevelop = new JLabel(message, SwingConstants.CENTER);
        labelDevelop.setFont(new Font("Arial", Font.BOLD, 12));
        labelDevelop.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataFrame.add(labelDevelop); 
    }

    public static void titleWebPage() {
        // Crear y añadir el label para el título de pagina web
        JLabel labelWebMain = new JLabel("", SwingConstants.CENTER);
        labelWebMain.setFont(new Font("Arial", Font.BOLD, 12));
        labelWebMain.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataFrame.add(labelWebMain);
    }

    // Establecer valores vacíos del formulario
    public static void actAuthData() {
        // Redireccionar al panel del formulario
        btnUserData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valLogin = fieldLogin.getText();
                String valPass = fieldPass.getText();

                // Validar si los campos fueron completados
                Boolean resLogin = MUserData.fieldLogin(valLogin);
                Boolean resPass = resLogin && MUserData.fieldPass(valPass);

                // Evaluar si los campos fueron completados
                if (resLogin && resPass) {
                    if (MUserData.processData(valLogin, valPass)) {
                        String message = "Acceso Concedido";
                        Message.mssgSuccess(message);
                        // Ocultar el JInternalFrame de acceso
                        if (dataFrame != null && dataFrame.isVisible()) {
                            dataFrame.setVisible(false);
                        }
                        Desktop.openInternal(desktopPane);
                    } else {
                        String message = "Credenciales Inválidas";
                        Message.mssgError(message);
                    }
                }
            }
        });
    }
}
