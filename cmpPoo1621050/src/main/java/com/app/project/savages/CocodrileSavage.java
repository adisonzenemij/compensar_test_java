
package com.app.project.savages;

import com.app.project.animals.SavageAnimal;
import com.app.project.interfaces.SoundInterface;

public class CocodrileSavage extends SavageAnimal implements SoundInterface {
    // Constructor
    public CocodrileSavage(
        String name,
        int age,
        String color
    ) {
        // Llama al constructor de la clase padre con valores específicos
        super(name, age, color, "Carnívoro", "Alto");
    }

    /*
        Método que permite interactuar con el cocodrilo salvaje.
        Método qie sobreescribe el método de la clase SavageAnimal.
    */
    @Override
    public void defender() {
        System.out.println(getName() + " está defendiendo su territorio en el río.");
    }

    /*
        Método que permite al cocodrilo salvaje hacer su sonido característico.
        Este método implementa el método de la interfaz SoundInterface.
    */
    @Override
    public void hacerSonido() {
        System.out.println(getName() + " hace: Grrrrr!");
    }
}
