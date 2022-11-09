public class aula22parte06_array {
    public static void main(String[] args) {
        /* Outra forma de criar matriz multidimensional */
        int[][] matriz = {{0,1}, {2,4,6}, {3,5,7,9}}; // Matriz com 3 linhas e número variado de colunas;
        
        // Foreach
        for(int[] linha : matriz){
            for(int coluna : linha){
                System.out.println(coluna);
            }
        }
    }
}
