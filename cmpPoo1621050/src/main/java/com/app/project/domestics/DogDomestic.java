
package com.app.project.domestics;

import com.app.project.animals.DomesticAnimal;
import com.app.project.interfaces.SoundInterface;

public class DogDomestic extends DomesticAnimal implements SoundInterface {
    public DogDomestic(String name, int age, String color) {
        super(name, age, color, "Omnívoro", true);
    }

    @Override
    public void obedecer() {
        System.out.println(getName() + " está obedeciendo a sentarse.");
    }

    @Override
    public void hacerSonido() {
        System.out.println(getName() + " hace: Guau Guau!");
    }
}
