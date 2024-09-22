/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.project.model;

/**
 *
 * @author adiso
 */
public class mProduct {
    private int id;
    private String name;
    private int unity;
    private int unitary;
    private String iva;
    private double total;
    private int type;
    
    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y Setter para unity
    public int getUnity() {
        return unity;
    }

    public void setUnity(int unity) {
        this.unity = unity;
    }

    // Getter y Setter para unitary
    public int getUnitary() {
        return unitary;
    }

    public void setUnitary(int unitary) {
        this.unitary = unitary;
    }

    // Getter y Setter para iva
    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    // Getter y Setter para total
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Getter y Setter para type
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
