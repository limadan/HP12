package com.example.hp12;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculadoraTest {
    private Calculadora calculadora;

    @Before
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void testMudancaModos() {
        assertEquals(calculadora.MODO_EXIBINDO, calculadora.getModo());
        calculadora.setNumero("1");
        assertEquals(calculadora.MODO_EDITANDO, calculadora.getModo());

        calculadora.enter();
        assertEquals(calculadora.MODO_EXIBINDO, calculadora.getModo());
    }

    @Test
    public void testSoma() {
        calculadora.reset();

        calculadora.setNumero("10");
        calculadora.enter();
        calculadora.setNumero("5");
        calculadora.enter();
        calculadora.soma();

        assertEquals("15.0", calculadora.visor);
    }

    @Test
    public void testSubtracao() {
        calculadora.reset();

        calculadora.setNumero("10");
        calculadora.enter();
        calculadora.setNumero("5");
        calculadora.enter();

        calculadora.subtracao();

        assertEquals("5.0", calculadora.visor);
    }

    @Test
    public void testMultiplicacao() {
        calculadora.reset();

        calculadora.setNumero("10");
        calculadora.enter();
        calculadora.setNumero("5");
        calculadora.enter();

        calculadora.multiplicacao();

        assertEquals("50.0", calculadora.visor);
    }

    @Test
    public void testDivisao() {
        calculadora.reset();

        calculadora.setNumero("10");
        calculadora.enter();
        calculadora.setNumero("5");
        calculadora.enter();

        calculadora.divisao();

        assertEquals("2.0", calculadora.visor);
    }


    @Test
    public void testDivisaoPorZero() {
        calculadora.reset();

        calculadora.setNumero("10");
        calculadora.enter();
        calculadora.setNumero("0");
        calculadora.enter();

        calculadora.divisao();

        assertEquals("Erro!", calculadora.visor);
    }

    @Test
    public void testOperandosInsuficientes() {
        calculadora.reset();
        calculadora.setNumero("1");
        calculadora.enter();
        calculadora.soma();
        assertEquals("1.0", calculadora.visor);

        calculadora.reset();
        calculadora.setNumero("1");
        calculadora.enter();
        calculadora.subtracao();
        assertEquals("-1.0", calculadora.visor);

        calculadora.reset();
        calculadora.setNumero("1");
        calculadora.enter();
        calculadora.multiplicacao();
        assertEquals("0.0", calculadora.visor);

        calculadora.reset();
        calculadora.setNumero("1");
        calculadora.enter();
        calculadora.divisao();
        assertEquals("0.0", calculadora.visor);
    }

    @Test
    public void testPMT (){
        calculadora.reset();
        calculadora.setNumero("0.10");
        calculadora.enter_i();
        calculadora.setNumero("10");
        calculadora.enter_n();
        calculadora.setNumero("1000");
        calculadora.enterPV();
        calculadora.setNumero("1000000");
        calculadora.enterFV();

        calculadora.calculatePMT();
        assertEquals("56893.31771602636", calculadora.PMT);
    }
}
