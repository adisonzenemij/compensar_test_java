
package com.app.project.models;

public class mVegetal extends mAliment {
    private String vitamin;
    private String color;
    
    // Constructor
    public mVegetal(
        int id,
        String name,
        String detail,
        double price,
        
        String vitamin,
        String color
    ) {
        super(id, name, detail, price);
        this.vitamin = vitamin;
        this.color = color;
    }
    
    // Getter and Setter for vitamin
    public String getVitamin() {
        return vitamin;
    }

    public void setVitamin(String vitamin) {
        this.vitamin = vitamin;
    }

    // Getter and Setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
