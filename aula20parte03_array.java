public class aula20parte03_array{
    public static void main(String[] args) {
        /* Foreach -> forma simplificada de construir uma string */
        String[] nomes = {"Jotaro Kujo", "Hisoka", "Luffy", "Edward", "Ippo", "Kenshin"}; // vetor de strings

        /* Foreach */
        for(String personagensAnime : nomes){ // a string 'personagensAnime recebe o vetor de String nomes'
            System.out.println(personagensAnime); // Mostra na tela os nomes dos personagens de anime
        }
    }
}