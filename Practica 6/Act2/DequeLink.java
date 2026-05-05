package Act2;
import Act1.ExceptionIsEmpty;
public class DequeLink<E> implements Deque<E>{ //vamos a usar interfaz Deque
    private Nodo<E> first; //Nodo inicio
    private Nodo<E> last; //Nodo final 
    public DequeLink(){ //Inicializamos como null porque esta vacio
        first=null;
        last=null;
    }
    public void addFirst(E x){ //aniadimos un nuevo valor 
        Nodo<E> nuevo=new Nodo<>(x); //creamos nodo de referencia
        if(isEmpty()){ 
            first=last=nuevo;//Si esta vacio el primero y ultimo apuntan al nuevo 
        }else{
            nuevo.next=first;//si no esta vacio hacemos que la cola 
            first=nuevo; //hacemso que el nuevo sea el primer elemento
        }
    }
    public void addLast(E x){
        Nodo<E> nuevo=new Nodo<>(x); // creamos nodo de puntero 
        if(isEmpty()){
            first=last=nuevo; // si esta vacio el inicio y fin apuntan al nuevo nodo
        }else{
            last.next=nuevo; //buscamos el final y añadimos el nodo al siguiente 
            last=nuevo; //este nuevo que ingresamos pasa a ser el ultimo 
        }
    }
    public E removeFirst() throws ExceptionIsEmpty{
        if(isEmpty()){ //si esta vacio  lanza excepcion
            throw new ExceptionIsEmpty("vacio");
        }
        E dat=first.dato; //saca el dato de la primera posicion 
        first=first.next; //el segundo objeto pasa a a ser el primero
        if(first==null){ //si esta vacio del inicio estara vacio al final 
            last=null;
        }
        return dat; //retorna el dato a eliminar
    }
    public E removeLast() throws ExceptionIsEmpty{
        if(isEmpty()){
            throw new ExceptionIsEmpty("Deque vacio");
        }
        if(first==last){  //si el primero y el fin apuntan al mismo nodo (osea solo hay un nodo)
            E val=first.dato; //se saca el dato del primero
            first=null; //ambos apuntan a null porque esta vacio
            last=null;
            return val; //retorna el valor eliminado
        }
        Nodo<E> actual=first; //si hay mas de uno
        while(actual.next!=last){ //recorrer la linked list hasta el penultimo
            actual=actual.next; 
        }
        E dat=last.dato; //se saca el ultimo dato
        last=actual; //el penultimo se convertira en el ultimp
        last.next=null; //el nuevo ultimo apuntara a null
        return dat; //retorna el valor eliminado
    }
    public E getFirst() throws ExceptionIsEmpty{
        if(isEmpty()){
            throw new ExceptionIsEmpty("vacio");
        }
        return first.dato; //retorna el valor del nodo a quien apunta el inicio
    }
    public E getLast() throws ExceptionIsEmpty{
        if(isEmpty()){
            throw new ExceptionIsEmpty("vacio");
        }
        return last.dato; //retorna el valor del nodo a quien apunta el fin
    }
    public boolean isEmpty(){
        return first==null; //si el primero es null no hay cola 
    }
    public String toString(){ 
        String s=""; //crea el string acio
        Nodo<E> actual=first; //puntero al nodo
        while(actual!=null){ 
            s+=actual.dato+" "; //dato nodo copiamos al string
            actual=actual.next; //pasa al siguiente 
        }
        return s; //retorna string
    }
}