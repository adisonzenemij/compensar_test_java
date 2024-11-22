
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

    // Constructor
    private MUserData() {}

    // Método para inicializar la entidad
    private static void initialEntity() {
        if (mdlUserData == null) {
            // Valores por defecto para la entidad
            mdlUserData = new EUserData(
                0,
                "root",
                "root"
            );
        }
    }

    // Retornar la entidad inicializada
    public static EUserData initalData() {
        // Devolver datos
        return mdlUserData;
    }

    // Método para inicializar el modelo
    public static void initializeModel() {
        if (dfltDataModel == null) {
            String[] columns = VUserData.tableColumn();
            // Usar NonEditableTableModel en lugar de DefaultTableModel
            dfltDataModel = new Utility.NonEditableTableModel(
                new Object[0][columns.length], columns
            );
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
        // Verificar inicializacion
        if (dfltDataModel == null) {
            // Cargar inicializacion
            initializeModel();
        }
        // Devolver el modelo
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
    public static boolean fieldLogin(String value) {
        boolean flag = true;
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
    public static boolean fieldPass(String value) {
        boolean flag = true;
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

    public static List<EUserData> getList() {
        List<EUserData> userDataList = new ArrayList<>();
        // Asegurarse de que el modelo esté inicializado
        initialEntity();
        // Si la entidad contiene un unico registro añadirlo a la lista
        if (mdlUserData != null) { userDataList.add(mdlUserData); }
        // Imprimir el contenido del modelo en consola
        printModelContents(userDataList);
        
        // Recorrer las filas del DefaultTableModel y agregar más usuarios si es necesario
        for (int row = 0; row < dfltDataModel.getRowCount(); row++) {
            // Obtener valores directamente del modelo
            int id = (int) dfltDataModel.getValueAt(row, 0);
            String login = (String) dfltDataModel.getValueAt(row, 1);
            String password = (String) dfltDataModel.getValueAt(row, 2);
        
            // Crear una instancia de la entidad
            if (id != mdlUserData.getId()) {
                EUserData userData = new EUserData(
                    id,
                    login,
                    password
                );
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
