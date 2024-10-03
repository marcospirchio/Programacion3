package actividad3;

import java.util.Arrays;
import java.util.Comparator;

public class SeleccionProyectosGreedy {

    static class Proyecto {
        int costo;
        int beneficio;

        public Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
        }
    }

    public static void main(String[] args) {
        Proyecto[] proyectos = {
            new Proyecto(10, 100),  // Proyecto1
            new Proyecto(15, 200),  // Proyecto2
            new Proyecto(20, 150),  // Proyecto3
            new Proyecto(25, 300)   // Proyecto4
        };

        int presupuesto = 40;
        int maxBeneficio = algoritmoGreedy(proyectos, presupuesto);
        System.out.println("Máximo beneficio (Greedy): " + maxBeneficio);
    }

    public static int algoritmoGreedy(Proyecto[] proyectos, int presupuesto) {
        //ordeno los proyectos por beneficio/costo (mayor a menor)
        Arrays.sort(proyectos, Comparator.comparingDouble(p -> -(double)p.beneficio / p.costo));

        int beneficioTotal = 0;
        int costoTotal = 0;

        for (Proyecto p : proyectos) {
            if (costoTotal + p.costo <= presupuesto) {
                costoTotal += p.costo;
                beneficioTotal += p.beneficio;
            }
        }

        return beneficioTotal;
    }
}

/*
Complejidad:
 Tiempo: O(n log n) // Espacio: O(1)
*/
