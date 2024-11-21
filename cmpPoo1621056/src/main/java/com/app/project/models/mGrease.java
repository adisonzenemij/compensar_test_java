
package com.app.project.models;

public class mGrease extends mAliment {
    private double density;
    private String state;
    
    // Constructor
    public mGrease(
        int id,
        String name,
        String detail,
        double price,
        
        double density,
        String state
    ) {
        super(id, name, detail, price);
        this.density = density;
        this.state = state;
    }
    
    // Getter and Setter for density
    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    // Getter and Setter for state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
