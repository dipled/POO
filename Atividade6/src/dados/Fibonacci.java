package dados;

public class Fibonacci extends Gerador{
    public void gerar(int quantidade){
        if(quantidade > 0){
            this.sequencia.add(1);
        }
        int a = 1;
        int b = 1;
        int contador = 1;
        while(contador < quantidade){
            this.sequencia.add(a);
            a += b;
            b += a;
            contador += 1;
        }
    }
    
}
