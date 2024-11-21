
package com.app.project.interfaces;

// Interfaz de propiedades
public interface IProperty {
    // Metodo para obtener la condicion
    String getCondition();

    // Metodo para establecer la condicion
    void setCondition(String condition);

    // Metodo para obtener la temperatura
    double getTemperature();

    // Metodo para establecer la temperatura
    void setTemperature(double temperature);
    
    // Metodo para obtener la humedad
    double getHumidity();

    // Metodo para establecer la humedad
    void setHumidity(double humidity);
}
