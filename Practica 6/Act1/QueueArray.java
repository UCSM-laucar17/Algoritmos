package Act1;
public class QueueArray<E> implements Queue<E> { //clase que usara metodos de la interfaz 
    private E[] array; //arreglo Generico
    private int front; //posicion inicio
    private int rear; // posicion final
    private int size; // cantidad de objetos
    @SuppressWarnings("unchecked") //admite un arreglo de objetos sin importar que sea E[]
    public QueueArray(int n) {
        //inicializamos 
        array = (E[]) new Object[n]; //Arreglo de objetos para evitar errores
        front = 0; // el inicio el primero en salir
        rear = -1; // rear porque al insertar un elemeto se pondra en posicion 0 
        size = 0; // el tamanio es 0 porque no hay objetos
    }
    public void enqueue(E x) {
        if (isFull()) throw new RuntimeException(); //si esta lleno lanza excepcion 
        rear = (rear + 1) % array.length; //modularidad para hacer un arreglo circular 
        array[rear] = x; //posicion donde poner el dato
        size++; // pasa a siguiente posicion 
    }
    public E dequeue() throws ExceptionIsEmpty { //anunciamos que usaremos excepcion 
        if (isEmpty()) throw new ExceptionIsEmpty(""); //pone mensaje "" si esta vacia
        E aux = array[front]; //auxiliar para el principio
        front = (front + 1) % array.length; //oreden del objeto segun su opsicion
        size--; //retrocede un espacio al eliminar
        return aux; //retorna lo eliminado
    }
    public E front() throws ExceptionIsEmpty { //vamoa a usar ExceptionIsEmpty
        if (isEmpty()) throw new ExceptionIsEmpty(""); //si esta vacio tiramos la excepcion
        return array[front]; // retorna el primer dato
    }
    public boolean isEmpty() {
        return size == 0; //esta vacio si no hay datos
    }
    public boolean isFull() {
        return size == array.length; //si cantidad de datos es igual al lenght esta lleno
    }
    public String toString() {
        String s = ""; //crea string vacio
        for (int i = 0; i < size; i++) //recorre la cola
            s += array[(front + i) % array.length] + " "; //va insertando datos en el string 
        return s; //retorna el string
    }
}