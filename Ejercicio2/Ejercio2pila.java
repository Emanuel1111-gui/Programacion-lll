import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    
    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 significa que está vacía

        public PilaEnteros(int capacidad) {
            if (capacidad <= 0) capacidad = 1;
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() {
            return tope == -1;
        }

        public boolean estaLlena() {
            return tope + 1 == datos.length;
        }

        public void apilar(int x) {
            if (estaLlena()) throw new IllegalStateException("Pila llena");
            tope++;
            datos[tope] = x;
        }

        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException("Pila vacía");
            int v = datos[tope];
            tope--;
            return v;
        }
    }

   
    public static boolean esBalanceado(String s) {
        PilaEnteros pila = new PilaEnteros(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {      // Verifica si los paréntesis están balanceados usando pila
                pila.apilar(1);
            } else if (c == ')') {
                if (pila.estaVacia()) {
                    return false; // hay más ')' que '('
                }
                pila.desapilar();
            }
        }
        return pila.estaVacia(); 
    }

  
    public static boolean actualizarCalificacion(Map<Integer, Integer> califPorId, int id, int nuevo) {
        if (nuevo < 0 || nuevo > 100) return false;
        if (!califPorId.containsKey(id)) return false;
        califPorId.put(id, nuevo);
        return true;
    }
}
