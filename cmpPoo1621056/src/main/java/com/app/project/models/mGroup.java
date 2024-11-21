
package com.app.project.models;

public class mGroup {
    private int id;
    private String name;
    
    // Constructor
    public mGroup(
            int id,
            String name
    ) {
        this.id = id;
        this.name = name;
    }
    
    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para rebate
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
