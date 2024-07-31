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
    }

    public View.OnClickListener numberClick(String s){
        return (v)-> {
            /*int inicioSelecao = visor.getSelectionStart() - 1;
            inicioSelecao = Math.max(inicioSelecao, 0);
            int fimSelecao = visor.getSelectionEnd();
            visor.getText().replace(inicioSelecao, fimSelecao, s);*/

            visor.getText().append(s);
        };
    }
}