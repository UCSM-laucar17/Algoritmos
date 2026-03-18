//clase de pruebas - instan obj
public class JavPooAct1{
    public static void main(String[] args){
        //crea obj de la class
        Rectangulo r1=new Rectangulo(
            //param obj coor
            new Coordenada(1,1),
            new Coordenada(4,4)
        );
        //crea obj de la class 2
        Rectangulo r2=new Rectangulo(
            new Coordenada(3,3),
            new Coordenada(6,6)
        );
        //muestra r1 [,]
        System.out.println("R1: "+r1);
        //muestra r2 [,]
        System.out.println("R2: "+r2);

        //llama la class a met con para de rs
        //insta
        System.out.println("Sobrepuestos: "+Verificador.esSobrePos(r1,r2));
        System.out.println("Juntos: "+Verificador.esJunto(r1,r2));
        System.out.println("Disjuntos: "+Verificador.esDisjunto(r1,r2));
    }
}