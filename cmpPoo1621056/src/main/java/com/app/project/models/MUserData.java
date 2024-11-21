
package com.app.project.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.app.project.Message;
import com.app.project.Utility;
import com.app.project.entities.EUserData;
import com.app.project.views.VUserData;

public class MUserData {
    private static DefaultTableModel dfltDataModel;
    private static EUserData mdlUserData;

    private MUserData() {
        // Inicializar mdlUserData si no ha sido inicializado previamente
        //initializeUserData();
        // Inicializar mdlUserData
        /*if (mdlUserData == null) {
            mdlUserData = new EUserData(0, "root", "root"); // O con los valores que necesites
        }*/
        // Añadir registro inicial
        //registerDefault();
    }

    // Método para inicializar la entidad EUserData
    public static void initializeUserData() {
        if (mdlUserData == null) {
            mdlUserData = new EUserData(0, "root", "root"); // O con los valores que necesites
        }
    }

    public static EUserData initalData() {
        return mdlUserData;
    }

    // Método estático para inicializar el modelo
    public static void initializeModel() {
        if (dfltDataModel == null) {
            String[] columns = VUserData.tableColumn();
            // Usar NonEditableTableModel en lugar de DefaultTableModel
            dfltDataModel = new Utility.NonEditableTableModel(
                new Object[0][columns.length], columns
            );

            // Inicializar mdlUserData
            /*if (mdlUserData == null) {
                mdlUserData = new EUserData(0, "root", "root"); // O con los valores que necesites
            }*/

            // Añadir registro inicial
            registerDefault();
        }
    }

    // Retornar columnas para la tabla
    public static String[] tableColumn() {
        return new String[] {
            "Registro",
            "Acceso",
            "Clave",
        };
    }

    // Método para obtener el modelo
    public static DefaultTableModel getModel() {
        if (dfltDataModel == null) {
            initializeModel();
        }
        return dfltDataModel;
    }

    // Método para añadir el registro por defecto al modelo
    public static void registerDefault() {
        boolean exists = false;

        // Verificar si el registro con id=0 ya existe
        for (int row = 0; row < dfltDataModel.getRowCount(); row++) {
            int id = (int) dfltDataModel.getValueAt(row, 0);
            if (id == 0) {
                exists = true;
                break;
            }
        }

        // Si no existe, añadir el registro
        if (!exists) {
            dfltDataModel.addRow(
                new Object[]{
                    0,
                    "root",
                    "root"
                }
            );
        }
    }

    // Metodo para validar el campo del usuario
    public static Boolean fieldLogin(String value) {
        Boolean flag = true;
        // Verificar si el valor es nulo o está vacío
        if (value == null || value.isEmpty()) {
            // Visualizar mensaje de error
            Message.mssgField("Usuario");
            // Retornar falso si es invalido
            flag = false;
        }
        // Retornar verdarero si es valido
        return flag;
    }

    // Metodo para validar el campo del usuario
    public static Boolean fieldPass(String value) {
        Boolean flag = true;
        // Verificar si el valor es nulo o está vacío
        if (value == null || value.isEmpty()) {
            // Visualizar mensaje de error
            Message.mssgField("Contraseña");
            // Retornar falso si es invalido
            flag = false;
        }
        // Retornar verdarero si es valido
        return flag;
    }

    public static Boolean processData(String sLogin, String sPass) {
        // Obtener la lista de usuarios
        List<EUserData> userList = getList();

        // Verificar credenciales de acceso
        return userList.stream().anyMatch(
            data -> data.getLogin().equals(sLogin)
            && data.getPassword().equals(sPass)
        );
    }

    public static List<EUserData> getList_() {
        List<EUserData> userDataList = new ArrayList<>();

        // Asegurarse de que mdlUserData esté inicializado
        /*if (mdlUserData == null) {
            mdlUserData = new EUserData(0, "root", "root"); // O con los valores que necesites
        }*/

        // Imprimir el contenido del modelo en consola
        printModelContents(userDataList);
    
        // Recorrer las filas del DefaultTableModel
        for (int row = 0; row < dfltDataModel.getRowCount(); row++) {
            // Obtener valores directamente del modelo
            int id = (int) dfltDataModel.getValueAt(row, 0);
            String login = (String) dfltDataModel.getValueAt(row, 1);
            String password = (String) dfltDataModel.getValueAt(row, 2);
    
            // Crear una instancia del modelo usando el constructor
            EUserData userData = new EUserData(
                id,
                login,
                password
            );
    
            // Agregar el objeto a la lista
            userDataList.add(userData);
        }
    
        return userDataList;
    }

    public static List<EUserData> getList() {
        List<EUserData> userDataList = new ArrayList<>();
    
        // Asegurarse de que mdlUserData esté inicializado
        initializeUserData();
    
        // Si mdlUserData ya contiene un único registro (como el valor predeterminado), añádelo a la lista.
        if (mdlUserData != null) {
            userDataList.add(mdlUserData);
        }
    
        // Imprimir el contenido del modelo en consola
        printModelContents(userDataList);
        
        // Recorrer las filas del DefaultTableModel y agregar más usuarios si es necesario
        for (int row = 0; row < dfltDataModel.getRowCount(); row++) {
            // Obtener valores directamente del modelo
            int id = (int) dfltDataModel.getValueAt(row, 0);
            String login = (String) dfltDataModel.getValueAt(row, 1);
            String password = (String) dfltDataModel.getValueAt(row, 2);
        
            // Solo crear una instancia de EUserData si el id no corresponde al de la instancia ya existente
            if (id != mdlUserData.getId()) {
                EUserData userData = new EUserData(id, login, password);
                userDataList.add(userData);
            }
        }
        
        return userDataList;
    }
    

    // Método para imprimir el contenido del modelo
    private static void printModelContents(List<EUserData> userDataList) {
        System.out.println("Contenido del modelo:");
        for (EUserData userData : userDataList) {
            System.out.println(
                "ID: " + userData.getId() +
                ", Usuario: " + userData.getLogin() +
                ", Contraseña: " + userData.getPassword()
            );
        }
    }
}
