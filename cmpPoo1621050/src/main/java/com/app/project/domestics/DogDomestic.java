
package com.app.project.domestics;

import com.app.project.animals.DomesticAnimal;
import com.app.project.interfaces.SoundInterface;

public class DogDomestic extends DomesticAnimal implements SoundInterface {
    // Constructor
    public DogDomestic(
        String name,
        int age,
        String color
    ) {
        // Llama al constructor de la clase padre con valores específicos
        super(name, age, color, "Omnívoro", true);
    }

    /*
        Método que permite interactuar con el perro doméstico.
        Método qie sobreescribe el método de la clase DomesticAnimal.
    */
    @Override
    public void obedecer() {
        System.out.println(getName() + " está obedeciendo a sentarse.");
    }

    /*
        Método que permite al perro doméstico hacer su sonido característico.
        Este método implementa el método de la interfaz SoundInterface.
    */
    @Override
    public void hacerSonido() {
        System.out.println(getName() + " hace: Guau Guau!");
    }
}
