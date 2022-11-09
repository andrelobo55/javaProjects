public class aula21parte04_array{
    public static void main(String[] args) {
        /* Vetores multidimensionais (matrizes) 
         * matrizes[M][N] -> M = número de linhas e N = número de colunas;
        */
        int[][] diaMes = new int[2][2]; // objeto inteiro diaMes recebe uma matriz de inteiros 2x2
        int i,j;

        /* Preenchendo a matriz */
        diaMes[0][0] = 31; // mes 1 possui 31 dias
        diaMes[0][1] = 30; // mes 2 possui 30 dias
        diaMes[1][0] = 29; // mes 3 possui 20 dias
        diaMes[1][1] = 28; // mes 4 possui 28 dias

        // Mostra os meses
        for(i = 0; i<diaMes.length; i++){
            for(j = 0; j<diaMes.length; j++){
                System.out.println(diaMes[i][j]);
            }
        }
        System.out.println("===================================");
        // Foreach de matriz
        for(int[]referencia : diaMes){
            for(int dia : referencia){
                System.out.println(dia);
            }
        }
    }
}