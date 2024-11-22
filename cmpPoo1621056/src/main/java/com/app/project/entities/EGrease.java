
package com.app.project.entities;

import com.app.project.interfaces.IProperty;

public class EGrease extends EAliment implements IProperty {
    private String density;
    private String origin;
    private String state;

    private double temperature;
    private double humidity;
    private String condition;
    
    // Constructor
    public EGrease(
        int id,
        String name,
        String detail,
        int price,
        
        String density,
        String origin,
        String state,

        String condition,
        double temperature,
        double humidity
    ) {
        super(id, name, detail, price);

        this.density = density;
        this.origin = origin;
        this.state = state;

        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
    }
    
    // Obtener valores de densidad
    public String getDensity() {
        return density;
    }

    // Mapear valores de densidad
    public void setDensity(String density) {
        this.density = density;
    }

    // Obtener valores de origen
    public String getOrigin() {
        return origin;
    }

    // Mapear valores de origen
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    // Obtener valores de estado
    public String getState() {
        return state;
    }

    // Mapear valores de estado
    public void setState(String state) {
        this.state = state;
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
