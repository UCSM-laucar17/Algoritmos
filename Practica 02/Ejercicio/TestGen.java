public class TestGen{ 
    public static void main(String[]args){           
        Cajoneria<Golosina> caj = new Cajoneria<>(); 
        Caja<Golosina> c1 = new Caja<>("Rojo"); 
        Caja<Golosina> c2 = new Caja<>("Azul"); 
        Caja<Golosina> c3 = new Caja<>("Verde"); 
        Caja<Golosina> c4 = new Caja<>("Amarillo"); 
        Caja<Golosina> c5 = new Caja<>("Negro"); 
        c1.setObjeto(new Golosina("Caramelo",0.5)); 
        c2.setObjeto(new Golosina("Chicle",0.2)); 
        c3.setObjeto(new Golosina("Gomita",0.3)); 
        c4.setObjeto(new Golosina("Chocolate",1.0)); 
        c5.setObjeto(new Golosina("Galleta",0.8)); 
        caj.add(c1); 
        caj.add(c2); 
        caj.add(c3); 
        caj.add(c4); 
        caj.add(c5); 
        System.out.println(caj); 
        System.out.println(caj.search(new Golosina("Chicle",0.2))); 
        System.out.println(caj.search(new Golosina("Caramelo",0.5))); 
        System.out.println(caj.search(new Golosina("GLoboPop",1.0))); 
        System.out.println("Eliminado: "+caj.delete(new Golosina("Chicle",0.2)));   
        System.out.println(caj); 
    } 
} 




