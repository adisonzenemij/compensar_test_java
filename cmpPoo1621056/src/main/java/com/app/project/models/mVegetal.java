
package com.app.project.models;

public class mVegetal extends mAliment {
    private String color;
    private String size;
    private String vitamin;
    
    // Constructor
    public mVegetal(
        int id,
        String name,
        String detail,
        double price,
        
        String color,
        String size,
        String vitamin
    ) {
        super(id, name, detail, price);
        this.color = color;
        this.size = size;
        this.vitamin = vitamin;
    }

    // Retornar valores de color
    public String getColor() {
        return color;
    }

    // Mapear valores de color
    public void setColor(String color) {
        this.color = color;
    }

    // Retornar valores de tamaño
    public String getSize() {
        return size;
    }

    // Mapear valores de tamaño
    public void setSize(String size) {
        this.size = size;
    }
    
    // Retornar valores de vitamina
    public String getVitamin() {
        return vitamin;
    }

    // Mapear valores de vitamina
    public void setVitamin(String vitamin) {
        this.vitamin = vitamin;
    }
}
