package actividad3;

public class SeleccionProyectosDinamica {

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
        int maxBeneficio = programacionDinamica(proyectos, presupuesto);
        System.out.println("Máximo beneficio (Programación Dinámica): " + maxBeneficio);
    }

    public static int programacionDinamica(Proyecto[] proyectos, int presupuesto) {
        int n = proyectos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        //llena la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int p = 0; p <= presupuesto; p++) {
                if (proyectos[i - 1].costo <= p) {
                    dp[i][p] = Math.max(dp[i - 1][p], dp[i - 1][p - proyectos[i - 1].costo] + proyectos[i - 1].beneficio);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }

        //Beneficio máximo
        return dp[n][presupuesto];
    }
}


    /*
    Complejidad:
    O(n×P), donde n es el número de proyectos y P es el presupuesto disponible.
    Es un enfoque eficiente que garantiza una solución óptima.
    */

