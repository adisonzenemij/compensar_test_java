/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author adiso
 */
public class DateFormat {
    
    // Fecha Formato YMD HMS
    public static String getDateTime() {
        // Obtener la fecha y hora actual en el formato deseado
        String format = "yyyy-MM-dd_HH.mm.ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }
}
