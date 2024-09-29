//Clase 2
//Actividad 1
class NodoArbol {
    int dato;
    NodoArbol izquierda, derecha;

    public NodoArbol(int dato) {
        this.dato = dato;
        izquierda = derecha = null;
    }
}

public class ActividadArbolBinario {

    // Método para buscar un valor en el árbol binario de búsqueda (BST)
    public NodoArbol buscarEnArbol(NodoArbol raiz, int valor) {
        // Caso base: si el nodo es nulo o si el valor del nodo es el que estamos buscando
        if (raiz == null || raiz.dato == valor) {
            return raiz;
        }

        // Si el valor que buscamos es menor que el valor del nodo actual, buscamos en el sub árbol izquierdo
        if (valor < raiz.dato) {
            return buscarEnArbol(raiz.izquierda, valor);
        }

        // Si el valor que buscamos es mayor que el valor del nodo actual, buscamos en el sub árbol derecho
        return buscarEnArbol(raiz.derecha, valor);
    }

    private static int calcularAltura(NodoArbol raiz) {
        if (raiz == null) { 
            return -1;
        } else {
            return 1 + Math.max(calcularAltura(raiz.izquierda),
            calcularAltura(raiz.derecha));
        }    
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        // Creamos el árbol de ejemplo
        NodoArbol raiz = new NodoArbol(12);
        raiz.izquierda = new NodoArbol(6);
        raiz.derecha = new NodoArbol(18);
        raiz.izquierda.izquierda = new NodoArbol(4);
        raiz.izquierda.derecha = new NodoArbol(8);
        raiz.derecha.izquierda = new NodoArbol(14);
        raiz.derecha.derecha = new NodoArbol(22);
        raiz.derecha.derecha.derecha = new NodoArbol(26);

        // Buscar el valor 8 en el árbol
        int valorABuscar = 8;
        NodoArbol resultado = arbol.buscarEnArbol(raiz, valorABuscar);
        
        if (resultado != null) {
            System.out.println("El valor " + resultado.dato + " se encuentra en el árbol.");
        } else {
            System.out.println("El valor no fue encontrado en el árbol.");
        }
        System.out.println("Altura del arbol: " + calcularAltura(raiz));
    }
}
