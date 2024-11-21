
package com.app.project.models;

public class mAliment {
    private int id;
    private String name;
    private String detail;
    private int price;
    
    // Constructor
    public mAliment(
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
    
    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for detail
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    // Getter and Setter for price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
