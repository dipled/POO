import pkg.*;

public class Main {
    private static SistemaProcessos sistema = new SistemaProcessos();
    private static Juiz gustavo = new Juiz(5);
    private static Juiz pedro = new Juiz(5);
    private static Juiz norberto = new Juiz(5);
    private static Processo processo1 = new Processo(1);
    private static Processo processo2 = new Processo(2);
    private static Processo processo3 = new Processo(3);
    private static Processo processo4 = new Processo(4);
    private static Processo processo5 = new Processo(5);
    private static Processo processo6 = new Processo(6);
    private static Processo processo7 = new Processo(7);
    private static Processo processo8 = new Processo(8);
    private static Processo processo9 = new Processo(9);
    private static Processo processo10 = new Processo(10);
    private static Processo processo11 = new Processo(11);
    private static Processo processo12 = new Processo(12);
    private static Processo processo13 = new Processo(13);
    private static Processo processo14 = new Processo(14);
    private static Processo processo15 = new Processo(15);
    private static Processo processo16 = new Processo(16);
    private static Processo processo17 = new Processo(17);
    private static Processo processo18 = new Processo(18);
    public static void main(String[] args) throws Exception {
        gustavo.setNome("Gustavo");
        pedro.setNome("Pedro");
        norberto.setNome("Norberto");
        sistema.cadastrarJuiz(gustavo);
        sistema.cadastrarJuiz(pedro);
        sistema.cadastrarJuiz(norberto);
        sistema.cadastrarProcesso(processo1);
        sistema.cadastrarProcesso(processo2);
        sistema.cadastrarProcesso(processo3);
        sistema.cadastrarProcesso(processo4);
        sistema.cadastrarProcesso(processo5);
        sistema.cadastrarProcesso(processo6);
        sistema.cadastrarProcesso(processo7);
        sistema.cadastrarProcesso(processo8);
        sistema.cadastrarProcesso(processo9);
        sistema.cadastrarProcesso(processo10);
        sistema.cadastrarProcesso(processo11);
        sistema.cadastrarProcesso(processo12);
        sistema.cadastrarProcesso(processo13);
        sistema.cadastrarProcesso(processo14);
        sistema.cadastrarProcesso(processo15);
        sistema.cadastrarProcesso(processo16);
        sistema.cadastrarProcesso(processo17);
        sistema.cadastrarProcesso(processo18);
        try{
            sistema.distribuirProcessos();
        }catch(ProcessoSemJuizException ps){
            System.err.println(ps.getMessage());
        }
    
        


    }
}
