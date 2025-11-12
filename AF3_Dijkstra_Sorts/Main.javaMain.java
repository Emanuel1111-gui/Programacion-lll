import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] grafo = {
            {0, 2, 1, 0, 0, 0},
            {0, 0, 8, 4, 0, 0},
            {0, 0, 0, 3, 2, 0},
            {0, 0, 0, 0, 6, 1},
            {0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0}
        };

        System.out.println("=== AF3 - PF - Dijkstra + Métodos de Ordenamiento ===");
        System.out.println("Estudiante: Emanuel Hurtado Torres - UNIAJC");
        System.out.println("1. Ejecutar Dijkstra");
        System.out.println("2. Ejecutar Métodos de Ordenamiento");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                Dijkstra d = new Dijkstra(grafo);
                d.calcularRutaCorta(0); // Desde nodo A
                break;

            case 2:
                int[] datos = {5, 1, 4, 2, 8};
                System.out.println("\nArreglo original: " + Arrays.toString(datos));

                int[] copia1 = datos.clone();
                BubbleSort.sort(copia1);
                System.out.println("Burbuja: " + Arrays.toString(copia1));

                int[] copia2 = datos.clone();
                QuickSort.sort(copia2, 0, copia2.length - 1);
                System.out.println("QuickSort: " + Arrays.toString(copia2));

                int[] copia3 = datos.clone();
                MergeSort.sort(copia3, 0, copia3.length - 1);
                System.out.println("MergeSort: " + Arrays.toString(copia3));

                int[] copia4 = datos.clone();
                InsertionSort.sort(copia4);
                System.out.println("Inserción: " + Arrays.toString(copia4));

                int[] copia5 = datos.clone();
                SelectionSort.sort(copia5);
                System.out.println("Selección: " + Arrays.toString(copia5));
                break;

            default:
                System.out.println("Opción no válida.");
        }

        sc.close();
    }
}
