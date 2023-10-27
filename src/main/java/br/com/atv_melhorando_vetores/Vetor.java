package br.com.atv_melhorando_vetores;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class Vetor<T> implements IVetor<T>, Iterable<T> {

    private final int tamVetor; //por padrAo É 10
    private T[] elementos; //como instanciar: (T[]) new  Object[tamVetor]
    private int contElementos; //contador de elementos
    private int vlIncremento; //valor para redimensionar, por padrao o valor eh 10

    //implemente os 3 construtores!

    public Vetor() {
        tamVetor = 10;
        elementos = (T[]) new Object[this.tamVetor];
        contElementos = 0;
        vlIncremento = 10;

    }

    public Vetor(int tamVetor) {
        this.tamVetor = tamVetor;
        elementos = (T[]) new Object[this.tamVetor];
        contElementos = 0;
        vlIncremento = 10;
    }

    public Vetor(int tamVetor, int incremento) {
        this.tamVetor = tamVetor;
        this.vlIncremento = incremento;
        elementos = (T[]) new Object[this.tamVetor];
        contElementos = 0;

    }


    private Iterator<T> myIterator = new Iterator<T>() {

        private int posicao = 0;

        @Override
        public boolean hasNext() {
            if (posicao < contElementos) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                T elemento = elementos[posicao];
                posicao++;
                return elemento;
            }
        }
    };


    @Override
    public void Adicionar(T elemento) {
        this.redimensionar(novoTamanho);
        this.elementos[contElementos] = elemento;
        this.contElementos++;

    }

    @Override
    public void Adicionar(int posicao, T elemento) throws IndexOutOfBoundsException {
        this.redimensionar(novoTamanho);
        if (posicao > tamVetor || posicao < 0) {
            throw new IndexOutOfBoundsException();
        } else if (posicao == contElementos) {
            Adicionar(elemento);
        } else {
            for (int i = contElementos; i > posicao; i--) {
                elementos[i] = elementos[i - 1];
            }
            elementos[posicao] = elemento;
            contElementos++;

        }
    }

    @Override
    public void AdicionarInicio(T elemento) {
        //Redimensionar

        //Inserir na posição inicial
        this.Adicionar(0, elemento);
        //Mover todos para direita
    }

    public void AdicionarElementosPosRandom(Vetor<T> elementos) {
        int qtdElementos = this.elementos.length + elementos.Tamanho();
        if (qtdElementos >= tamVetor) {
            this.redimensionar(novoTamanho);
        }
        if (this.estaVazia()) {
            for (T elemento : elementos) {
                this.Adicionar(elemento);
            }
        } else {
            Random gerador = new Random();
            int[] posicoes = new int[elementos.Tamanho()];
            for (int i = 0; i < posicoes.length; i++) {
                posicoes[i] = gerador.nextInt(this.Tamanho());
                //imprimindo só pra teste
                //System.out.println("posiçao: " + posicoes[i]);
                //FALTA VERIFICAR REPETIÇÕES
            }
            int contPos = 0;
            for (T elemento: elementos) {
                this.Adicionar(posicoes[contPos], elemento);
                contPos++;
            }
        }
    }

    public int PosElemento (T elemento) {
        for (int i = 0; i < Tamanho() ; i++) {
            if ( elemento.equals(elementos[i]) ) {
                return i;
            }
        }
        return -1;
    }

    public void InserirElementoApos(T elementoProcurado,
                                    T elementoParaInserir){

        if (contem(elementoProcurado)) {
            int pos = PosElemento(elementoProcurado)+ 1;
            Adicionar(pos, elementoParaInserir);
        } else {
            System.out.println("Não foi possível inserir o elemento!");
        }

    }

    public void AdicionarElementosPosPares(Vetor<T> elementos){
        if (this.estaVazia()){
            for (T elemento : this.elementos) {
                this.Adicionar(elemento);
            }
        } else {
            int [] pos = new int[this.Tamanho()];
            int tam = 0;

            int par = 0;
            for (int i = 0; i< this.Tamanho(); i = i++) {
                pos[i] = par;
                par = par + 2;
            }

            int cont = 0;
            if (elementos.Tamanho() < this.Tamanho()){
                for (T elemento:elementos) {
                    this.Adicionar(pos[cont],elemento);
                }
            } else {
                //para implementar em casaaaaa
            }

        }
    }


    @Override
    public void Remover(int posicao) throws IndexOutOfBoundsException {
        if (!(estaVazia() || posicao < 0 || posicao >= this.contElementos)) {
            if (posicao == contElementos - 1) {
                this.RemoverFim();
            } else {
                for (int i = posicao; i < this.contElementos - 1; i++) {
                    this.elementos[i] = this.elementos[i + 1];
                }
                //[2,3,4,5,6]
                contElementos--;
            }

        } else {
            throw new IndexOutOfBoundsException("Vetor Vazio ou Posição inválida!");
        }


    }

    @Override
    public void RemoverElemento(T elemento) {
        if (this.contem(elemento)) {
            for (int i = 0; i < this.contElementos; i++) {
                if (elementos[i].equals(elemento)) {
                    //int posicao = i;
                    this.Remover(i);
                    break;
                }
            }

        } else {
            System.out.println("Este elemento não existe na estrutura.");
        }

    }

    @Override
    public void RemoverInicio() {
        this.Remover(0);
    }

    @Override
    public void RemoverFim() {
        if (this.estaVazia()) {
            System.out.println("Vetor vazio");
        } else {
            elementos[contElementos - 1] = null;
            contElementos--;
        }
    }

    @Override
    public int Tamanho() {
        return this.contElementos;
    }

    @Override
    public void Limpar() {
        elementos = (T[]) new Object[this.tamVetor];
        contElementos = 0;

    }

    @Override
    public boolean contem(T elemento) {
        for (int i = 0; i < this.contElementos; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaVazia() {
        if (contElementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void redimensionar(int novoTamanho) {
        if (this.contElementos == this.tamVetor) {
            T[] novoElementos = (T[]) new Object[this.tamVetor + this.vlIncremento];
            for (int i = 0; i < novoElementos.length; i++) {
                novoElementos[i] = elementos[i];
            }
            this.elementos = novoElementos;
        }
    }

    public void redimensionar2() {
        if (this.contElementos == this.tamVetor) {
            T[] novoElementos = (T[]) new Object[this.tamVetor + this.vlIncremento];
            System.arraycopy(this.elementos, 0, novoElementos, 0, novoElementos.length);
            this.elementos = novoElementos;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return myIterator;
    }

    public void mesclarVetores(Vetor<T> outroVetor) {
        int tamanhoOriginal = this.contElementos;
        int tamanhoOutro = outroVetor.Tamanho();
        int novoTamanho = tamanhoOriginal + tamanhoOutro;
        if (novoTamanho > this.tamVetor) {
            redimensionar(novoTamanho);
        }

        int index = 0;
        for (int i = tamanhoOriginal; i < novoTamanho; i++) {
            if (i % 2 == 0) {
                this.elementos[i] = outroVetor.Obter(index);
            } else {
                this.Adicionar(this.elementos[i - 1]);
                this.elementos[i - 1] = outroVetor.Obter(index);
            }
            index++;
        }
    }

//
//    public void mesclarVetores(Vetor<T> outroVetor) {
//        int qtdElementos = this.Tamanho() + outroVetor.Tamanho();
//        if (qtdElementos >= this.tamVetor) {
//            this.redimensionar();
//        }
//
//        if (this.estaVazia()) {
//            for (T elemento : outroVetor) {
//                this.Adicionar(elemento);
//            }
//        } else {
//            Vetor<T> original = new Vetor<>();
//            for (T elemento : this.elementos) {
//                original.Adicionar(elemento);
//            }
//            this.Limpar();
//
//            for (int i = 0; i < original.Tamanho(); i++) {
//                this.Adicionar(original.getElemento(i));
//                if (i < outroVetor.Tamanho()) {
//                    this.Adicionar(outroVetor.getElemento(i));
//                }
//            }
//
//            if (outroVetor.Tamanho() > original.Tamanho()) {
//                for (int i = original.Tamanho(); i < outroVetor.Tamanho(); i++) {
//                    this.Adicionar(outroVetor.getElemento(i));
//                }
//            }
//        }
//    }
//
//    public T getElemento(int posicao) {
//        return this.elementos[posicao];
//    }

    public void InserirPartes(Vetor<T> outroVetor, int quantidade) {
        if (quantidade > outroVetor.Tamanho()) {
            quantidade = outroVetor.Tamanho();
        }

        for (int i = 0; i < quantidade; i++) {
            this.Adicionar(outroVetor.Obter(i));
        }
    }
    public void InverterVetor() {
        int inicio = 0;
        int fim = this.contElementos - 1;
        while (inicio < fim) {
            T temp = this.elementos[inicio];
            this.elementos[inicio] = this.elementos[fim];
            this.elementos[fim] = temp;
            inicio++;
            fim--;
        }
    }

    @Override
    public String toString() {
        if (this.contElementos == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.contElementos - 1; i++) {
            sb.append(this.elementos[i]);
            sb.append(",");
        }
        sb.append(this.elementos[this.contElementos - 1]);
        sb.append("]");
        return sb.toString();
    }


















    //Adicionais

    public T Obter(int posicao) throws IndexOutOfBoundsException {
        if (posicao < 0 || posicao >= contElementos) {
            throw new IndexOutOfBoundsException("Posição fora dos limites.");
        }
        return elementos[posicao];
    }


    public boolean Vazio() {
        return contElementos == 0;
    }



    public int Capacidade() {
        return tamVetor;
    }


    public boolean Cheio() {
        return contElementos == tamVetor;
    }


    public IVetor<T> Clonar() {
        IVetor<T> clone = new Vetor<T>(); // ou qualquer implementação específica que você tenha
        for (int i = 0; i < contElementos; i++) {
            clone.Adicionar(elementos[i]);
        }
        return clone;
    }
    public boolean ElementoNaPosicao(T elemento, int posicao) {
        if (posicao < 0 || posicao >= contElementos) {
            throw new IndexOutOfBoundsException("Posição fora dos limites.");
        }
        return elementos[posicao].equals(elemento);
    }


    public IVetor<T> Concatenar(IVetor<T> outroVetor) {
        IVetor<T> novoVetor = new Vetor<T>(); // ou qualquer implementação específica que você tenha
        for (int i = 0; i < contElementos; i++) {
            novoVetor.Adicionar(elementos[i]);
        }
        for (T elemento : outroVetor) {
            novoVetor.Adicionar(elemento);
        }
        return novoVetor;
    }



    public void Inverter() {
        int inicio = 0;
        int fim = contElementos - 1;
        while (fim > inicio) {
            T temp = elementos[inicio];
            elementos[inicio] = elementos[fim];
            elementos[fim] = temp;
            inicio++;
            fim--;
        }
    }

    public void Substituir(int posicao, T novoElemento) throws IndexOutOfBoundsException {
        if (posicao < 0 || posicao >= contElementos) {
            throw new IndexOutOfBoundsException("Posição fora dos limites.");
        }
        elementos[posicao] = novoElemento;
    }

    public Iterator<T> iteratorReverso() {
        return new Iterator<T>() {
            private int index = contElementos - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                return elementos[index--];
            }
        };
    }
    public void AdicionarTodosAPartirDe(int posicao, Vetor<T> outrosElementos) {
        for (int i = 0; i < outrosElementos.Tamanho(); i++) {
            Adicionar(posicao + i, outrosElementos.Obter(i));
        }
    }

    //Copiar uma porção do vetor para outro vetor:
    public Vetor<T> CopiarPorcao(int inicio, int fim) {
        Vetor<T> porcao = new Vetor<>();
        for (int i = inicio; i <= fim; i++) {
            porcao.Adicionar(elementos[i]);
        }
        return porcao;
    }
    //Trocar dois elementos de posição:
    public void Trocar(int posicao1, int posicao2) {
        T temp = elementos[posicao1];
        elementos[posicao1] = elementos[posicao2];
        elementos[posicao2] = temp;
    }
    //Verificar se o vetor contém uma lista de elementos:
    public boolean ContemTodos(Vetor<T> elementos) {
        for (T elemento : elementos) {
            if (!contem(elemento)) {
                return false;
            }
        }
        return true;
    }
    //Remover todos os elementos de uma lista de outra lista:
    public void RemoverTodos(Vetor<T> elementos) {
        for (T elemento : elementos) {
            RemoverElemento(elemento);
        }
    }

}