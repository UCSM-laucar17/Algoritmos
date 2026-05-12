package Act8;
import Act6.*;

public class PreOrder<E extends Comparable<E>> extends LinkedBST<E>{
    public void preOrder(){
        System.out.print("Pre Order: ");
        preOrder(this.root);
    }
    private void preOrder(Node actual){
        if (actual != null){
            System.out.print(actual.dato + " ");
            preOrder(actual.left);
            preOrder(actual.right);
        }
    }
}