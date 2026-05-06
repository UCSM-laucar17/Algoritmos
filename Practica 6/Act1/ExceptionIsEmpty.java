package Act1;
//clase para solo la excepcion
public class ExceptionIsEmpty extends Exception{
    public ExceptionIsEmpty(String message){
        super(message); //llama al constructor de Exception
    }
}
