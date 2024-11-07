
package com.app.project.domestics;

import com.app.project.animals.DomesticAnimal;

public class HorseDomestic extends DomesticAnimal {
    public HorseDomestic(String name, int age, String color) {
        super(name, age, color, "Herbívoro", true);
    }

    @Override
    public void moverse() {
        System.out.println(getName() + " está saltando.");
    }
}
