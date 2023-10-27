package br.com.atividade_dia_21_09_2023;


public class Retangulos extends Quadrilateros{
    private double base;
    private double altura;

    public Retangulos(double base, double altura){
        super(altura, base, altura, base);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double perimetro() {
        return super.perimetro();
    }

    @Override
    public double area() {
        return base*altura;
    }
}
