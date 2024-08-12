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
            visor="";
        }else {
            calculatePV();
        }
    }

    public void enterFV(){
        if(modo_atual==MODO_EDITANDO){
            FV = Double.parseDouble(visor);
            modo_atual = MODO_EXIBINDO;
            visor="";
        }else{
            this.calculateFV();
        }
    }

    public void enterPMT(){
        if(modo_atual==MODO_EDITANDO){
            PMT = Double.parseDouble(visor);
            modo_atual = MODO_EXIBINDO;
            visor="";
        }else {
            calculatePMT();
        }
    }

    public void enter_i(){
        if(modo_atual==MODO_EDITANDO){
            i = Double.parseDouble(visor);
            modo_atual = MODO_EXIBINDO;
            visor="";
        }else{
            calculate_i();
        }
    }

    public void enter_n(){
        if(modo_atual==MODO_EDITANDO){
            n = Double.parseDouble(visor);
            modo_atual = MODO_EXIBINDO;
            visor="";
        }else{
            calculate_n();
        }
    }

    public void calculatePMT(){
        PMT = (FV - PV*Math.pow(1 + i, n))/(((Math.pow(1+i, n)-1)/i)*(1+i));
        visor = Double.toString(PMT);
    }

    public void calculatePV(){
        PMT = (FV - PV*Math.pow(1 + i, n))/(((Math.pow(1+i, n)-1)/i)*(1+i));
        visor = Double.toString(PV);
    }

    public void calculateFV(){
        FV = PV * Math.pow(1 + i, n);
        visor = Double.toString(FV);
    }

    public void calculate_i(){
        i = Math.pow(FV / PV, 1.0 / n) - 1;
        visor = Double.toString(i);
    }

    public void calculate_n(){
        n = Math.log(FV / PV) / Math.log(1 + i);
        visor = Double.toString(n);
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
        PV = 1;
        FV = 1;
        i = 0;
        n = 1;
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
