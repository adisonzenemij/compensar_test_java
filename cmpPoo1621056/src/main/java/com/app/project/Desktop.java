
package com.app.project;

import com.app.project.views.*;

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

import com.app.project.entities.EGrease;
import com.app.project.entities.EHydrate;
import com.app.project.entities.EUserData;
import com.app.project.entities.EVegetal;
import com.app.project.models.MUserData;

import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

public class Desktop {
    // Destokp Panel de la aplicacion principal
    private static JDesktopPane desktopPane;

    // Mantener una referencia al JInternalFrame
    private static JInternalFrame dataFrame;
    // Mantener una referencia al JTabbedPane
    private static JTabbedPane tabbedPane;

    // Datos para el modelo de grasas
    private static EGrease greaseModel;
    private static DefaultTableModel dfltGrease;

    // Datos para el modelo de hidratos
    private static EHydrate hydrateModel;
    private static DefaultTableModel dfltHydrate;

    // Datos para el modelo de usuarios
    private static EUserData userDataModel;
    private static DefaultTableModel dfltUserData;

    // Datos para el modelo de vegetales
    private static EVegetal vegetalModel;
    private static DefaultTableModel dfltVegetal;

    // Botones para llamar internal frame
    private static JButton btnGrease;
    private static JButton btnHydrate;
    private static JButton btnUserData;
    private static JButton btnVegetal;
    private static JButton btnLogout;

    // Titulos para el internal frame principal
    private static JLabel labelTitle;
    private static JLabel labelDevelop;
    private static JLabel labelWebMain;

    // Constructor
    private Desktop() {}

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

            actGrease();
            actHydrate();
            actUserData();
            actVegetal();
            actLogout();
        }
    }

    public static void buttonAction() {
        // Crear y añadir botones al internal frame
        btnUserData = Utility.addButtons("Usuarios");
        btnGrease = Utility.addButtons("Grasas");
        btnHydrate = Utility.addButtons("Hidratos de Carbono");
        btnVegetal = Utility.addButtons("Frutas y Verduras");
        btnLogout = Utility.addButtons("Cerrar Sesión");

        // Centrar botones al internal frame
        btnUserData.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGrease.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHydrate.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVegetal.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir los botones
        dataFrame.add(btnUserData);
        // Espacio entre los botones
        dataFrame.add(Box.createVerticalStrut(20));
        dataFrame.add(btnGrease);
        // Espacio entre los botones
        dataFrame.add(Box.createVerticalStrut(10));
        dataFrame.add(btnHydrate);
        // Espacio entre los botones
        dataFrame.add(Box.createVerticalStrut(10));
        dataFrame.add(btnVegetal);
        // Espacio entre los botones
        dataFrame.add(Box.createVerticalStrut(20));
        dataFrame.add(btnLogout);
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
        labelDevelop = new JLabel("Programacion Orientada a Objetos", SwingConstants.CENTER);
        labelDevelop.setFont(new Font("Arial", Font.BOLD, 12));
        labelDevelop.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataFrame.add(labelDevelop); 
    }

    public static void titleWebPage() {
        // Crear y añadir el label para el título de pagina web
        labelWebMain = new JLabel("", SwingConstants.CENTER);
        labelWebMain.setFont(new Font("Arial", Font.BOLD, 12));
        labelWebMain.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataFrame.add(labelWebMain);
    }

    public static void actGrease() {
        btnGrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Grasas",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());

                // Verificar si el modelo ya existe, si no, inicializarlo
                 if (greaseModel == null) {
                    greaseModel = new EGrease(
                        0,
                        "",
                        "",
                        0,
                        "",
                        "",
                        "",
                        "",
                        0,
                        0
                    );
                    String[] columns = VGrease.tableColumn();
                    // Usar NonEditableTableModel en lugar de DefaultTableModel
                    dfltGrease = new Utility.NonEditableTableModel(
                        new Object[0][columns.length], columns
                    );
                }

                // Añadir el JTabbedPane con el modelo existente
                tabbedPane = VGrease.tabbedPane(dfltGrease, greaseModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Centrando el JInternalFrame en el JDesktopPane
                Utility.centerFrame(desktopPane, dataFrame);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void actHydrate() {
        btnHydrate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Hidratos de Carbono",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());

                // Verificar si el modelo ya existe, si no, inicializarlo
                 if (hydrateModel == null) {
                    hydrateModel = new EHydrate(
                        0,
                        "",
                        "",
                        0,
                        "",
                        "",
                        "",
                        "",
                        0,
                        0
                    );
                    String[] columns = VHydrate.tableColumn();
                    // Usar NonEditableTableModel en lugar de DefaultTableModel
                    dfltHydrate = new Utility.NonEditableTableModel(
                        new Object[0][columns.length], columns
                    );
                }

                // Añadir el JTabbedPane con el modelo existente
                tabbedPane = VHydrate.tabbedPane(dfltHydrate, hydrateModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Centrando el JInternalFrame en el JDesktopPane
                Utility.centerFrame(desktopPane, dataFrame);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void actUserData() {
        btnUserData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Usuarios",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());







                // Asegúrate de que el modelo de datos está inicializado correctamente
                // Aquí estamos obteniendo el modelo de datos ya inicializado desde MUserData
                dfltUserData = MUserData.getModel();

                // Verificar si el modelo ha sido correctamente inicializado
                if (dfltUserData == null) {
                    System.out.println("Error: El modelo de usuarios no está inicializado.");
                    return; // Salir de la función si el modelo no está inicializado
                }

                //MUserData.initializeUserData();

                userDataModel = MUserData.initalData();

                // Verificar si la entidad userDataModel (mdlUserData) está correctamente inicializada
                if (userDataModel == null) {
                    System.out.println("Error: La entidad de datos de usuario no está inicializada.");
                    return; // Salir de la función si la entidad no está inicializada
                }

                // Añadir el JTabbedPane con el modelo de datos a la interfaz
                tabbedPane = VUserData.tabbedPane(dfltUserData, userDataModel);





                // Obtener el modelo inicializado desde MUserData
                //DefaultTableModel userModel = MUserData.getModel();
                //dfltUserData = MUserData.getModel();

                // Verificar si el modelo ya existe, si no, inicializarlo
                /*if (userDataModel == null) {
                    System.out.println("Modelo Usuarios Inicializado");
                    //userDataModel = new EUserData(0, "root", "root");
                    String[] columns = VUserData.tableColumn();
                    // Usar NonEditableTableModel en lugar de DefaultTableModel
                    dfltUserData = new Utility.NonEditableTableModel(
                        new Object[0][columns.length], columns
                    );
                }*/
                //dfltUserData = MUserData.getModel();

                /*if (userDataModel == null) {
                    userDataModel = new EUserData(0, "root", "root"); // Inicialización del objeto mdlUserData
                }*/

                // Añadir el JTabbedPane con el modelo
                //tabbedPane = VUserData.tabbedPane(dfltUserData, null);
                // Añadir el JTabbedPane con el modelo existente
                //tabbedPane = VUserData.tabbedPane(dfltUserData, userDataModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Centrando el JInternalFrame en el JDesktopPane
                Utility.centerFrame(desktopPane, dataFrame);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void actVegetal() {
        btnVegetal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un nuevo JInternalFrame para mostrar el JTabbedPane
                JInternalFrame dataFrame = new JInternalFrame(
                    "Frutas y Verduras",
                    true,
                    true,
                    true,
                    true
                );
                dataFrame.setSize(500, 500);
                dataFrame.setLayout(new BorderLayout());

                // Verificar si el modelo ya existe, si no, inicializarlo
                 if (vegetalModel == null) {
                    vegetalModel = new EVegetal(
                        0,
                        "",
                        "",
                        0,
                        "",
                        "",
                        "",
                        "",
                        0,
                        0
                    );
                    String[] columns = VVegetal.tableColumn();
                    // Usar NonEditableTableModel en lugar de DefaultTableModel
                    dfltVegetal = new Utility.NonEditableTableModel(
                        new Object[0][columns.length], columns
                    );
                }

                // Añadir el JTabbedPane con el modelo existente
                tabbedPane = VVegetal.tabbedPane(dfltVegetal, vegetalModel);
                // Añadir el JTabbedPane al nuevo JInternalFrame
                dataFrame.add(tabbedPane, BorderLayout.CENTER);
                // Centrando el JInternalFrame en el JDesktopPane
                Utility.centerFrame(desktopPane, dataFrame);
                // Hacer visible el nuevo JInternalFrame
                dataFrame.setVisible(true);
                // Añadir el nuevo internal frame
                desktopPane.add(dataFrame);
                dataFrame.moveToFront();
            }
        });
    }

    public static void actLogout() {
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar el JInternalFrame de acceso
                if (dataFrame != null && dataFrame.isVisible()) {
                    dataFrame.setVisible(false);
                }
                Access.openInternal(desktopPane);
            }
        });
    }

    /*public static void internalSize(
        JInternalFrame intFrame
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
        // Devolver el botón creado
        return new JButton(title);
    }

    private static void disableComponent(
        JInternalFrame intFrame
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

    private static void disableInternal(JInternalFrame intFrame) {
        // Quitar el borde del iframe
        //intFrame.setBorder(BorderFactory.createEmptyBorder());

        // Evitar que se mueva el internal frame
        intFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Cancelar el movimiento
                intFrame.setLocation(0, 0);
            }
        });

        intFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Cancelar el movimiento
                intFrame.setLocation(0, 0);
            }
        });

        // Añadir un MouseListener que ignore los eventos de movimiento
        intFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Cancelar el movimiento
                // Mantener la posición actual
                intFrame.setLocation(intFrame.getX(), intFrame.getY());
            }
        });

        intFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Cancelar el movimiento
                // Mantener la posición actual
                intFrame.setLocation(intFrame.getX(), intFrame.getY());
            }
        });
    }

    // Método para centrar el JInternalFrame dentro del JDesktopPane
    private static void centerFrame(JInternalFrame intFrame) {
        // Obtener el tamaño del JDesktopPane y del JInternalFrame
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = intFrame.getSize();
    
        // Calcular las coordenadas para centrar el JInternalFrame
        int x = (desktopSize.width - frameSize.width) / 2;
        int y = (desktopSize.height - frameSize.height) / 2;
    
        // Establecer la ubicación centrada
        intFrame.setLocation(x, y);
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
    }*/
}
