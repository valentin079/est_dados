package br.com.atividade_dia_21_09_2023;

public class Quadrados extends Quadrilateros{
    private double lado;

    public Quadrados(double lado) {
        super(lado, lado, lado, lado);
        this.lado = lado;
    }

    @Override
    public double perimetro() {
        return super.perimetro();
    }

    @Override
    public double area() {
        return lado*lado;
    }
}
