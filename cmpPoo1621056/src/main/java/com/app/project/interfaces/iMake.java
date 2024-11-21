
package com.app.project.interfaces;

import java.util.List;

// Interfaz de fabricar
public interface iMake {
    // Método para obtener una lista de lugares
    List<String> getCountry();

    // Métodos para añadir elementos a cada lista
    void addCountry(String country);

    // Método para verificar si el producto es orgánico
    boolean isOrganic();

    // Método para establecer si el producto es orgánico
    void setOrganic(boolean organic);
}
