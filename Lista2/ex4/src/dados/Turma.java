package dados;

import java.util.List;
import java.util.Random;
import java.util.Comparator;
import java.util.LinkedList;
public class Turma {
    private List<Aluno> alunos = new LinkedList<>();
    private Comparator<Aluno> compararPorMedia = (Aluno a1, Aluno a2) -> Double.compare((-1)*a1.calcularMedia(),
            (-1)*a2.calcularMedia());

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        this.ordenarAlunosPorMedia();
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Comparator<Aluno> getCompararPorMedia() {
        return this.compararPorMedia;
    }

    public void setCompararPorMedia(Comparator<Aluno> compararPorMedia) {
        this.compararPorMedia = compararPorMedia;
    }


    private void ordenarAlunosPorMedia() {
        this.alunos.sort(compararPorMedia);
    }

    public List<Equipe<Aluno>> separarEmEquipes() {
        if (this.alunos.size() < 3) {
            return null;
        }
        List<Aluno> auxiliar = new LinkedList<>();
        List<Equipe<Aluno>> retorno = new LinkedList<>();
        Random rand = new Random();
        int tamEquipe, comeco, fim;
        auxiliar.addAll(alunos);
        while (true) {
            if (auxiliar.size() < 3) {
                return retorno;
            }
            if (auxiliar.size() == 3) {
                tamEquipe = 3;
            }
            if (auxiliar.size() == 4) {
                tamEquipe = 4;
            } else {
                tamEquipe = rand.ints(3, 4).findFirst().getAsInt();
            }
            Equipe<Aluno> equipe = new Equipe<>();
            if (tamEquipe == 3) {
                comeco = rand.ints(1, 2).findFirst().getAsInt();
                if (comeco == 1) {
                    fim = 2;
                } else {
                    fim = 1;
                }
            } else {
                comeco = 2;
                fim = 2;
            }
            for (int i2 = 0; i2 < comeco; i2 += 1) {
                equipe.getLista().add(auxiliar.get(0));
                auxiliar.remove(0);
                if (auxiliar.isEmpty()) {
                    equipe.getLista().sort(compararPorMedia);
                    retorno.add(equipe);
                    return retorno;
                }
            }
            for (int i3 = 0; i3 < fim; i3 += 1) {
                equipe.getLista().add(auxiliar.get(auxiliar.size()-1));
                auxiliar.remove(auxiliar.size()-1);
                if (auxiliar.isEmpty()) {
                    equipe.getLista().sort(compararPorMedia);
                    retorno.add(equipe);
                    return retorno;
                }
            }
            equipe.getLista().sort(compararPorMedia);
            retorno.add(equipe);
            auxiliar.sort(compararPorMedia);
            System.out.println("EqSize: "+equipe.getLista().size());
        }

    }

}
