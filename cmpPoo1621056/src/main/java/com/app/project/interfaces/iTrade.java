
package com.app.project.interfaces;

import java.util.List;

// Interfaz de comerciar
public interface iTrade {
    // Metodo para conocer su presentacion
    //presentation empaque, bolsa
    
    // Meotodo para conocer su experiencia
    //experience regular, bueno, excelente

    // Método para obtener una lista de presentaciones
    List<String> getPresentation();

    // Método para obtener una lista de experiencias
    List<String> getExperience();

    // Métodos para añadir elementos a cada lista
    void addPresentation(String presentation);
    void addExperience(String experience);
}
