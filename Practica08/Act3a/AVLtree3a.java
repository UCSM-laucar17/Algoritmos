package Practica08.Act3a;

public class AVLtree3a<E extends Comparable<E>>{
//Inicio Act 3.a
    public class AVLnodo{
        public E dato;
        public int bf;
        public AVLnodo left;
        public AVLnodo right;
        public AVLnodo(E dato){
            this.dato=dato;
            this.bf=0;
            left=null;
            right=null;
        }
        public String toString(){
            return dato+"(bf:"+bf+")";
        }
    }
    protected AVLnodo root;
    protected boolean altura;
    public AVLtree3a(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }
//Fin Act 3.a
}