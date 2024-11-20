
package com.app.project.domestics;

import com.app.project.animals.DomesticAnimal;
import com.app.project.interfaces.SoundInterface;

public class HorseDomestic extends DomesticAnimal implements SoundInterface {
    // Constructor
    public HorseDomestic(
        String name,
        int age,
        String color
    ) {
        // Llama al constructor de la clase padre con valores específicos
        super(name, age, color, "Herbívoro", true);
    }

    /*
        Método que permite interactuar con el caballo doméstico.
        Método qie sobreescribe el método de la clase DomesticAnimal.
    */
    @Override
    public void moverse() {
        System.out.println(getName() + " está saltando.");
    }

    /*
        Método que permite al caballo doméstico hacer su sonido característico.
        Este método implementa el método de la interfaz SoundInterface.
    */
    @Override
    public void hacerSonido() {
        System.out.println(getName() + " hace: Hiiiiii!");
    }
}
