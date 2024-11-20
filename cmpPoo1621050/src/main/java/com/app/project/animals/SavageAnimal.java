
package com.app.project.animals;

import com.app.project.Animal;

public class SavageAnimal extends Animal {
    // Propiedad peligro
    private String danger;

    // Constructor
    public SavageAnimal(
        String nombre,
        int edad,
        String feeding,
        String color,
        String danger
    ) {
        super(nombre, edad, color, feeding);
        this.danger = danger;
    }

    // Mapear valores de peligro
    public String getDanger() {
        return danger;
    }

    // Modificar valores de peligro
    public void setDanger(String danger) {
        this.danger = danger;
    }

    // Metodo o comportamiento del animal salvaje
    public void cazar() {
        System.out.println(getName() + " está cazando.");
    }
    
    // Metodo o comportamiento del animal salvaje
    public void defender() {
        System.out.println(getName() + " está defendiendo.");
    }
}
