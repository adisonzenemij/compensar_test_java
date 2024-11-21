
package com.app.project.interfaces;

// Interfaz de almacenar
public interface iStore {
    // Método para obtener la temperatura
    double getTemperature();

    // Método para obtener la humedad
    double getHumidity();

    // Método para establecer la temperatura
    void setTemperature(double temperature);

    // Método para establecer la humedad
    void setHumidity(double humidity);
        
}
