package Practica08.Act3a;
import Practica08.Act3.*;

public class AVLtree3a<E extends Comparable<E>>{
    protected AVLnodo<E> root;
    public AVLtree3a(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }

}