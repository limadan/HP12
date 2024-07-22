package com.example.hp12;

import java.util.Deque;
import java.util.LinkedList;

public class Calculadora {
    private static final int MODO_EDITANDO = 0;
    private static final int MODO_EXIBINDO= 1;

    public String visor = "";

    private Deque<Double> operandos;
    private int modo_atual;

    public Calculadora(){
        modo_atual = MODO_EXIBINDO;
        operandos = new LinkedList<>();
    }
    public void setNumero(String digito){
        if(modo_atual==MODO_EXIBINDO){
            visor="";
        }
        modo_atual = MODO_EDITANDO;
        visor+=digito;
    }

    public void enter(){
        if(modo_atual==MODO_EDITANDO){
            operandos.push(Double.parseDouble(visor));
            modo_atual = MODO_EXIBINDO;
        }
    }

    public void reset(){
        modo_atual = MODO_EXIBINDO;
        operandos = new LinkedList<>();
        visor="";
    }

    public void soma(){
        double op1 = operandos.pop();
        double op2 = operandos.pop();
        double resultado = op1+op2;

        operandos.push(resultado);
        visor = Double.toString(operandos.getFirst());
    }

    public void subtracao(){
        double op1 = operandos.pop();
        double op2 = operandos.pop();
        double resultado = op1-op2;

        operandos.push(resultado);
        visor = Double.toString(operandos.getFirst());
    }
    public void multiplicacao(){
        double op1 = operandos.pop();
        double op2 = operandos.pop();
        double resultado = op1*op2;

        operandos.push(resultado);
        visor = Double.toString(operandos.getFirst());
    }

    public void divisao(){
        double op1 = operandos.pop();
        double op2 = operandos.pop();

        if (op2 == 0) {
            this.reset();
            visor = "Erro!";
            return;
        }

        double resultado = op1/op2;
        operandos.push(resultado);
        visor = Double.toString(operandos.getFirst());
    }
}
