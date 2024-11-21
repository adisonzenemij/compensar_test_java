
package com.app.project.models;

public class mUserData {
    private int id;
    private String login;
    private String password;
    
    // Constructor
    public mUserData(
        int id,
        String login,
        String password
    ) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
    
    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for login
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
