package negocio;

import dados.*;
import exceptions.*;

import java.util.LinkedList;
import java.util.List;

public class Zoologico {
    private List<Animal> animais = new LinkedList<>();
    private List<Viveiro> viveiros = new LinkedList<>();



    public List<Animal> getAnimais() {
        return this.animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Viveiro> getViveiros() {
        return this.viveiros;
    }

    public void setViveiros(List<Viveiro> viveiros) {
        this.viveiros = viveiros;
    }




    public void cadastrarViveiro(Viveiro viveiro) {
        this.viveiros.add(viveiro);
    }

    public void cadastrarAnimal(Animal animal) {
        this.animais.add(animal);
    }

    public void alocarAnimal(Animal animal, Viveiro viveiro) throws EspacoIndisponivelException{
        if (viveiro.espacoDisponivel() <= animal.calculaEspacoOcupado() + 0.70 * animal.calculaEspacoOcupado()) {
            throw new EspacoIndisponivelException("Espaco indisponivel");
           
        } else
            viveiro.adicionarAnimal(animal);
        }
    
    public List<Aquario> getSoAquarios(){
        List<Aquario> retorno = new LinkedList<>();

        for(int i = 0; i < this.viveiros.size(); i += 1){
            if(this.viveiros.get(i) instanceof Aquario)
            {
                retorno.add((Aquario)this.viveiros.get(i));
            }
        }
        return retorno;
    }
    public List<Viveiro> getSoViveiros(){
        List<Viveiro> retorno = new LinkedList<>();

        for(int i = 0; i < this.viveiros.size(); i += 1){
            if(!(this.viveiros.get(i) instanceof Aquario))
            {
                retorno.add(this.viveiros.get(i));
            }
        }
        return retorno;
    }


}
