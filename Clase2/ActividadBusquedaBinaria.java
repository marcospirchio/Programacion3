//Clase 2
//Actividad 2
public class BusquedaBinaria {

    public static int buscarElemento(int[] lista, int elementoBuscado) {
        int inicio = 0;
        int fin = lista.length - 1;

        while (inicio <= fin) {
            int mitad = inicio + (fin - inicio) / 2;

            if (lista[mitad] == elementoBuscado) {
                return mitad; 
            }

            if (lista[mitad] < elementoBuscado) {
                inicio = mitad + 1;
            } 
            else {
                fin = mitad - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] lista = {2, 4, 6, 8, 10, 12, 14};
        int elementoBuscado = 8;
        int posicion = buscarElemento(lista, elementoBuscado);

        if (posicion == -1) {
            System.out.println("Elemento no encontrado en la lista.");
        } else {
            System.out.println("Elemento encontrado en la posición: " + posicion);
        }
    }
}
