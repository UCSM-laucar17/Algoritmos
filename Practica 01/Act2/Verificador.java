class Verificador{
    //metodos estaticos 
    static boolean esSobrePos(Rectangulo r1,Rectangulo r2){
        //! contrario true
        return !(r1.getEsquina2().x<r2.getEsquina1().x || r1.getEsquina1().x>r2.getEsquina2().x || r1.getEsquina2().y<r2.getEsquina1().y || r1.getEsquina1().y>r2.getEsquina2().y);
    }

    static boolean esJunto(Rectangulo r1,Rectangulo r2){
        return r1.getEsquina2().x==r2.getEsquina1().x || r1.getEsquina1().x==r2.getEsquina2().x || r1.getEsquina2().y==r2.getEsquina1().y ||r1.getEsquina1().y==r2.getEsquina2().y;
    }

    static boolean esDisjunto(Rectangulo r1,Rectangulo r2){
        //contraria !
        //no es sobre y no es junto
        return !esSobrePos(r1,r2) && !esJunto(r1,r2);
    }
}
