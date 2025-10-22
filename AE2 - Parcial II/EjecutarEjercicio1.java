import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EjecutarEjercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena de paréntesis:");
        String cadena = sc.nextLine();

        
        int balance = ExamenColaMapa.balanceConCola(cadena);

        if (balance == 0) {
            System.out.println("Balance cola:  los paréntesis están balanceados.");
        } else {
            System.out.println("Balance cola:  los paréntesis NO están balanceados.");
        }

    
        Map<String, Integer> intentos = new HashMap<String, Integer>();
        System.out.println("Intentos (Ana): " + ExamenColaMapa.registrarIntento(intentos, "Ana"));
System.out.println("Intentos (Ana): " + ExamenColaMapa.registrarIntento(intentos, "Ana"));

        sc.close();
    }
}
