package br.com.atv_melhorando_vetores;

public class TestandoVetor {
    public static void main(String[] args) {
        var vetor = new Vetor<Integer>(10,1);
        vetor.Adicionar(1);
        if(vetor.estaVazia()){
            System.out.println("sua lista está vazia");
        }else{
            System.out.println("Ops, sua lista contem elementos");
        };

    }
}
