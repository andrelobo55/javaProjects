public class aula19parte02_array {
    public static void main(String[] args) {
        /* Valores padrões para os vetores, caso não sejam preenchidos:
         * long, byte, int, float -> 0
         * char -> ' '
         * reference -> null
         * booleana -> false
         */

         String[] nomesAnime = new String[6];   // vetor de String de tamanho 5;
         int i;

         nomesAnime[0] = "JoJo Bizarre's adventures: Stardust Crusaders."; // preenche o vetor de Strings na posição 1
         nomesAnime[1] = "Hunter x Hunter.";
         nomesAnime[2] = "One Piece.";
         nomesAnime[3] = "Fullmetal Alchemist.";
         nomesAnime[4] = "Hajime no Ippo.";
         nomesAnime[5] = "Samurai x.";

         System.out.println("Lista de animes:");
         System.out.print("\n");
         // Mostra na tela o conteúdo do vetor de Strings
         for(i = 0; i < nomesAnime.length; i++){    // .lenght pega o tamanho do array;
            System.out.println((i + 1)+"º anime: " + nomesAnime[i]);
         }
         System.out.print("\n"); // salta um espaço
    }
}
