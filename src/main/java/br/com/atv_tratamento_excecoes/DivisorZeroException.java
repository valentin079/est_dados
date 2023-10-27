package br.com.atv_tratamento_excecoes;

public class DivisorZeroException extends Throwable {
    private String mensagem = "Está tentando dividir por zero";

    public DivisorZeroException(String s) {

    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
