/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author adiso
 */
public class Format {
    // Método para formatear a dos decimales
    public static String decimalToTwo(double value) {
        // Configurar DecimalFormat para usar punto como separador decimal
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        // Establecer punto como separador decimal
        symbols.setDecimalSeparator('.');
        // Opcional: establecer coma como separador de miles
        symbols.setGroupingSeparator(',');
        // Formatear valores para el resultado final
        DecimalFormat df = new DecimalFormat("#.00", symbols);
        // Retornar valor formateado
        return df.format(value);
    }
}
