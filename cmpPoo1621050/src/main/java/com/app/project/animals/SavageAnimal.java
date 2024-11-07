
package com.app.project.animals;

import com.app.project.Animal;

public class SavageAnimal extends Animal {
    // Propiedad peligro
    private String danger;

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

    public void cazar() {
        System.out.println(getName() + " está cazando.");
    }

    public void defender() {
        System.out.println(getName() + " está defendiendo.");
    }
}
