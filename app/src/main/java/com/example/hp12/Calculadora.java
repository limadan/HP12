package com.example.hp12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.BiFunction;

public class Calculadora {
    public static final int MODO_EDITANDO = 0;
    public static final int MODO_EXIBINDO= 1;

    public String visor = "";

    private Deque<Double> operandos;
    private int modo_atual;

    public double PV;
    public double PMT;
    public double FV;
    public double i;
    public double n;

    public int getModo(){
        return modo_atual;
    }
    public Calculadora(){
        PV = 1;
        FV = 1;
        i = 0;
        n = 1;
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

    public void enterPV(){
        if(modo_atual==MODO_EDITANDO){
            PV = Double.parseDouble(visor);
            modo_atual = MODO_EXIBINDO;
        }
    }

    public void enterFV(){
        if(modo_atual==MODO_EDITANDO){
            FV = Double.parseDouble(visor);
            modo_atual = MODO_EXIBINDO;
        }
    }

    public void enter_i(){
        if(modo_atual==MODO_EDITANDO){
            i = Double.parseDouble(visor);
            modo_atual = MODO_EXIBINDO;
        }
    }

    public void enter_n(){
        if(modo_atual==MODO_EDITANDO){
            n = Double.parseDouble(visor);
            modo_atual = MODO_EXIBINDO;
        }
    }

    public double calculatePMT(){
        PMT = (FV - PV*Math.pow(1 + i, n))/(((Math.pow(1+i, n)-1)/i)*(1+i));
        return PMT;
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

    public void executarOperacao(BiFunction<Double, Double, Double> operacao){
        if(!visor.isEmpty()){
            this.enter();
        }
        double op1 = Optional.ofNullable(operandos.pollFirst()).orElse(0.0);
        double op2 = Optional.ofNullable(operandos.pollFirst()).orElse(0.0);
        double resultado = operacao.apply(op1, op2);

        if(resultado==Double.POSITIVE_INFINITY){
            this.reset();
            this.visor = "Erro!";
            return;
        }

        operandos.push(resultado);
        visor = Double.toString(operandos.getFirst());
    }

    public void subtracao(){
        executarOperacao((op1, op2) -> op2 - op1);
    }

    public void soma(){
        executarOperacao((op1, op2) -> op1 + op2);
    }
    public void multiplicacao(){
        executarOperacao((op1, op2) -> op1 * op2);
    }

    public void divisao(){
        executarOperacao((op1, op2) -> op2 / op1);
    }


}
