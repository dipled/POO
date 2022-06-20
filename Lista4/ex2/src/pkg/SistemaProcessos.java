package pkg;

import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class SistemaProcessos {
    private List<Juiz> juizes = new LinkedList<>();
    private List<Processo> processos = new LinkedList<>();
    private Random rand = new Random();

    public void cadastrarJuiz(Juiz juiz) {
        this.juizes.add(juiz);
    }

    public void cadastrarProcesso(Processo processo) {
        this.processos.add(processo);
    }

    public void distribuirProcessos() throws ProcessoSemJuizException {
        int i3 = 0;
        int i2;
        int perm = 0;
        while (!this.processos.isEmpty()) {
            if (i3 > this.juizes.size() - 1) {
                break;
            }
            i2 = rand.nextInt(this.processos.size() - 1);
            try {
                this.juizes.get(i3).cadastrarProcesso(this.processos.get(i2));
                System.out.println("Processo de id "+this.processos.get(i2).getId()+" cadastrado ao juiz "+juizes.get(i3).getNome());
                this.processos.remove(i2);
            } catch (PilhaCheiaException pc) {
                System.err.println("Lista do juiz " + juizes.get(i3).getNome() + " está cheia"); // Tratei essa excessao
                                                                                                 // aqui pois o diagrama
                                                                                                 // uml mostrava ela
                                                                                                 // propagando apenas
                                                                                                 // ate a classe sistema
                i3 += 1;
            }
        }
        for (int i = 0; i < this.juizes.size(); i += 1) {
            if (!(juizes.get(i).getProcessos().getLimite() == juizes.get(i).getProcessos().getSize())) {
                perm = 1;
            }
        }
        if (perm == 0) {
            throw new ProcessoSemJuizException("Lista de todos os juizes cheia");
        }

    }
}
