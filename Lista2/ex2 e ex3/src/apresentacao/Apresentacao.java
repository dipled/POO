package apresentacao;

import dados.*;

import java.util.List;
import java.util.Scanner;

public class Apresentacao {
    private static Matriz<Integer> matriz = new Matriz<>(5, 5);
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i += 1) {
            for (int j = 0; j < 5; j += 1) {
                int valor = Integer.parseInt(scan.nextLine());
                if (valor != -1) {
                    matriz.set(valor, i, j);
                } else {
                    System.out.println("Saindo do programa...");
                    return;
                }
            }
        }

        int menor1 = menorElementodeUmaLista(matriz.getElementosQuadrante(Quadrante.PRIMEIRO));
        int menor2 = menorElementodeUmaLista(matriz.getElementosQuadrante(Quadrante.SEGUNDO));
        int menor3 = menorElementodeUmaLista(matriz.getElementosQuadrante(Quadrante.TERCEIRO));
        int menor4 = menorElementodeUmaLista(matriz.getElementosQuadrante(Quadrante.QUARTO));
        int menor = menor1;
        if (menor > menor2) {
            menor = menor2;
        }
        if (menor > menor3) {
            menor = menor3;
        }
        if (menor > menor4) {
            menor = menor4;
        }

        System.out.println("Menor: " + menor);

    }

    public static int menorElementodeUmaLista(List<Integer> lista) {

        int menor = lista.get(0);

        for (int i = 1; i < lista.size(); i += 1) {
            if (menor > lista.get(i)) {
                menor = lista.get(i);
            }

        }

        return menor;

    }

}
