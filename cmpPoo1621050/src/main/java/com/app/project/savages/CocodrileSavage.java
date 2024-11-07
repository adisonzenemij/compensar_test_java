
package com.app.project.savages;

import com.app.project.animals.SavageAnimal;

public class CocodrileSavage extends SavageAnimal {
    public CocodrileSavage(String name, int age, String color) {
        super(name, age, color, "Carnívoro", "Alto");
    }

    @Override
    public void defender() {
        System.out.println(getName() + " está defendiendo su territorio en el río.");
    }
}
