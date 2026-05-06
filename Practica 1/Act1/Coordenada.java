class Coordenada{
    double x,y;
    //constructor sin parametros
    public Coordenada(){
        x=0;
        y=0;
    }
    //constructor valores especificos
    public Coordenada(double x,double y){
        this.x=x;
        this.y=y;
    }
    //constructor para otra coor
    public Coordenada(Coordenada c){
        this.x=c.x;
        this.y=c.y;
    }
    //devuelve x
    double getX(){
        return x;
    }
    //devuelve y
    double getY(){
        return y;
    }
    //cambia x
    void setX(double x){
        this.x=x;
    }
    //cambia y
    void setY(double y){
        this.y=y;
    }
    //metodo instancia distancia this-coor
    double distancia(Coordenada c){
        return Math.sqrt(Math.pow(x-c.x,2)+Math.pow(y-c.y,2));
    }
    //metodo estatico distancia dos coor
    static double distancia(Coordenada c1,Coordenada c2){
        return Math.sqrt(Math.pow(c1.x-c2.x,2)+Math.pow(c1.y-c2.y,2));
    }
    //imprime el obj
    public String toString(){
        return "("+x+","+y+")";
    }
}
