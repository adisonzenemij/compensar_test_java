
package code;

import java.util.Scanner;

public class Software {
    
    int tope = -1, maximo, npar = 0, nimpar = 0;
    
    public static void main(String[] args) {
        Software pila1 = new Software();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el tamano del vector");
        int maximoVector = teclado.nextInt();
        System.out.println("Ingrese la cantidad de elementos a registrar");
        int cantElementos = teclado.nextInt();
        if (cantElementos <= maximoVector) {
            int[] vector = new int[maximoVector];
            pila1.generar(cantElementos, maximoVector, vector);
            pila1.imprimir(vector);
            pila1.mostrar();

            // Buscar elemento en la posición especificada
            pila1.buscarPorPosicion(vector, 2);
            // Insertar nuevo valor
            pila1.insertar(vector, 45);
            // Actualizar la posición de un valor a otro
            pila1.actualizar(vector, 1, 88);
            // Eliminar elemento en el tope
            pila1.eliminar(vector);
        }    else {
            System.out.println("El vector no puede ser menor que la cantidad de elementos a guardar.");
        }
    }

    public void generar(int cantidadElements, int totalPila, int[] vectorElements) {
        maximo = totalPila;
        for (int i = 0; i < cantidadElements; i++) {
            tope++;
            vectorElements[tope] = (int) Math.floor(Math.random() * 100);
            if (vectorElements[tope] % 2 == 0) {
                npar++;
            } else {
                nimpar++;
            }
        }
    }

    public void imprimir(int[] vectorImpresion) {
        System.out.println("Elements que estan en la Pila");
        for (int i = 0; i < tope; i++) {
            System.out.println("Posicion: " + i + " con valor: " + vectorImpresion[i]);
        }

        System.out.println(
            "El tope de la pila es " + tope + " " +
            "El maximo de la pila es " + maximo
        );
    }

    public void mostrar() {
        System.out.println("El numero de elementos pares son: " + npar);
        System.out.println("El numero de elementos impares son: " + nimpar);
    }

    // a. Buscar un elemento indicando su posición
    public void buscarPorPosicion(int[] vector, int posicion) {
        if (posicion >= 0 && posicion <= tope) {
            System.out.println("Elemento en posicion " + posicion + ": " + vector[posicion]);
        } else {
            System.out.println("La posicion no es valida.");
        }
    }

    // b. Insertar un nuevo elemento en la pila
    public void insertar(int[] vector, int nuevoElemento) {
        if (tope + 1 < maximo) {
            tope++;
            vector[tope] = nuevoElemento;
            if (nuevoElemento % 2 == 0) {
                npar++;
            } else {
                nimpar++;
            }
            System.out.println("Elemento insertado: " + nuevoElemento);
        } else {
            System.out.println("No se puede insertar, la pila esta llena.");
        }
    }

    // c. Actualizar un elemento indicando su posición
    public void actualizar(int[] vector, int posicion, int nuevoValor) {
        if (posicion >= 0 && posicion <= tope) {
            // Recalcular par/impar si cambia
            if (vector[posicion] % 2 == 0) npar--;
            else nimpar--;

            vector[posicion] = nuevoValor;

            if (nuevoValor % 2 == 0) npar++;
            else nimpar++;

            System.out.println(
                "Elemento en posicion " + posicion +
                " actualizado a: " + nuevoValor
            );
        } else {
            System.out.println("La posicion no es valida.");
        }
    }

    // d. Eliminar el elemento del tope de la pila
    public void eliminar(int[] vector) {
        if (tope >= 0) {
            int eliminado = vector[tope];
            if (eliminado % 2 == 0) npar--;
            else nimpar--;
            System.out.println("Elemento eliminado: " + eliminado);
            tope--;
        } else {
            System.out.println("La pila esta vacia, no se puede eliminar.");
        }
    }    
}
