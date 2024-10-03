import java.util.*;

public class DistribucionElectrica {

    private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int numVertices, List<List<int[]>> grafo) {
        int[] key = new int[numVertices];  //aca almaceno el peso mínimo para incluir cada vértice en el MST
        int[] parent = new int[numVertices];  //aca se almacena el MST resultante
        boolean[] inMST = new boolean[numVertices];  //con este array rastreo vértices incluidos en el MST

        Arrays.fill(key, INF);  //inicializo los valores de key como infinitos
        key[0] = 0;  //comeienzo desde el primer vértice
        parent[0] = -1;  //primer nodo = raíz del MST

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(numVertices, key, inMST);  //selecciona el vértice con el menor valor de Key, que no debe estar en el MST
            inMST[u] = true;  //meto u al MST

            // Actualizar Key y el índice del parent
            for (int[] vecino : grafo.get(u)) {
                int v = vecino[0];
                int peso = vecino[1];

                // Actualizar el Key solo si v no está en el MST y si el peso de (u, v), es MENOR que el Key actual de v
                if (!inMST[v] && peso < key[v]) {
                    key[v] = peso;
                    parent[v] = u;
                }
            }
        }
        
        printMST(parent, numVertices, grafo);
    }

    private static int minKey(int numVertices, int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printMST(int[] parent, int numVertices, List<List<int[]>> grafo) {
        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        int costoTotal = 0;

        for (int i = 1; i < numVertices; i++) {
            for (int[] vecino : grafo.get(i)) {
                if (vecino[0] == parent[i]) {
                    System.out.println(parent[i] + " - " + i + " \tCosto: " + vecino[1]);
                    costoTotal += vecino[1];
                }
            }
        }

        System.out.println("Costo total de la red de distribución: " + costoTotal);
    }

    public static void main(String[] args) {
        int numVertices = 5;  // Número de estaciones eléctricas (ciudades)
        List<List<int[]>> grafo = new ArrayList<>();

        //inicializo grafo
        for (int i = 0; i < numVertices; i++) {
            grafo.add(new ArrayList<>());
        }

        //agrego aristas (estación1, estación2, costo)
        grafo.get(0).add(new int[]{1, 4});  // Ciudad 0 - Ciudad 1 con costo 4
        grafo.get(0).add(new int[]{2, 8});  // Ciudad 0 - Ciudad 2 con costo 8
        grafo.get(1).add(new int[]{0, 4});  // Ciudad 1 - Ciudad 0 con costo 4
        grafo.get(1).add(new int[]{2, 6});  // Ciudad 1 - Ciudad 2 con costo 6
        grafo.get(1).add(new int[]{3, 5});  // Ciudad 1 - Ciudad 3 con costo 5
        grafo.get(2).add(new int[]{0, 8});  // Ciudad 2 - Ciudad 0 con costo 8
        grafo.get(2).add(new int[]{1, 6});  // Ciudad 2 - Ciudad 1 con costo 6
        grafo.get(2).add(new int[]{3, 9});  // Ciudad 2 - Ciudad 3 con costo 9
        grafo.get(3).add(new int[]{1, 5});  // Ciudad 3 - Ciudad 1 con costo 5
        grafo.get(3).add(new int[]{2, 9});  // Ciudad 3 - Ciudad 2 con costo 9
        grafo.get(3).add(new int[]{4, 7});  // Ciudad 3 - Ciudad 4 con costo 7
        grafo.get(4).add(new int[]{3, 7});  // Ciudad 4 - Ciudad 3 con costo 7
        grafo.get(4).add(new int[]{1, 3});  // Ciudad 4 - Ciudad 1 con costo 3


        primMST(numVertices, grafo);
    }
}