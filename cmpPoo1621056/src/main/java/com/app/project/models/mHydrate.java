
package com.app.project.models;

public class MHydrate extends MAliment {
    private String benefit;
    private String calorie;
    private String nutrient;
    
    // Constructor
    public MHydrate(
        int id,
        String name,
        String detail,
        int price,
        
        String benefit,
        String calorie,
        String nutrient
    ) {
        super(id, name, detail, price);
        this.benefit = benefit;
        this.calorie = calorie;
        this.nutrient = nutrient;
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
}
