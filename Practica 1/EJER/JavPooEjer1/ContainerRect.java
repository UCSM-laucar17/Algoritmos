//save r en arreglo de obj
class ContainerRect{
    //arreg T obj
    Rectangulo[] rectangulos;
    double[] distancias;
    double[] areas;
    int n;
    //var statica
    static int numRec=0;
    //n inici
    public ContainerRect(int n){
        this.n=n;
        //por defecto
        rectangulos=new Rectangulo[n];
        distancias=new double[n];
        areas=new double[n];
    }
    public void addRectangulo(Rectangulo r){
        //si raho maxr puedo tener
        if(numRec<n){
            //new r dentro de arre r
            rectangulos[numRec]=r;
            //rpos insta
            distancias[numRec]=Coordenada.distancia(r.getEsquina1(),r.getEsquina2());
            //area con - y *
            areas[numRec]=Math.abs((r.getEsquina2().getX()-r.getEsquina1().getX())*(r.getEsquina2().getY()-r.getEsquina1().getY()));
            numRec++;
        }else{
            System.out.println("No hay espacio");
        }
    }
    @Override
    public String toString(){
        // /tabulacion
        String s = "Rectangulo\tCoordenadas\tDistancia\tArea\n";
        //recorre
        for (int i = 0; i < numRec; i++){
            //s arriba
            s += (i + 1) + "\t" + rectangulos[i] + "\t" + distancias[i] + "\t" + areas[i] + "\n";
        }
    return s;
    }
}