
package com.app.project;

import java.util.List;

import com.app.project.models.MUserData;
import com.app.project.views.VUserData;

public class Access {
    // Definir propiedades
    private static String login;
    private static String pass;

    // Método para validar el login (usuario)
    public static String validateLogin() {
        // Nombre del campo
        String field = "Usuario";
        
        // Capturar el usuario
        captureLogin(field);

        // Validar que el campo no esté vacío
        while (login == null || login.isEmpty()) {
            // Mostrar mensaje si el campo está vacío
            Message.mssgField(field);
            // Volver a capturar el usuario
            captureLogin(field);
        }
        // Retornar usuario capturado
        return login;
    }
    
    // Capturar datos del usuario
    public static void captureLogin(String field) {
        // Utilizar JOption Input
        login = Message.cptrData(field);
    }

    public static Boolean processLogin(String value) {
        // Obtener la lista de usuarios
        List<MUserData> userList = VUserData.getList();

        // Verificar credenciales de acceso
        return userList.stream().anyMatch(
            data -> data.getLogin().equals(value)
        );
    }

    // Método para validar la contraseña
    public static String validatePass() {
        // Nombre del campo
        String field = "Contraseña";
        // Capturar la contraseña
        capturePass(field);
        // Validar que el campo no esté vacío
        while (pass == null || pass.isEmpty()) {
            // Mostrar mensaje si el campo está vacío
            Message.mssgField(field);
            // Volver a capturar la contraseña
            capturePass(field);
        }
        // Retornar contraseña capturada
        return pass;
    }
    
    // Capturar datos de la contraseña
    public static void capturePass(String field) {
        // Utilizar JOption Input
        pass = Message.cptrData(field);
    }

    public static Boolean processPass(String value) {
        // Obtener la lista de usuarios
        List<MUserData> userList = VUserData.getList();

        // Verificar credenciales de acceso
        return userList.stream().anyMatch(
            data -> data.getPassword().equals(value)
        );
    }

    public static Boolean processData(String sLogin, String sPass) {
        // Obtener la lista de usuarios
        List<MUserData> userList = VUserData.getList();

        // Verificar credenciales de acceso
        return userList.stream().anyMatch(
            data -> data.getLogin().equals(sLogin)
            && data.getPassword().equals(sPass)
        );
    }
}
