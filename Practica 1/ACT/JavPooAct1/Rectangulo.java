class Rectangulo{
    Coordenada esquina1;
    Coordenada esquina2;
    public Rectangulo(Coordenada c1,Coordenada c2){
        esquina1=new Coordenada(c1); //crea c1
        esquina2=new Coordenada(c2); //crea c2
    }
    //retorma e1
    Coordenada getEsquina1(){
        return esquina1;
    }
    //retorna e2
    Coordenada getEsquina2(){
        return esquina2;
    }
    //crea los rectan
    void setEsquina1(Coordenada c){
        esquina1=new Coordenada(c);
    }
    void setEsquina2(Coordenada c){
        esquina2=new Coordenada(c);
    }
    //retorna las coor [,]
    public String toString(){
        return "["+esquina1+" , "+esquina2+"]";
    }
}
