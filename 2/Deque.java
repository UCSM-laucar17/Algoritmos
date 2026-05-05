package actividad2;
import actividad1.ExceptionIsEmpty;
public interface Deque<E> { //interfaz metodos de un Deque
    void addFirst(E x); //aniadir al inicio
    void addLast(E x); //aniadir al fin
    E removeFirst() throws ExceptionIsEmpty; //quitar el inicio
    E removeLast() throws ExceptionIsEmpty; //quitar el fin 
    E getFirst() throws ExceptionIsEmpty; //obtener el inicio
    E getLast() throws ExceptionIsEmpty; //obtener el fin
    boolean isEmpty(); //ver si esta vacio
}
