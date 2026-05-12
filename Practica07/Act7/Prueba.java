package Act7;
import Act4.*;

public class Prueba{
    public static void main(String[] args) throws ItemDuplicated{
        InOrder<Integer> arbol=new InOrder<>();
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);

        arbol.inOrder();
    }
}