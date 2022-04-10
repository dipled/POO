package main;


import dados.AnimalDeEstimacao;
import dados.Cliente;
import dados.Endereco;
import dados.Pessoa;
import dados.Quarto;

public class Main {
    private static Endereco endereco1 = new Endereco("México", "722", "Atlântida", "São José", "SC", "88171-451");
    private static Endereco endereco2 = new Endereco();

    private static Pessoa pessoa1 = new Pessoa("Jefferson", false, endereco1);
    private static Pessoa pessoa2 = new Pessoa();
    private static Pessoa pessoa3 = new Pessoa();

    private static Quarto quarto1 = new Quarto(true, 1001, false);
    private static Quarto quarto2 = new Quarto(false);

    private static AnimalDeEstimacao animal1 = new AnimalDeEstimacao("Bella","Gato","Gata gorda");
    private static AnimalDeEstimacao animal2 = new AnimalDeEstimacao();
    
    private static Cliente cliente1 = new Cliente(pessoa1, null, 0, quarto1, animal1);
    private static Cliente cliente2 = new Cliente();

    public static void main(String[] args) {
        endereco2.setRua("Gandalfo");
        endereco2.setBairro("Boa Vista");
        endereco2.setCidade("Joinville");
        endereco2.setEstado("SC");
        endereco2.setNumero("733");
        endereco2.setCep("88302-090");

        pessoa2.setNome("Vanda");
        pessoa2.setEndereco(endereco2);
        pessoa2.setMenorDeIdade(false);

        pessoa3.setNome("Pedro");
        pessoa3.setEndereco(endereco2);
        pessoa3.setMenorDeIdade(true);

        quarto2.setNumero(1002);
        quarto2.setSuite(true);

        cliente2.setPessoaQueReservou(pessoa2);
        cliente2.setAcompanhantes(pessoa3);
        cliente2.setQuantidadeAcompanhantes(1);
        cliente2.setQuarto(quarto2);

        quarto2.setOcupado(true);

        animal2.setNome("Nina");
        animal2.setEspecie("Gato");
        animal2.setDescricao("Gata muito legal!!!");

        cliente2.setAnimal(animal2);

        System.out.println(cliente1.toString());
        System.out.println("\n");
        System.out.println(cliente2.toString());



    }

}
