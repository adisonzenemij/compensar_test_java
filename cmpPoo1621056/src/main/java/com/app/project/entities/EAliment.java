
package com.app.project.entities;

public class EAliment {
    private int id;
    private String name;
    private String detail;
    private int price;
    
    // Constructor
    public EAliment(
        int id,
        String name,
        String detail,
        int price
    ) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }
    
    // Obtener valores de registro
    public int getId() {
        return id;
    }

    // Mapear valores de registro
    public void setId(int id) {
        this.id = id;
    }

    // Obtener valores de nombre
    public String getName() {
        return name;
    }

    // Mapear valores de nombre
    public void setName(String name) {
        this.name = name;
    }

    // Obtener valores de detalle
    public String getDetail() {
        return detail;
    }

    // Mapear valores de detalle
    public void setDetail(String detail) {
        this.detail = detail;
    }

    // Obtener valores de precio
    public int getPrice() {
        return price;
    }

    // Mapear valores de precio
    public void setPrice(int price) {
        this.price = price;
    }
}
