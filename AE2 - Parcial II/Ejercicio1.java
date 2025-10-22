import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenColaMapa {

    
    static class ColaCircularEnteros {
        private int[] datos;
        private int cabeza;
        private int cola;
        private int tam;

        
        public ColaCircularEnteros(int capacidad) {
            if (capacidad <= 0) capacidad = 1; // evita errores de tamaño
            datos = new int[capacidad];
            cabeza = 0;
            cola = 0;
            tam = 0;
        }

        public boolean estaVacia() {
            return tam == 0;
        }


        public boolean estaLlena() {
            return tam == datos.length;
        }

        public void encolar(int x) {
            if (estaLlena())
                throw new IllegalStateException("Cola llena");
            datos[cola] = x;
            cola = (cola + 1) % datos.length; 
            tam++;
        }

        public int desencolar() {
            if (estaVacia())
                throw new IllegalStateException("Cola vacía");
            int v = datos[cabeza];
            cabeza = (cabeza + 1) % datos.length;
            tam--;
            return v;
        }
    }

    
    public static int balanceConCola(String s) {
        ColaCircularEnteros cola = new ColaCircularEnteros(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cola.encolar(1);
            } else if (c == ')') {
                cola.encolar(-1);
            }
        }

        int suma = 0;
        while (!cola.estaVacia()) {                               // 0 si está balanceado
            suma += cola.desencolar();
        }
        return suma; 
    }

   
    public static int registrarIntento(Map<String, Integer> intentos, String nombre) {
        int valor = 1;
        if (intentos.containsKey(nombre)) {
            valor = intentos.get(nombre) + 1; // incrementa si ya existe
        }
        intentos.put(nombre, valor);
        return valor;
    }
}
