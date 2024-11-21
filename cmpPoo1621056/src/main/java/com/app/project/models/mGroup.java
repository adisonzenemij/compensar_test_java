
package com.app.project.models;

public class MGroup {
    private int id;
    private String name;
    
    // Constructor
    public MGroup(
            int id,
            String name
    ) {
        this.id = id;
        this.name = name;
    }
    
    // Retornar valores de id
    public int getId() {
        return id;
    }

    // Mapear valores de id
    public void setId(int id) {
        this.id = id;
    }

    // Retornar valores de nombre
    public String getName() {
        return name;
    }

    // Mapear valores de nombre
    public void setName(String name) {
        this.name = name;
    }
}
