public class ViajeRio {
    public static int[][] costoMinimo(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            C[i][i] = 0;
        }
        for (int longitud = 1; longitud < n; longitud++) {
            for (int i = 0; i < n - longitud; i++) {
                int j = i + longitud;
                // Costo directo
                C[i][j] = T[i][j];
                for (int k = i + 1; k < j; k++) {
                    int costo = T[i][k] + C[k][j];
                    if (costo < C[i][j]) {
                        C[i][j] = costo;
                    }
                }
            }
        }
        return C;
    }
    public static void main(String[] args) {
        int[][] T = {
            {0, 4, 7, 10},
            {0, 0, 2, 6},
            {0, 0, 0, 3},
            {0, 0, 0, 0}
        };
        int[][] C = costoMinimo(T);
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Costo mínimo de 0 a 3: " + C[0][3]);
    }
}

