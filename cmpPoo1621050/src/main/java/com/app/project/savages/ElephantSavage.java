
package com.app.project.savages;

import com.app.project.animals.SavageAnimal;

public class ElephantSavage extends SavageAnimal {
    public ElephantSavage(String name, int age, String color) {
        super(name, age, color, "Herbívoro", "Moderado");
    }

    @Override
    public void moverse() {
        System.out.println(getName() + " está caminando lentamente.");
    }
}
