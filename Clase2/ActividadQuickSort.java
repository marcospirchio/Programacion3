//Clase 2
//Actividad 3

public class ActividadQuickSort {

    // Metodo para realizar QuickSort
    public static void ordenar(int[] lista, int inicio, int fin) {
        if (inicio < fin) {
            // Para encontrar el índice donde se realiza la partición
            int indiceDivision = dividir(lista, inicio, fin);

            // Ordena las dos mitades
            ordenar(lista, inicio, indiceDivision - 1);
            ordenar(lista, indiceDivision + 1, fin);
        }
    }

    // dividimos la lista en dos sublistas
    private static int dividir(int[] lista, int inicio, int fin) {
        int pivote = lista[fin]; // seleccionamos el último elemento como pivote
        int indiceMenor = (inicio - 1); // Índice para los elementos menores

        for (int actual = inicio; actual < fin; actual++) {
            // Si el elemento actual es menor o igual que el pivote
            if (lista[actual] <= pivote) {
                indiceMenor++;
                // Intercambia los elementos
                int temporal = lista[indiceMenor];
                lista[indiceMenor] = lista[actual];
                lista[actual] = temporal;
            }
        }

        // Coloca el pivote en su posición correcta
        int temporal = lista[indiceMenor + 1];
        lista[indiceMenor + 1] = lista[fin];
        lista[fin] = temporal;

        return indiceMenor + 1; // Retorna el índice de partición
    }

}
