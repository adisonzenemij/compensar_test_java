
package com.app.project.entities;

import com.app.project.interfaces.IProperty;

public class EVegetal extends EAliment implements IProperty {
    private String color;
    private String size;
    private String vitamin;

    private double temperature;
    private double humidity;
    private String condition;
    
    // Constructor
    public EVegetal(
        int id,
        String name,
        String detail,
        int price,
        
        String color,
        String size,
        String vitamin,

        String condition,
        double temperature,
        double humidity
    ) {
        super(id, name, detail, price);

        this.color = color;
        this.size = size;
        this.vitamin = vitamin;

        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
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

    @Override
    public String getCondition() {
        return condition;
    }

    @Override
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getHumidity() {
        return humidity;
    }

    @Override
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
