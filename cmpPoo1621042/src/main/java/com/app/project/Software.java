package com.app.project;

public class Software {
    
    public static void main(String[] args) {
        // Crear variables y asignar valores
        String nombres = "Leonel";
        String apellidos = "Messi";
        int edad = 35;
        String posicion = "Delantero";
        String equipo = "Barcelona";
        String nacionalidad = "Argentina";
        double velocidad = 15;
        double altura = 1.75;
        double peso = 80;
        int nroCamiseta = 10;
        
        // Instanciar clase del jugador
        Jugador data = new Jugador(
        nombres,
        apellidos,
            edad,
            posicion,
            equipo,
            nacionalidad,
            velocidad,
            altura,
            peso,
            nroCamiseta
        );
        
        // Llamar a los diferentes metodos
        data.fichaTecnica();
        data.defender();
        data.correr();
        data.patear();
        data.pasar();
        data.anotarGol();
        data.recibirTarjeta("amarilla");
        data.recibirTarjeta("roja");
    }
}
