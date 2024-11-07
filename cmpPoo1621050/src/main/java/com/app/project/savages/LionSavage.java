
package com.app.project.savages;

import com.app.project.animals.SavageAnimal;
import com.app.project.interfaces.SoundInterface;

public class LionSavage extends SavageAnimal implements SoundInterface {
    public LionSavage(String name, int age, String color) {
        super(name, age, color, "Carnívoro", "Alto");
    }

    @Override
    public void cazar() {
        System.out.println(getName() + " está cazando en la selva.");
    }

    @Override
    public void hacerSonido() {
        System.out.println(getName() + " hace: Rugido!");
    }
}
