import java.util.ArrayList;

public class EncontrarDosMayores {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(12);
        numeros.add(7);
        numeros.add(3);
        numeros.add(18);
        numeros.add(6);
        numeros.add(9);

        Resultados resultados = encontrarDosMayores(numeros);
        System.out.println("Dos números mayores: " + resultados.max1 + " y " + resultados.max2);
    }

    private static Resultados encontrarDosMayores(ArrayList<Integer> numeros) {
        return encontrarDosMayores(numeros, 0, numeros.size());
    }

    private static Resultados encontrarDosMayores(ArrayList<Integer> numeros, int inicio, int fin) {
        if (fin - inicio == 1) {
            // Caso base: solo un número
            return new Resultados(numeros.get(inicio), Integer.MIN_VALUE);
        } else if (fin - inicio == 2) {
            // Caso base: dos números
            int num1 = numeros.get(inicio);
            int num2 = numeros.get(inicio + 1);
            if (num1 > num2) {
                return new Resultados(num1, num2);
            } else {
                return new Resultados(num2, num1);
            }
        } else {
            // Dividir la lista en dos partes
            int mitad = (inicio + fin) / 2;
            Resultados izq = encontrarDosMayores(numeros, inicio, mitad);
            Resultados der = encontrarDosMayores(numeros, mitad, fin);

            // Encontrar los dos mayores combinados
            return combinarResultados(izq, der);
        }
    }

    private static Resultados combinarResultados(Resultados izq, Resultados der) {
        // Inicializar los dos mayores globales
        int max1 = Math.max(izq.max1, der.max1);
        int max2;

        // Determinar el segundo mayor
        if (izq.max1 > der.max1) {
            max2 = Math.max(izq.max2, der.max1);
        } else {
            max2 = Math.max(izq.max1, der.max2);
        }

        return new Resultados(max1, max2);
    }

    // Clase para almacenar los dos números mayores encontrados
    private static class Resultados {
        int max1;
        int max2;

        Resultados(int max1, int max2) {
            this.max1 = max1;
            this.max2 = max2;
        }
    }
}


/*
1) Caso Base:
  - Caso base con un solo número (fin - inicio == 1): El algoritmo simplemente devuelve ese número y el valor mínimo posible 
    (Integer.MIN_VALUE). Este paso se realiza en tiempo constante O(1).
  - Caso base con dos números (fin - inicio == 2): Compara los dos números y devuelve el mayor y el menor. 
    También se realiza en tiempo constante O(1).

2) División:
    El problema se divide en dos subproblemas de tamaño aproximado n/2 cada uno. Esto ocurre en el paso recursivo 
    donde el problema se divide en dos partes iguales: int mitad = (inicio + fin) / 2;
    Resultados izq = encontrarDosMayores(numeros, inicio, mitad);
    Resultados der = encontrarDosMayores(numeros, mitad, fin);

3. Conquista y Combinación:
    Conquista: Se realiza recursivamente sobre cada mitad de la lista, encontrando los dos números mayores en cada una de ellas.
    Combinación: Después de obtener los resultados de las dos mitades, se combinan para determinar 
    los dos números mayores globales en la función combinarResultados. Este paso también se realiza en tiempo constante O(1).

Conclusión:
    En cada nivel del árbol de recursión se hace un trabajo O(n) debido a la combinación de resultados.
    La profundidad del árbol es O(log n), ya que el problema se divide en dos partes iguales en cada nivel.
    Por lo tanto, el tiempo total de ejecución es O(n log n) debido al trabajo lineal en cada nivel de profundidad logarítmica.
*/
