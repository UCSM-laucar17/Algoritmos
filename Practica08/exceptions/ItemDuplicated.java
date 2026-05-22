package Practica08.exceptions;
 
@SuppressWarnings("serial")
public class ItemDuplicated extends Exception {
    public ItemDuplicated(String message) {
        super(message);
    }
}