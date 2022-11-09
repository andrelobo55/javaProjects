public class aula22parte05_array {
    public static void main(String[] args) {
        /* Matrizes com tamanho de colunas diferentes */
        int[][] matriz = new int[2][]; // matriz recebe um vetor de linhas de tamanho 2;
        
        matriz[0] = new int[2]; // linha 1 da matriz recebe 2 colunas;
        matriz[1] = new int[]{4,9,21}; // linha 2 da matriz recebe 3 colunas;

        // foreach da matriz
        for(int[]ref : matriz){
            for(int matrizTotal : ref){
                System.out.println(matrizTotal);
            }
        }
    }
}
