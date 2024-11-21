
package com.app.project.interfaces;

import java.util.List;

// Interfaz de origen
public interface iOrigin {
    // Metodo para conocer su elaboracion
    //elaboration: enero hasta diciembre
    
    // Meotodo para conocer su proceso
    //proccess: tradicional, industrial

    // Método para obtener una lista de elaboraciones
    List<String> getElaboration();

    // Método para obtener una lista de procesos
    List<String> getProccess();

    // Métodos para añadir elementos a cada lista
    void addElaboration(String elaboration);
    void addProccess(String proccess);
}
