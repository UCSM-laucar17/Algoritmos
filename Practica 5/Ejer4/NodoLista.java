package Ejer4;

public class NodoLista<T>{
    public T value; 
    public NodoLista<T> siguiente; 
    public NodoLista(T value){
        this.value = value;
        this.siguiente = null;
    }
}