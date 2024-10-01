public class FloydWarshall {

    final static int INFINITO = 100000;  // Valor alto para simbolizar el infinito

    public static void main(String[] args) {
        FloydWarshall cm = new FloydWarshall();
        // Representación de los vértices y las conexiones
        int matrizAdyacencia[][] = {
                            {0, 3, INFINITO, 6},  // Vértice A
                            {INFINITO, 0, INFINITO, 5}, // Vértice B
                            {INFINITO, INFINITO, 0, INFINITO}, // Vértice C
                            {INFINITO, INFINITO, 1, 0}   // Vértice D
                        };
        int numeroVertices = matrizAdyacencia.length;
        cm.calcularFloydWarshall(matrizAdyacencia, numeroVertices);
    }

    void calcularFloydWarshall(int matrizAdyacencia[][], int numeroVertices) {
        int matrizDistancias[][] = new int[numeroVertices][numeroVertices];
        
        // Inicializar la matriz de distancias
        for (int fila = 0; fila < numeroVertices; fila++) {
            for (int columna = 0; columna < numeroVertices; columna++) {
                matrizDistancias[fila][columna] = matrizAdyacencia[fila][columna];
            }
        }
        
        // Actualizar la matriz de distancias
        for (int intermedio = 0; intermedio < numeroVertices; intermedio++) {
            for (int origen = 0; origen < numeroVertices; origen++) {
                for (int destino = 0; destino < numeroVertices; destino++) {
                    if (matrizDistancias[origen][intermedio] != INFINITO && matrizDistancias[intermedio][destino] != INFINITO &&
                        matrizDistancias[origen][intermedio] + matrizDistancias[intermedio][destino] < matrizDistancias[origen][destino]) {
                        matrizDistancias[origen][destino] = matrizDistancias[origen][intermedio] + matrizDistancias[intermedio][destino];
                    }
                }
            }
        }

        // Mostrar la matriz de distancias
        imprimirMatriz(matrizDistancias, numeroVertices);
    }

    void imprimirMatriz(int matrizDistancias[][], int numeroVertices) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int fila = 0; fila < numeroVertices; fila++) {
            for (int columna = 0; columna < numeroVertices; columna++) {
                if (matrizDistancias[fila][columna] == INFINITO)
                    System.out.print("INF ");
                else
                    System.out.print(matrizDistancias[fila][columna] + "   ");
            }
            System.out.println();
        }
    }
}
