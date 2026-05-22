package Practica08.exceptions;
 
@SuppressWarnings("serial")
public class ItemNotFound extends Exception {
    public ItemNotFound(String message) {
        super(message);
    }
}