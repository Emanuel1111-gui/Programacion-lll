public class QuickSort {
    public static void sort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pi = particion(arr, inicio, fin);
            sort(arr, inicio, pi - 1);
            sort(arr, pi + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = (inicio - 1);
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }
}
