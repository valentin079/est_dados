package br.com.atividade_dia_21_09_2023;

public abstract class Quadrilateros implements FormaGeometrica{
    private double ladoEsquerdo;
    private double ladoInferior;
    private double ladoDireito;
    private double ladoSuperior;

    public Quadrilateros(double ladoEsquerdo, double ladoInferior, double ladoDireito, double ladoSuperior) {
        this.ladoEsquerdo = ladoEsquerdo;
        this.ladoInferior = ladoInferior;
        this.ladoDireito = ladoDireito;
        this.ladoSuperior = ladoSuperior;
    }

    @Override
    public double perimetro() {
        return ladoDireito+ladoEsquerdo + ladoSuperior + ladoInferior;
    }

}
