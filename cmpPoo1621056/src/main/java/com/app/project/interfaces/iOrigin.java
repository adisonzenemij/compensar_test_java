
package com.app.project.interfaces;

import java.util.List;

// Interfaz de origen
public interface iOrigin {
    // Método para obtener una lista de elaboraciones
    List<String> getElaboration();

    // Métodos para añadir elementos a la lista
    void addElaboration(String elaboration);

    // Método para obtener una lista de procesos
    List<String> getProccess();

    // Métodos para añadir elementos a la lista
    void addProccess(String proccess);
}
