
package com.app.project.domestics;

import com.app.project.animals.DomesticAnimal;

public class CatDomestic extends DomesticAnimal {
    public CatDomestic(
        String name,
        int age,
        String color
    ) {
        super(name, age, color, "Carnívoro", true);
    }

    @Override
    public void interactuar() {
        System.out.println(getName() + " se está acurrucando.");
    }
}
