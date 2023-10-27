package br.com.atv_melhorando_vetores;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class VetorTest {


    private Vetor<Integer> listaInteira;
    private Vetor<String>  listaString;

    @Before
    public void setUp() throws Exception {
        listaInteira = new Vetor<Integer>(5,20);
        listaString = new Vetor<String>();
    }

    @Test
    public void AdicionarTest() {
        listaInteira.Adicionar(7);
        assertEquals("[7]", listaInteira.toString());
    }

    @Test
    public void AdicionarStringTest() {
        listaString.Adicionar("A");
        assertEquals("[A]", listaString.toString());
    }

    @Test
    public void Adicionar2ElementosTest() {
        listaInteira.Adicionar(7);
        listaInteira.Adicionar(8);
        assertEquals("[7,8]", listaInteira.toString());
    }

    @Test
    public void Adicionar2ElementosStringTest() {
        listaString.Adicionar("A");
        listaString.Adicionar("B");
        assertEquals("[A,B]", listaString.toString());
    }
    @Test
    public void AdicionarRedimensionandoTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        listaInteira.Adicionar(4);
        listaInteira.Adicionar(5);
        listaInteira.Adicionar(6);
        listaInteira.Adicionar(7);
        listaInteira.Adicionar(8);
        listaInteira.Adicionar(9);
        listaInteira.Adicionar(10);
        listaInteira.Adicionar(11);
        listaInteira.Adicionar(12);
        listaInteira.Adicionar(13);
        listaInteira.Adicionar(14);
        listaInteira.Adicionar(15);
        listaInteira.Adicionar(16);
        listaInteira.Adicionar(17);
        listaInteira.Adicionar(18);
        listaInteira.Adicionar(19);
        listaInteira.Adicionar(20);
        listaInteira.Adicionar(21);
        assertEquals("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21]", listaInteira.toString());
    }


    @Test
    public void AdicionarPosicaoTest() {
        listaInteira.Adicionar(0, 1);
        assertEquals("[1]", listaInteira.toString());
    }

    @Test
    public void AdicionarPosicaoStringTest() {
        listaString.Adicionar(0, "A");
        assertEquals("[A]", listaString.toString());
    }


    @Test
    public void AdicionarPosicaoString2Test() {
        listaString.Adicionar(0, "A");
        listaString.Adicionar(0, "B");
        listaString.Adicionar(1, "C");
        listaString.Adicionar(1, "D");
        assertEquals("[B,D,C,A]", listaString.toString());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void AdicionarPosicaoNegativaTest() {
        listaInteira.Adicionar(-1, 1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void AdicionarPosicaoExtraTest() {
        listaInteira.Adicionar(20, 1);
    }

    @Test
    public void AdicionarInicioTest() {
        listaInteira.AdicionarInicio(3);
        listaInteira.AdicionarInicio(2);
        listaInteira.AdicionarInicio(1);
        assertEquals("[1,2,3]", listaInteira.toString());
    }

    @Test
    public void AdicionarInicioRedimensionandoTest() {
        listaInteira.AdicionarInicio(12);
        listaInteira.AdicionarInicio(11);
        listaInteira.AdicionarInicio(10);
        listaInteira.AdicionarInicio(9);
        listaInteira.AdicionarInicio(8);
        listaInteira.AdicionarInicio(7);
        listaInteira.AdicionarInicio(6);
        listaInteira.AdicionarInicio(5);
        listaInteira.AdicionarInicio(4);
        listaInteira.AdicionarInicio(3);
        listaInteira.AdicionarInicio(2);
        listaInteira.AdicionarInicio(1);
        assertEquals("[1,2,3,4,5,6,7,8,9,10,11,12]", listaInteira.toString());
    }

    @Test
    public void RemoverPosTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        listaInteira.Remover(0);
        assertEquals("[2,3]", listaInteira.toString());
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void RemoverPosInexitenteTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        listaInteira.Remover(-1);
        System.out.println(listaInteira.toString());
    }

    @Test
    public void RemoverElementoTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        listaInteira.RemoverElemento(2);
        assertEquals("[1,3]", listaInteira.toString());
    }

    @Test
    public void RemoverElementoInexistenteTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        listaInteira.RemoverElemento(4);

        assertEquals("[1,2,3]", listaInteira.toString());
    }

    @Test
    public void RemoverInicioTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        listaInteira.RemoverInicio();
        assertEquals("[2,3]", listaInteira.toString());
    }



    public void RemoverInicioListaVaziaTest() {
        listaInteira.RemoverInicio();
        assertEquals("[]", listaInteira.toString());
    }

    @Test
    public void RemoverFimTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        listaInteira.RemoverFim();
        assertEquals("[1,2]", listaInteira.toString());
    }


    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void RemoverFimListaVaziaTest() {
        listaInteira.RemoverFim();
    }

    @Test
    public void TamanhoTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        assertEquals(3, listaInteira.Tamanho());
    }

    @Test
    public void TamanhoVaziaTest() {
        assertEquals(0, listaInteira.Tamanho());
    }


    @Test
    public void LimparTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        listaInteira.Limpar();
        assertEquals("[]", listaInteira.toString());
    }

    @Test
    public void LimparListaVaziaTest() {
        listaInteira.Limpar();
        assertEquals("[]", listaInteira.toString());
    }

    @Test
    public void ContemTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        assertEquals(true, listaInteira.contem(2));
    }

    @Test
    public void ContemFalseTest() {
        listaInteira.Adicionar(1);
        listaInteira.Adicionar(2);
        listaInteira.Adicionar(3);
        assertEquals(false, listaInteira.contem(5));
    }

    @Test
    public void TestInterator() {
        listaInteira.Adicionar(8);
        Iterator<Integer> i = listaInteira.iterator();
        int valor = i.next();
        assertEquals(8, valor);
    }

    @Test
    public void TestInterator2() {
        listaInteira.Adicionar(8);
        for (Integer i : listaInteira) {
            System.out.println(i);
        }
    }


}