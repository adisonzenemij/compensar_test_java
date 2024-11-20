
package com.app.project.savages;

import com.app.project.animals.SavageAnimal;
import com.app.project.interfaces.SoundInterface;

public class ElephantSavage extends SavageAnimal implements SoundInterface {
    // Constructor
    public ElephantSavage(
        String name,
        int age,
        String color
    ) {
        // Llama al constructor de la clase padre con valores específicos
        super(name, age, color, "Herbívoro", "Moderado");
    }

    /*
        Método que permite interactuar con el elefante salvaje.
        Método qie sobreescribe el método de la clase SavageAnimal.
    */
    @Override
    public void moverse() {
        System.out.println(getName() + " está caminando lentamente.");
    }

    /*
        Método que permite al elefante salvaje hacer su sonido característico.
        Este método implementa el método de la interfaz SoundInterface.
    */
    @Override
    public void hacerSonido() {
        System.out.println(getName() + " hace: Barrrit!");
    }
}
