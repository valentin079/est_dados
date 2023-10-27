package br.com.atv_tratamento_excecoes;

import org.junit.jupiter.api.Test;

public class CalculoMatematicoTeste {
    @Test
    public void testandoMetodo(){
        CalculoMatematico calculo = new CalculoMatematico();
        try{
            calculo.dividir(4,0);
        }catch (DivisorZeroException e){
            System.out.println(e.getMessage());
        }

    }


}
