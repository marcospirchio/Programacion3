import java.util.ArrayList;
import java.util.Collections;

public class EncontrarNElementosMaximos {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Collections.addAll(numeros, 5, 12, 7, 3, 18, 6, 9, 15, 20, 2);
        
        int n = 3; // Número de elementos más grandes a encontrar
        ArrayList<Integer> maximos = encontrarNElementosMaximos(numeros, n);
        System.out.println("Los " + n + " elementos más grandes son: " + maximos);
    }

    private static ArrayList<Integer> encontrarNElementosMaximos(ArrayList<Integer> numeros, int n) {
        return encontrarNElementosMaximos(numeros, 0, numeros.size(), n);
    }

    private static ArrayList<Integer> encontrarNElementosMaximos(ArrayList<Integer> numeros, int inicio, int fin, int n) {
        if (fin - inicio <= n) {

            ArrayList<Integer> sublista = new ArrayList<>(numeros.subList(inicio, fin));
            Collections.sort(sublista, Collections.reverseOrder());
            return new ArrayList<>(sublista.subList(0, Math.min(n, sublista.size())));
        } else {

            int mitad = (inicio + fin) / 2;
            ArrayList<Integer> izquierda = encontrarNElementosMaximos(numeros, inicio, mitad, n);
            ArrayList<Integer> derecha = encontrarNElementosMaximos(numeros, mitad, fin, n);

            // Combinar los resultados de las dos mitades
            return combinarListas(izquierda, derecha, n);
        }
    }

    private static ArrayList<Integer> combinarListas(ArrayList<Integer> lista1, ArrayList<Integer> lista2, int n) {

        ArrayList<Integer> combinada = new ArrayList<>(lista1);
        combinada.addAll(lista2);
        

        Collections.sort(combinada, Collections.reverseOrder());
        
        // Devolver los primeros n elementos
        return new ArrayList<>(combinada.subList(0, Math.min(n, combinada.size())));
    }
}
