package Act5;
import Ejer4.NodoLista;

public class ListaEnlazada<T extends Comparable<T>> {
    private NodoLista<T> cabeza;
    private int tamanio;
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamanio = 0;
    }
    // Agregar al final
    public void agregar(T value) {
        NodoLista<T> nuevo = new NodoLista<>(value);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
    }
    // Eliminar por value (usa compareTo)
    public boolean eliminar(T value) {
        if (cabeza == null) return false;

        if (cabeza.value.compareTo(value) == 0) {
            cabeza = cabeza.siguiente;
            tamanio--;
            return true;
        }
        NodoLista<T> actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.value.compareTo(value) == 0) {
                actual.siguiente = actual.siguiente.siguiente;
                tamanio--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    // Verificar si existe (usa compareTo)
    public boolean contiene(T value) {
        NodoLista<T> actual = cabeza;
        while (actual != null) {
            if (actual.value.compareTo(value) == 0) return true;
            actual = actual.siguiente;
        }
        return false;
    }
    // Invertir la lista in-place
    public void invertir() {
        NodoLista<T> anterior = null;
        NodoLista<T> actual = cabeza;
        NodoLista<T> siguiente;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        cabeza = anterior;
    }
    // Imprimir todos los elementos
    public void imprimir() {
        if (cabeza == null) {
            System.out.println("  (lista vacía)");
            return;
        }
        NodoLista<T> actual = cabeza;
        while (actual != null) {
            System.out.println("  " + actual.value.toString());
            actual = actual.siguiente;
        }
    }
    public NodoLista<T> getCabeza() { return cabeza; }
    public int getTamanio() { return tamanio; }
    public boolean estaVacia() { return cabeza == null; }
}