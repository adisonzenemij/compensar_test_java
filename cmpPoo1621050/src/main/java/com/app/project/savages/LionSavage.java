
package com.app.project.savages;

import com.app.project.animals.SavageAnimal;
import com.app.project.interfaces.SoundInterface;

public class LionSavage extends SavageAnimal implements SoundInterface {
    // Constructor
    public LionSavage(
        String name,
        int age,
        String color
    ) {
        // Llama al constructor de la clase padre con valores específicos
        super(name, age, color, "Carnívoro", "Alto");
    }

    /*
        Método que permite interactuar con el leon salvaje.
        Método qie sobreescribe el método de la clase SavageAnimal.
    */
    @Override
    public void cazar() {
        System.out.println(getName() + " está cazando en la selva.");
    }

    /*
        Método que permite al leon salvaje hacer su sonido característico.
        Este método implementa el método de la interfaz SoundInterface.
    */
    @Override
    public void hacerSonido() {
        System.out.println(getName() + " hace: Rugido!");
    }
}
