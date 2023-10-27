package br.com.atividade_dia_21_09_2023;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testando {
    @Test
    public void retangulosTest() {
        var retangulo1 = new Retangulos(4, 2);
        //Testando Perimetro
        assertEquals(12,retangulo1.perimetro());
        //Testando Area
        assertEquals(8,retangulo1.area());
    }
    @Test
    public void quadradosTest(){
        var quadrado1 = new Quadrados(2);
        assertEquals(4,quadrado1.area());
        assertEquals(8,quadrado1.perimetro());
    }
}
