package dados;

public class Aluno{
    private String nome;
    private int idade;
    private double[] notas = new double[5];
    private int i = 0;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getNotas() {
        return this.notas;
    }

    public void setNota(double nota) {
        if(i > 4)
            return;
        this.notas[i] = nota;
        i += 1;
    }

    public double calcularMedia(){
        double soma = 0;
        for(int i = 0; i < this.notas.length; i += 1){
            soma += notas[i];
        }
        return soma/this.notas.length;
    }

    public String toString(){
        return "Nome: "+this.nome+"/ Idade: "+this.idade+"/ Média: "+calcularMedia();
    }


}