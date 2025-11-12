public class Dijkstra {
    private int numVertices;
    private int[][] grafo;

    public Dijkstra(int[][] grafo) {
        this.grafo = grafo;
        this.numVertices = grafo.length;
    }

    public void calcularRutaCorta(int inicio) {
        int[] distancia = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            distancia[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }
        distancia[inicio] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = minimo(distancia, visitado);
            visitado[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visitado[v] && grafo[u][v] != 0 &&
                    distancia[u] != Integer.MAX_VALUE &&
                    distancia[u] + grafo[u][v] < distancia[v]) {
                    distancia[v] = distancia[u] + grafo[u][v];
                }
            }
        }

        imprimir(distancia, inicio);
    }

    private int minimo(int[] distancia, boolean[] visitado) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < numVertices; v++) {
            if (!visitado[v] && distancia[v] <= min) {
                min = distancia[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void imprimir(int[] distancia, int inicio) {
        System.out.println("\nDistancia más corta desde el nodo " + (char)(inicio + 65) + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println((char)(inicio + 65) + " -> " + (char)(i + 65) + " = " + distancia[i]);
        }
    }
}
