
package com.app.project;

import com.app.project.animals.*;
import com.app.project.domestics.*;
import com.app.project.savages.*;

public class Software {

    public static void main(String[] args) {
        // Instanciar clase animal
        Animal data = new Animal("Max", 5, "Croquetas", "negro");
        data.comer();
        message();
        
        // Instanciar animales
        animals();
        // Instanciar domesticos
        domestics();
        // Instanciar salvajes
        savages();
    }
    
    /*
        Metodo para crear instancia de anmiales domesticos y salvajes
        y poder utilizar o consultar sus metodos establecidos
    */
    public static void animals() {
        // Crear animal domestico con propiedades establecidas de la clase padre
        DomesticAnimal domestico = new DomesticAnimal("Max", 5, "Croquetas", "negro", true);
        domestico.interactuar();
        domestico.obedecer();
        message();
        
        // Crear animal salvaje con propiedades establecidas de la clase padre
        SavageAnimal salvaje = new SavageAnimal("Snappy", 8, "Peces", "cafe", "Morder");
        salvaje.cazar();
        salvaje.defender();
        message();
    }
    
    /*
        Metodo para crear instancia de anmiales domesticos
        y poder utilizar o consultar sus metodos establecidos
        heredando atributos de la clase padre animales
    */
    public static void domestics() {
        // Crear animal gato con propiedades de clase padre
        CatDomestic gato = new CatDomestic("Luna", 1, "blanco");
        gato.interactuar();
        gato.hacerSonido();
        message();
        
        // Crear animal perro con propiedades de clase padre
        DogDomestic perro = new DogDomestic("Dukke", 2, "negro");
        perro.obedecer();
        perro.hacerSonido();
        message();
        
        // Crear animal caballo con propiedades de clase padre
        HorseDomestic caballo = new HorseDomestic("Zara", 3, "cafe");
        caballo.moverse();
        caballo.hacerSonido();
        message();
    }
    
    /*
        Metodo para crear instancia de anmiales salvajes
        y poder utilizar o consultar sus metodos establecidos
        heredando atributos de la clase padre animales
    */
    public static void savages() {
        // Crear animal cocodrilo con propiedades de clase padre
        CocodrileSavage cocodrilo = new CocodrileSavage("King", 4, "verde");
        cocodrilo.defender();
        cocodrilo.hacerSonido();
        message();
        
        // Crear animal elefante con propiedades de clase padre
        ElephantSavage elefante = new ElephantSavage("Dumbo", 5, "gris");
        elefante.moverse();
        elefante.hacerSonido();
        message();
        
        // Crear animal leon con propiedades de clase padre
        LionSavage leon = new LionSavage("Simba", 6, "dorado");
        leon.cazar();
        leon.hacerSonido();
        message();
    }
    
    public static void message() {
        System.out.println("");
    }
}
