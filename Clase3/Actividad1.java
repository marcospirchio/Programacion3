import java.util.ArrayList;

public class act1 {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1,"Matias",1.9));
        clientes.add(new Cliente(3,"Juan",1.4));
        clientes.add(new Cliente(4,"Raul",1.5));
        clientes.add(new Cliente(5,"Daniela",2.1));
        System.out.println("Scoring maximo " + scoringMaximo(clientes));
    }

    private static Cliente scoringMaximo(ArrayList<Cliente> clientes) {
        return scoringMaximo(clientes,0,clientes.size());
    }

    private static Cliente scoringMaximo(ArrayList<Cliente> clientes, int i, int f) {
        if(i==f-1) return clientes.get(i);
        int mitad = (f+i)/2;
        Cliente izq = scoringMaximo(clientes,i,mitad);
        Cliente der = scoringMaximo(clientes,mitad,f);
        return izq.getScoring()>der.getScoring()?izq:der;
    }
}

class Cliente {
    private int idCliente;
    private String nombre;
    private double scoring;
    Cliente(int idCliente,String nombre, double scoring) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.scoring = scoring;
    }
    public int getIdCliente() {
        return this.idCliente;
    }
    public String getNombre() {
        return this.nombre;
    }
    public double getScoring() {
        return this.scoring;
    }
    
    @Override
    public String toString() {
        return this.nombre + " " + this.idCliente + " " + this.scoring;
    }
}

/*
1.	CasoBase: Si hay un solo cliente, se devuelve ese cliente en tiempo constante O(1)
2.	División: El problema se divide en dos sub problemas de tamaño aproximado n/2
3.	Conquista y Combinación: Se llama recursivamente al método en ambas mitades y se compara el máximo de cada mitad, también en tiempo constante O(1)
Conclusión:
El tiempo de ejecución es lineal con respecto al número de clientes porque el árbol de recursión tiene una profundidad de log^2(n) y en cada nivel se realizan comparaciones en tiempo constante. Por lo tanto, la complejidad total del algoritmo es O(n).
*/
