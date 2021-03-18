package encadeadaLista;

import encadeadaLista.AlunoLista;
import encadeadaLista.ListaEncadeada;

public class Main{
    public static void main(String[] args) throws Exception {

        AlunoLista a1 = new AlunoLista("Giovana");
        AlunoLista a2 = new AlunoLista("Ana");
        AlunoLista a3 = new AlunoLista("Julia");
        AlunoLista a4 = new AlunoLista("Thais");

        ListaEncadeada lista = new ListaEncadeada();

        lista.adicionaInicio(a1);  //a1
        lista.adicionaInicio(a2);  //a2 a1
        lista.adicionaInicio(a3);  //a3 a2 a1
        lista.adiciona(a2,1); //a2 a3 a2 a1
        lista.adiciona(a4,4);

        //lista.removeInicio();

        a1 = (AlunoLista) lista.recupera(0); //pos 0 retorna a primeira adicionada
        a2 = (AlunoLista) lista.recupera(1); //pos 1 retorna a segunda add

        System.out.println(a1.getNome() );
        System.out.println(a2.getNome() );

    }
}