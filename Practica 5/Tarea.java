public class Tarea implements Comparable<Tarea> {
    private String titulo;
    private int prioridad; // 1 = alta, 2 = media, 3 = baja
    private String estado; // "pendiente", "completada
    // Constructor, getters, setters y toString
    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }
}