package Act3;

public class Node<T>{
    //Atributos del nodo
    public T value; //almacena el dato del nodo
    public Node<T> next; //referencia al siguiente nodo en la lista
    //Nuestro constructor
    public Node(T v){
        value = v;
        this.next = null;
    }
}