package encadeadaLista;


public class ListaEncadeada <T>{

    private Celula primeira; //apontador para primeira celula da lista
    private Celula ultima; //apontador para a ultima celula da lista
    private int totalElementos;
    private int tamanho;

    public ListaEncadeada(){
        this.primeira = null;
        this.ultima = null;
        this.tamanho = 0;
        //construtor
    }
    private Celula pegaCelula(int posicao) {
        Celula atual = this.primeira;
        Iterador<T> it = new Iterador<T>(atual);
        while (it.hasNext()) {
            for (int i=0; i <= posicao; i++) {
                atual = atual.getProximo();
            }
            break;
            it.next();
        }

        return atual;
    }
    public void adiciona(T elemento,int posicao) throws Exception{
        if (this.tamanho == 0 || posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Argumento fora de alcance.");
        }

        else if (posicao == 0) {
            adicionaInicio(elemento);
        }

        else if (posicao == this.tamanho) {
            adicionaFim(elemento);
        }

        else {
            Celula atual = this.primeira;
            Celula aux = this.pegaCelula(posicao-2);
            Celula newCelula = new Celula(elemento);
            Iterador<T> it = new Iterador<T>(atual);
            while (it.hasNext()) {
                for (int i=0; i <= posicao; i++) {
                    atual = atual.getProximo();
                    if (i == posicao) {
                        if (atual != null) {
                            newCelula.getProximo() = aux.getProximo();
                            aux.getProximo() = newCelula;
                        }
                    }
                }
                break;
                it.next();
            }
            this.tamanho++;
        }
    }
    public void adicionaInicio(T elemento){
        Celula nova = new Celula(this.primeira,elemento); //criando um nó na lista encadeada
        this.primeira = nova;
        if(this.totalElementos==0){ //caso de lista vazia
            this.ultima = this.primeira;
        }
        this.totalElementos++;
    }
    public void adicionaFim(T elemento){
        Celula newCelula = new Celula(elemento);

        if (this.tamanho == 0) {
            adicionaInicio(elemento);
        }
        else {
            this.ultima.getProximo()= newCelula;
            this.ultima = newCelula;
            this.tamanho++;
        }
    }
    public T recupera(int posicao) throws{
        if(this.tamanho== 0){
            throw new IllegalArgumentException ("A lista está vazia!!");

        } else if(posicao < 0 || posicao >= this.tamanho){
            System.out.println("A posição "+ posicao+" é inválida!");
            return null;
        } else{
            Iterador it = new Iterador(this.primeira);
            int i = 0;
            while (it.hasNext()){
                if(i != posicao){
                    it.next();
                    i++;
                } else{
                    break;
                }
            }
            return (T) it.getAtual().getElemento();
        }
    }
    public boolean contem(T elemento){
        Celula atual = this.primeira;
        boolean cond = false;
        Iterador<T> it = new Iterador<T>(atual);
        while (it.hasNext()) {
            for (int i=0; i < this.tamanho; i++) {
                if (atual.elementos.Equals(elemento)) {
                    cond = true;
                    break;
                }

                if (atual.getProximo() != null) {
                    atual = atual.getProximo();
                }
                else {
                    break;
                }
            }
            break;
            it.next();
        }
        return cond;
    }
    public void remove(int posicao)  throws Exception{
        if(this.tamanho== 0 ){
            throw new IllegalArgumentException("A lista está vazia!!");

        } else if(posicao < 0 || posicao >= this.tamanho){
            System.out.println("A posição "+ posicao+" é inválida!");

        } else if(this.primeira == this.ultima){
            this.primeira = null;
            this.ultima = null;
            this.tamanho --;
        } else {
            Celula atual = this.primeira;
            Celula aux = this.pegaCelula(posicao-2);
            Celula aux2 = this.pegaCelula(posicao);
            Iterador<T> it = new Iterador<T>(atual);
            while (it.hasNext()) {
                for (int i=0; i <= posicao; i++) {
                    atual = atual.getProximo();
                    if (i == posicao) {
                        if (atual != null) {
                            atual = aux;
                            atual.getProximo()= aux2;
                        }
                    }
                }
                break;
                it.next();
            }
            this.tamanho--;
        }



    }
    public void removeInicio(){
        if(this.tamanho== 0){
            System.out.println("A lista está vazia!!");

        } else if(primeira == ultima){ //se a lista possui apenas um elemento
            primeira = ultima = null; //removendo o nó
            this.totalElementos--;
        } else{
            primeira = primeira.getProximo(); //o atual item recebe o atual ligado ao proximo
            //substituindo o valor do inicio da lista pelo valor q era do  proximo, assim o proximo passa a ser o atual primeiro
            this.totalElementos--; //decrementa
        } if(this.totalElementos == 0){
            this.ultima = null;
        }

    }
    public void removeFim(){
        if(this.tamanho== 0){
            System.out.println("A lista está vazia!!");

        } else if(primeira == ultima){
            primeira = ultima = null;
            this.tamanho -=1;

        }
        else {
            this.tamanho--;
            Celula atual = this.primeira;
            Iterador<T> it = new Iterador<T>(atual);
            while (it.hasNext()) {
                for (int i=0; i != this.tamanho-1; i++) {
                    atual = atual.setProximo();
                    this.ultima = atual;
                }
                break;
                it.next();
            }

    }
    public int tamanho(){
        return this.tamanho;
    }

    public void limpa(){
        this.primeira = null;
        this.ultima = null;
        this.tamanho = 0;
    }
}
