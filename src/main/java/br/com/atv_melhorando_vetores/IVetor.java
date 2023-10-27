package br.com.atv_melhorando_vetores;

import java.util.Iterator;

public interface IVetor<T> {

    //Adiciona o elemento na ultima posição disponivel
    public void Adicionar(T elemento);

    //adicionar na posicao indicada pelo usuario
    //lanca excecao quando foi uma posicao invalida
    public void Adicionar(int posicao, T elemento) throws IndexOutOfBoundsException;

    //adicionar o elemento na primeira posicao
    public void AdicionarInicio(T elemento);

    //remover o elemento na posicao indicada pelo usuario
    //lancar excecao quando for posicao invalida
    public void Remover(int posicao) throws IndexOutOfBoundsException;

    //buscar o elemento e remove-lo
    public void RemoverElemento(T elemento);

    //remover o primeiro elemento do vetor
    public void RemoverInicio();

    //remover o ultimo elemento do vetor
    public void RemoverFim();

    //retorna a quantidade de elementos adicionados no vetor
    public int Tamanho();

    //retira todos os elementos do  vetor (restata o vetor)
    public void Limpar();

    //busca o elemento
    public boolean contem(T elemento);

    //Retorna os elementos entre colchetes e entre vírgulas
    //Por exemplo, se forem adicionados os elementos 1, 2 e 3
    //o toString devolve a string [1,2,3]
    public String toString();

    //retorna o iterator
    public Iterator<T> iterator();

}
