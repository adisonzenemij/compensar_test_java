package com.app.project;

public class Jugador {
    // Propiedades
    private String name;
    private String surname;
    private int edad;
    private String posicion;
    private String equipo;
    private String nacionalidad;
    private double velocidad;
    private double altura;
    private double peso;
    private int nroCamiseta;
    
    // Constructor
    public Jugador(
        String name,
        String surname,
        int edad,
        String posicion,
        String equipo,
        String nacionalidad,
        double velocidad,
        double altura,
        double peso,
        int nroCamiseta
    ) {
        this.name = name;
        this.surname = surname;
        this.edad = edad;
        this.posicion = posicion;
        this.equipo = equipo;
        this.nacionalidad = nacionalidad;
        this.velocidad = velocidad;
        this.altura = altura;
        this.peso = peso;
        this.nroCamiseta = nroCamiseta;
    }
    
    // Metodo de la ficha tecnica
    public void fichaTecnica() {
        String message = getName() + " " + getSurname();
        System.out.println("La edad del jugador " + message + " es " + edad);
        System.out.println("La paosicion del jugador " + message + " es " + posicion);
        System.out.println("El equipo del jugador " + message + " es " + equipo);
        System.out.println("La nacionalidad del jugador " + message + " es " + nacionalidad);
        System.out.println("La velocidad del jugador " + message + " es " + velocidad);
        System.out.println("La altura del jugador " + message + " es " + altura);
        System.out.println("El peso del jugador " + message + " es " + peso);
        System.out.println("La numero de la camiseta del jugador " + message + " es " + nroCamiseta);
    }
    
    // Metodo defender del jugador
    public void defender() {
        String message = getName() + " " + getSurname();
        System.out.println("El jugador " + message + " está defendiendo la porteria");
    }
    
    // Metodo correr del jugador
    public void correr() {
        String message = getName() + " " + getSurname();
        System.out.println("El jugador " + message + " está corriendo");
    }
    
    // Metodo patear del jugador
    public void patear() {
        String message = getName() + " " + getSurname();
        System.out.println("El jugador " + message + " ha pateado la pelota");
    }
    
    // Metodo pase del jugador
    public void pasar() {
        String message = getName() + " " + getSurname();
        System.out.println("El jugador " + message + " realizó pase a otro jugador");
    }
    
    // Metodo marcar gol del jugador
    public void anotarGol() {
        String message = getName() + " " + getSurname();
        System.out.println("El jugador " + message + " ha metido un gol en la porteria");
    }
    
    public void recibirTarjeta(String tipoTarjeta) {
        String message = getName() + " " + getSurname();
        if (tipoTarjeta.equalsIgnoreCase("amarilla")) {
            System.out.println(message + " ha recibido una tarjeta amarilla.");
        }
        if (tipoTarjeta.equalsIgnoreCase("roja")) {
            System.out.println(message + " ha recibido una tarjeta roja.");
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }
}
