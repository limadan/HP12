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

        calculadora.setNumero("5");
        calculadora.enter();
        calculadora.setNumero("10");
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

        calculadora.setNumero("5");
        calculadora.enter();
        calculadora.setNumero("10");
        calculadora.enter();

        calculadora.divisao();

        assertEquals("2.0", calculadora.visor);
    }


    @Test
    public void testDivisaoPorZero() {
        calculadora.reset();

        calculadora.setNumero("0");
        calculadora.enter();
        calculadora.setNumero("10");
        calculadora.enter();

        calculadora.divisao();

        assertEquals("Erro!", calculadora.visor);
    }
}
