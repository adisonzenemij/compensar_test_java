
package com.app.project.animals;

import com.app.project.Animal;

public class DomesticAnimal extends Animal {
    // Propiedad sociable
    private boolean sociable;

    public DomesticAnimal(
        String nombre,
        int edad,
        String feeding,
        String color,
        boolean sociable
    ) {
        super(nombre, edad, feeding, color);
        this.sociable = sociable;
    }

    // Mapear valores de sociable
    public boolean getSociable() {
        return sociable;
    }

    // Modificar valores de sociable
    public void setSociable(boolean sociable) {
        this.sociable = sociable;
    }

    public void interactuar() {
        System.out.println(getName() + " está interactuando con humanos.");
    }

    public void obedecer() {
        System.out.println(getName() + " está obedeciendo un comando.");
    }
}
