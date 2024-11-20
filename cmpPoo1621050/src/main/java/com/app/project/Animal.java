
package com.app.project;

public class Animal {
    // Propiedad nombre
    private String name;
    // Propiedad edad
    private int age;
    // Propiedad alimentacion
    private String feeding;
    // Propiedad color
    private String color;

    // Constructor
    public Animal(
        String name,
        int age,
        String feeding,
        String color
    ) {
        this.name = name;
        this.age = age;
        this.feeding = feeding;
        this.color = color;
    }

    // Mapear valores de nombre
    public String getName() {
        return name;
    }

    // Modificar valores de nombre
    public void setName(String name) {
        this.name = name;
    }

    // Mapear valores de edad
    public int getAge() {
        return age;
    }

    // Modificar valores de edad
    public void setAge(int age) {
        this.age = age;
    }

    // Mapear valores de alimentacion
    public String getFeeding() {
        return feeding;
    }

    // Modificar valores de alimentacion
    public void setFeeding(String feeding) {
        this.feeding = feeding;
    }

    // Mapear valores de nombre
    public String getColor() {
        return color;
    }

    // Modificar valores de nombre
    public void setColor(String color) {
        this.color = color;
    }

    // Metodo o comportamiento del animal
    public void comer() {
        System.out.println(name + " está comiendo.");
    }

    // Metodo o comportamiento del animal
    public void moverse() {
        System.out.println(name + " se está moviendo.");
    }

    // Metodo o comportamiento del animal
    public void respirar() {
        System.out.println(name + " está respirando.");
    }
}
