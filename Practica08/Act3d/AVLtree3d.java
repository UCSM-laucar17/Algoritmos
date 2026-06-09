package Practica08.Act3d;
import Practica08.Act3.*;

public class AVLtree3d<E extends Comparable<E>>extends AVLtree<E>{
//Incicio Act 3.d
    protected AVLnodo rotRight(AVLnodo y){
        AVLnodo x=y.left;
        AVLnodo t2=x.right;
        x.right=y;
        y.left=t2;
        return x;
    }
    protected AVLnodo rotLeft(AVLnodo x){
        AVLnodo y=x.right;
        AVLnodo t2=y.left;
        y.left=x;
        x.right=t2;
        return y;
    }
    public void preOrder(){
        System.out.print("AVL: ");
        preOrderRec(root);
        System.out.println();
    }
    private void preOrderRec(AVLnodo actual){
        if(actual!=null){
            System.out.print(actual+" ");
            preOrderRec(actual.left);
            preOrderRec(actual.right);
        }
    }
//Fin ACt 3.d
}