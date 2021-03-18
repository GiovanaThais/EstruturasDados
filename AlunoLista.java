package encadeadaLista;

public class AlunoLista {
    private String nome;
    private AlunoLista proximo; //variavel do tipo alunolista

    public AlunoLista(){
        this.nome =" ";
    }
    public AlunoLista(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

}

