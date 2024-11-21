
package com.app.project.entities;

public class EUserData {
    private int id;
    private String login;
    private String password;
    
    // Constructor
    public EUserData(
        int id,
        String login,
        String password
    ) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
    
    // Retornar valores de id
    public int getId() {
        return id;
    }

    // Mapear valores de id
    public void setId(int id) {
        this.id = id;
    }

    // Retornar valores de acceso
    public String getLogin() {
        return login;
    }

    // Mapear valores de acceso
    public void setLogin(String login) {
        this.login = login;
    }

    // Retornar valores de clave
    public String getPassword() {
        return password;
    }

    // Mapear valores de clave
    public void setPassword(String password) {
        this.password = password;
    }
}
