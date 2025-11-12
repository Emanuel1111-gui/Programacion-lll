import java.util.*;
 
public class MatrizAdyacente {
 
    static class Conexion {
        int vertice;
        int valor;
        Conexion(int vertice, int valor) {
            this.vertice = vertice;
            this.valor = valor;
        }
    }
 // convertir matriz a list o 
    public static List<List<Conexion>> convertir(int[][] matriz) {
        List<List<Conexion>> lista = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            List<Conexion> fila = new ArrayList<>();
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) fila.add(new Conexion(j, matriz[i][j]));
            }
            lista.add(fila);
        }
        return lista;
    }
 
    public static void mostrar(List<List<Conexion>> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print((char)(i + 65) + " -> ");
            for (Conexion c : lista.get(i))
                System.out.print((char)(c.vertice + 65) + "(" + c.valor + ") ");
            System.out.println();
        }
    }
 
    public static void dijkstra(List<List<Conexion>> grafo, int inicio) {
        int n = grafo.size();
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[inicio] = 0;
 
        for (int i = 0; i < n - 1; i++) {
            int u = menor(dist, vis);
            vis[u] = true;
            for (Conexion c : grafo.get(u)) {
                if (!vis[c.vertice] && dist[u] + c.valor < dist[c.vertice])
                    dist[c.vertice] = dist[u] + c.valor;
            }
        }
 
        System.out.println("\nRecorridos más cortos:");
        for (int i = 0; i < n; i++)
            System.out.println((char)(inicio + 65) + " -> " + (char)(i + 65) + " = " + dist[i]);
    }
 
    private static int menor(int[] dist, boolean[] vis) {
        int m = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < dist.length; i++)
            if (!vis[i] && dist[i] <= m) { m = dist[i]; idx = i; }
        return idx;
    }
 // matriz
    public static void main(String[] args) {
        int[][] matriz = {
            {0,2,1,0,0,0},
            {0,0,8,4,0,0},
            {0,0,0,3,2,0},
            {0,0,0,0,6,1},
            {0,0,0,0,0,2},
            {0,0,0,0,0,0}
        };
 
        var lista = convertir(matriz);
        System.out.println("LISTA DE ADYACENCIA:");
        mostrar(lista);
        dijkstra(lista, 0);
    }
}
 