package dados;

import java.util.Objects;

public class Cliente {
    private Pessoa pessoaQueReservou;
    private Pessoa[] acompanhantes = new Pessoa[10];
    private int quantidadeAcompanhantes = 0;
    private Quarto quarto;
    private AnimalDeEstimacao animal;
    

    public Cliente() {
    }

    public Cliente(Pessoa pessoaQueReservou, Pessoa[] acompanhantes, int quantidadeAcompanhantes, Quarto quarto, AnimalDeEstimacao animal) {
        this.animal = animal;
        this.pessoaQueReservou = pessoaQueReservou;
        this.acompanhantes = acompanhantes;
        this.quantidadeAcompanhantes = quantidadeAcompanhantes;
        this.quarto = quarto;
    }

    public void setAnimal(AnimalDeEstimacao animal){
        this.animal = animal;
    }
    public AnimalDeEstimacao getAnimal(){
        return this.animal;
    }
    public void setQuarto(Quarto quarto){
        this.quarto = quarto;

    }
    public Quarto getQuarto(){
        return this.quarto;
    }
    public int getQuantidadeAcompanhantes() {
        return this.quantidadeAcompanhantes;
    }

    public void setQuantidadeAcompanhantes(int quantidadeAcompanhantes) {
        this.quantidadeAcompanhantes = quantidadeAcompanhantes;
    }

    public Pessoa[] getAcompanhantes() {
        return this.acompanhantes;
    }

    public void setAcompanhantes(Pessoa pessoa) {
        if (this.quantidadeAcompanhantes < 10) {
            this.acompanhantes[quantidadeAcompanhantes] = pessoa;
            this.quantidadeAcompanhantes += 1;
        }
    }

    public Pessoa getPessoaQueReservou() {
        return this.pessoaQueReservou;
    }

    public void setPessoaQueReservou(Pessoa pessoaQueReservou) {
        this.pessoaQueReservou = pessoaQueReservou;
    }

    public String toString(){
        String clienteString = "";
        clienteString += "Quarto reservado: "+this.quarto.getNumero();
        clienteString += "\nPessoa que reservou: "+this.pessoaQueReservou.toString();
        if(this.quantidadeAcompanhantes != 0){
            clienteString += "\nAcompanhantes: ";
            for(int i = 0; i < this.quantidadeAcompanhantes; i += 1)
            {
                clienteString += this.acompanhantes[i].toString();
            }
        }
        if(this.animal != null){
            clienteString += "\n Anmal de estimacao:\n"+this.animal;
        }
        return clienteString;
    
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(acompanhantes, cliente.acompanhantes) && quantidadeAcompanhantes == cliente.quantidadeAcompanhantes && Objects.equals(pessoaQueReservou, cliente.pessoaQueReservou) && Objects.equals(animal, cliente.animal);
    }




}
