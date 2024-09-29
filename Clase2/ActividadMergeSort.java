public class ActividadMergeSort {

    // MergeSort
    public static void fusionarOrden(int[] lista) {
        if (lista.length < 2) {
            return; // Si el array tiene 1 o menos elementos, no necesita ordenarse
        }
        int puntoMedio = lista.length / 2;

        //dividimos el arreglo en dos partes
        int[] ladoIzquierdo = new int[puntoMedio];
        int[] ladoDerecho = new int[lista.length - puntoMedio];

        //Copiamos los elementos en las dos partes
        for (int x = 0; x < puntoMedio; x++) {
            ladoIzquierdo[x] = lista[x];
        }
        for (int y = puntoMedio; y < lista.length; y++) {
            ladoDerecho[y - puntoMedio] = lista[y];
        }

        //recursividad para ordenar ambas partes
        fusionarOrden(ladoIzquierdo);
        fusionarOrden(ladoDerecho);

        //Mezclamos las partes ordenadas
        mezclar(lista, ladoIzquierdo, ladoDerecho);
    }

    // Método para combinar dos mitades ordenadas
    private static void mezclar(int[] lista, int[] ladoIzquierdo, int[] ladoDerecho) {
        int i = 0, j = 0, k = 0;

        // Combinar los elementos de ambas mitades
        while (i < ladoIzquierdo.length && j < ladoDerecho.length) {
            if (ladoIzquierdo[i] <= ladoDerecho[j]) {
                lista[k++] = ladoIzquierdo[i++];
            } else {
                lista[k++] = ladoDerecho[j++];
            }
        }

        // Copiar los elementos restantes del lado izquierdo
        while (i < ladoIzquierdo.length) {
            lista[k++] = ladoIzquierdo[i++];
        }

        // Copiar los elementos restantes del lado derecho
        while (j < ladoDerecho.length) {
            lista[k++] = ladoDerecho[j++];
        }
    }

}
