package com.example.hp12;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Calculadora calculadora;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn_ponto;
    Button btn_clear;
    Button btn_enter;
    Button btn_soma;
    Button btn_sub;
    Button btn_multi;
    Button btn_div;
    Button btn_enter_n;
    Button btn_enter_i;
    Button btn_enter_fv;
    Button btn_enter_pv;
    Button btn_calculate_pmt;
    EditText visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn_ponto = findViewById(R.id.btn_ponto);
        btn_soma = findViewById(R.id.btn_soma);
        btn_sub = findViewById(R.id.btn_sub);
        btn_multi = findViewById(R.id.btn_multi);
        btn_div = findViewById(R.id.btn_div);
        btn_clear = findViewById(R.id.btn_clear);
        btn_enter = findViewById(R.id.btn_enter);
        btn_enter_i = findViewById(R.id.btn_enter_i);
        btn_enter_n = findViewById(R.id.btn_enter_n);
        btn_enter_pv = findViewById(R.id.btn_enter_pv);
        btn_enter_fv = findViewById(R.id.btn_enter_fv);
        btn_calculate_pmt = findViewById(R.id.btn_calculate_pmt);

        visor = findViewById(R.id.visor);
        visor.setShowSoftInputOnFocus(false);

        calculadora = new Calculadora();

        btn0.setOnClickListener(numberClick("0"));
        btn1.setOnClickListener(numberClick("1"));
        btn2.setOnClickListener(numberClick("2"));
        btn3.setOnClickListener(numberClick("3"));
        btn4.setOnClickListener(numberClick("4"));
        btn5.setOnClickListener(numberClick("5"));
        btn6.setOnClickListener(numberClick("6"));
        btn7.setOnClickListener(numberClick("7"));
        btn8.setOnClickListener(numberClick("8"));
        btn9.setOnClickListener(numberClick("9"));
        btn_ponto.setOnClickListener(numberClick("."));


        btn_soma.setOnClickListener(somaClick());
        btn_sub.setOnClickListener(subtracaoClick());
        btn_multi.setOnClickListener(multiplicacaoClick());
        btn_div.setOnClickListener(divisaoClick());

        btn_enter_pv.setOnClickListener(enterPV());
        btn_enter_fv.setOnClickListener(enterFV());
        btn_enter_i.setOnClickListener(enter_i());
        btn_enter_n.setOnClickListener(enter_n());
        btn_calculate_pmt.setOnClickListener(enterPMT());

        btn_enter.setOnClickListener(enterClick());
        btn_clear.setOnClickListener(clearClick());
    }

    public View.OnClickListener numberClick(String s){
        return (v)-> {
            if(calculadora.getModo()==calculadora.MODO_EXIBINDO){
                visor.setText("");
            }

            if(visor.getText().toString().contains(".") && s.equals(".")){
                return;
            }

            visor.getText().append(s);
            calculadora.setNumero(s);
        };
    }

    public View.OnClickListener enterClick(){
        return (v)->{
            calculadora.enter();
            visor.setText("");
        };
    }

    public View.OnClickListener enterPV(){
        return (v)->{
            calculadora.enterPV();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener enterFV(){
        return (v)->{
            calculadora.enterFV();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener enter_i(){
        return (v)->{
            calculadora.enter_i();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener enter_n(){
        return (v)->{
            calculadora.enter_n();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener enterPMT(){
        return (v)->{
            calculadora.enterPMT();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener clearClick(){
        return (v)->{
            calculadora.reset();
            visor.setText("");
        };
    }

    public View.OnClickListener somaClick(){
        return (v)->{
            calculadora.soma();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener subtracaoClick(){
        return (v)->{
            calculadora.subtracao();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener divisaoClick(){
        return (v)->{
            calculadora.divisao();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener multiplicacaoClick(){
        return (v)->{
            calculadora.multiplicacao();
            visor.setText(calculadora.visor);
        };
    }

    public View.OnClickListener enterPVClick (){
        return (v)->{
            calculadora.enterPV();
        };
    }

    public View.OnClickListener enterFVClick (){
        return (v)->{
            calculadora.enterFV();
        };
    }

    public View.OnClickListener enterIClick (){
        return (v)->{
            calculadora.enter_i();
        };
    }

    public View.OnClickListener enterNClick (){
        return (v)->{
            calculadora.enter_n();
        };
    }

    public View.OnClickListener calculatePMTClick (){
        return (v)->{
            calculatePMTClick();
        };
    }
}