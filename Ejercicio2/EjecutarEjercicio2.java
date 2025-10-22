import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EjecutarEjercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prueba del método esBalanceado
        System.out.println("Ingrese una cadena de paréntesis:");
        String cadena = sc.nextLine();
        boolean balance = ExamenPilaMapa.esBalanceado(cadena);
        System.out.println("Balance pila: " + balance);

        // Prueba del método actualizarCalificacion
        Map<Integer, Integer> calificaciones = new HashMap<Integer, Integer>();
        calificaciones.put(101, 70);

        boolean actualizado = ExamenPilaMapa.actualizarCalificacion(calificaciones, 101, 95);
        System.out.println("Actualizado: " + actualizado);
        System.out.println("Nueva calificación del ID 101: " + calificaciones.get(101));

        sc.close();
    }
}
