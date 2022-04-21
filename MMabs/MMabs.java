import java.util.Scanner;

public class MMabs {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        s.useDelimiter(";");

        int somaQuartaLinha = 0;
        int somaSegundaColuna = 0;
        int somaDP = 0;
        int somaDS = 0;
        int auxI = 1; //Sempre 1
        int auxJ = 5; //Sempre o numero de colunas/linhas

        int[][] matriz = new int[5][5];

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                matriz[i][j] = s.nextInt();
                if(i == 3)
                {
                    somaQuartaLinha += matriz[i][j];
                }
                if(j == 2)
                {
                    somaQuartaLinha += matriz[i][j];
                }
                if(i == j)
                {
                    somaDP += matriz[i][j];
                }
                if(i == auxI && j == auxJ)
                {
                    somaDS = matriz[i][j];
                }
                auxI += 1;
                auxJ -= 1;
            }
            s.nextLine();
        }

        System.out.println(somaQuartaLinha);
        System.out.println(somaSegundaColuna);
        System.out.println(somaDP);
        System.out.println(somaDS);

        int soma = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                soma += matriz[i][j]; //tb pode ser "soma = soma + matriz[i][j];"
            }
        }
        System.out.println(soma);
        s.close();
    }
} 