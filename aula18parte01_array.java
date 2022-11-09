public class aula18parte01_array{

    public static void main(String[] args) {
        /* Arrays são objetos que referenciam um tipo de dado. Neste caso um inteiro;
         */
        int[] idades = new int[3]; // idades recebem um objeto de array de tamanho 3;

        idades[0] = 10;
        idades[1] = 25;
        idades[2] = 60;

        System.out.println("idade na posição 1 (index 0): "+idades[0]+" anos");
        System.out.println("idade na posição 2 (index 1): "+idades[1]+" anos");
        System.out.println("idade na posição 3 (index 2): "+idades[2]+" anos");


    }

}