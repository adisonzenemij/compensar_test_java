
package com.app.project.defaults;

import java.util.ArrayList;
import java.util.List;

public class DHydrate {
    // Lista centralizada de productos de grasas
    private static final List<String> data;

    // Constructor
    private DHydrate() {}

    // Inicializar la lista de productos de grasas
    static {
        data = new ArrayList<>();
        data.add("Papa");
        data.add("Pasta");
        data.add("Pan");
    }

    // Método para obtener la lista de productos de grasas
    public static List<String> getValue() {
        return data;
    }

    // Método para verificar si un producto es de grasas
    public static boolean isValue(String value) {
        return data.contains(value);
    }
}
