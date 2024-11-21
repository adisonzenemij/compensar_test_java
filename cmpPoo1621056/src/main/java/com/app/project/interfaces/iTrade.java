
package com.app.project.interfaces;

import java.util.List;

// Interfaz de comerciar
public interface iTrade {
    // Método para obtener una lista de presentaciones
    List<String> getPresentation();

    // Métodos para añadir elementos a la lista
    void addPresentation(String presentation);

    // Método para obtener una lista de experiencias
    List<String> getExperience();

    // Métodos para añadir elementos a la lista
    void addExperience(String experience);
}
