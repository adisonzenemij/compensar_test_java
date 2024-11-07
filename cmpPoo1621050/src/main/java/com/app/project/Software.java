
package com.app.project;

import com.app.project.animals.*;
import com.app.project.domestics.*;
import com.app.project.savages.*;

public class Software {

    public static void main(String[] args) {
        // Instanciar clase animal
        Animal data = new Animal("Max", 5, "Croquetas", "negro");
        data.comer();
        System.out.println("");
        
        // Instanciar animales
        animals();
        // Instanciar domesticos
        domestics();
        // Instanciar salvajes
        savages();
    }
    
    public static void animals() {
        DomesticAnimal domestico = new DomesticAnimal("Max", 5, "Croquetas", "negro", true);
        domestico.interactuar();
        domestico.obedecer();
        System.out.println("");
        
        SavageAnimal salvaje = new SavageAnimal("Snappy", 8, "Peces", "cafe", "Morder");
        salvaje.cazar();
        salvaje.defender();
        System.out.println("");
    }
    
    public static void domestics() {
        CatDomestic gato = new CatDomestic("Luna", 1, "blanco");
        gato.interactuar();
        System.out.println("");
        
        DogDomestic perro = new DogDomestic("Dukke", 2, "negro");
        perro.obedecer();
        perro.hacerSonido();
        System.out.println("");
        
        HorseDomestic caballo = new HorseDomestic("Zara", 3, "cafe");
        caballo.moverse();
        System.out.println("");
    }
    
    public static void savages() {
        CocodrileSavage cocodrilo = new CocodrileSavage("King", 4, "verde");
        cocodrilo.defender();
        System.out.println("");
        
        ElephantSavage elefante = new ElephantSavage("Dumbo", 5, "gris");
        elefante.moverse();
        System.out.println("");
        
        LionSavage leon = new LionSavage("Simba", 6, "dorado");
        leon.cazar();
        leon.hacerSonido();
    }
    
    
}
