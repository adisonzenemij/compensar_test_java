
package com.app.project.models;

public class mHydrate extends mAliment {
    private String nutrient;
    private String benefit;
    
    // Constructor
    public mHydrate(
        int id,
        String name,
        String detail,
        double price,
        
        String nutrient,
        String benefit
    ) {
        super(id, name, detail, price);
        this.nutrient = nutrient;
        this.benefit = benefit;
    }
    
    // Getter and Setter for nutrient
    public String getNutrient() {
        return nutrient;
    }

    public void setNutrient(String nutrient) {
        this.nutrient = nutrient;
    }

    // Getter and Setter for color
    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
}
