
package com.app.project.domestics;

import com.app.project.animals.DomesticAnimal;
import com.app.project.interfaces.SoundInterface;

public class CatDomestic extends DomesticAnimal implements SoundInterface {
    // Constructor
    public CatDomestic(
        String name,
        int age,
        String color
    ) {
        // Llama al constructor de la clase padre con valores específicos
        super(name, age, color, "Carnívoro", true);
    }

    /*
        Método que permite interactuar con el gato doméstico.
        Método qie sobreescribe el método de la clase DomesticAnimal.
    */
    @Override
    public void interactuar() {
        System.out.println(getName() + " se está acurrucando.");
    }

    /*
        Método que permite al gato doméstico hacer su sonido característico.
        Este método implementa el método de la interfaz SoundInterface.
    */
    @Override
    public void hacerSonido() {
        System.out.println(getName() + " hace: Miau Miau!");
    }
}
