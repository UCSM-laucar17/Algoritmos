public class TestGen {
    public static void main(String[] args) {
    
    String[] v = {"Perez", "Sanchez", "Rodriguez"};
    Integer[] w = {12, 34, 56};

    System.out.println(exist(v, "Sanchez"));    // true
    System.out.println(exist(w, 34));           //true
    // System.out.println(exist(w, "Salas"));   // Error intencional (tipos incompatibles)
    }
}