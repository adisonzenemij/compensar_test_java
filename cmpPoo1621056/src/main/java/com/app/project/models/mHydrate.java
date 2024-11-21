
package com.app.project.models;

import com.app.project.interfaces.IProperty;

public class MHydrate extends MAliment implements IProperty {
    private String benefit;
    private String calorie;
    private String nutrient;

    private double temperature;
    private double humidity;
    private String condition;
    
    // Constructor
    public MHydrate(
        int id,
        String name,
        String detail,
        int price,
        
        String benefit,
        String calorie,
        String nutrient,

        String condition,
        double temperature,
        double humidity
    ) {
        super(id, name, detail, price);

        this.benefit = benefit;
        this.calorie = calorie;
        this.nutrient = nutrient;

        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    // Retornar valores de beneficio
    public String getBenefit() {
        return benefit;
    }
    
    // Mapear valores de beneficio
    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
    
    // Retornar valores de caloria
    public String getCalorie() {
        return calorie;
    }

    // Mapear valores de caloria
    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }
    
    // Retornar valores de nutriente
    public String getNutrient() {
        return nutrient;
    }

    // Mapear valores de nutriente
    public void setNutrient(String nutrient) {
        this.nutrient = nutrient;
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
