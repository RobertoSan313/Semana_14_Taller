package org.example;

public class Main {

    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    static class ListaOrdenada {
        Nodo cabeza = null;

        // Insertar en orden ascendente
        void insertar(int dato) {
            Nodo nuevo = new Nodo(dato);

            if (cabeza == null || dato < cabeza.dato) {
                nuevo.siguiente = cabeza;
                cabeza = nuevo;
                return;
            }

            Nodo actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.dato < dato) {
                actual = actual.siguiente;
            }

            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }

        // Mostrar lista
        void mostrar() {
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        ListaOrdenada lista = new ListaOrdenada();

        lista.insertar(7);
        lista.insertar(2);
        lista.insertar(10);
        lista.insertar(5);

        lista.mostrar();  // salida: 2 -> 5 -> 7 -> 10 -> null
    }
}
