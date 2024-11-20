
package com.app.project.animals;

import com.app.project.Animal;

public class DomesticAnimal extends Animal {
    // Propiedad sociable
    private boolean sociable;

    // Constructor
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

    // Metodo o comportamiento del animal domestico
    public void interactuar() {
        System.out.println(getName() + " está interactuando.");
    }

    // Metodo o comportamiento del animal domestico
    public void obedecer() {
        System.out.println(getName() + " está obedeciendo.");
    }
}
