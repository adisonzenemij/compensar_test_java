
package com.app.project.models;

public class MGrease extends MAliment {
    private String density;
    private String origin;
    private String state;
    
    // Constructor
    public MGrease(
        int id,
        String name,
        String detail,
        int price,
        
        String density,
        String origin,
        String state
    ) {
        super(id, name, detail, price);
        this.density = density;
        this.origin = origin;
        this.state = state;
    }
    
    // Retornar valores de densidad
    public String getDensity() {
        return density;
    }

    // Mapear valores de densidad
    public void setDensity(String density) {
        this.density = density;
    }

    // Retornar valores de origen
    public String getOrigin() {
        return origin;
    }

    // Mapear valores de origen
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    // Retornar valores de estado
    public String getState() {
        return state;
    }

    // Mapear valores de estado
    public void setState(String state) {
        this.state = state;
    }
}
