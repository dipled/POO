package pkg;

public enum Qualidade {
    Q240P, Q360P, Q720P, Q1024P;

    public String getResolucao() {
        switch(this){
            case Q1024P:
                return "1024p";
            case Q720P:
                return "720p";
            case Q360P:
                return "360p";
            case Q240P:
                return "240p";
            default:
                return "Resolução inválida";

        }
    }
}