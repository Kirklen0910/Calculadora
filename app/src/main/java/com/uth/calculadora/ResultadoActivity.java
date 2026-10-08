package com.uth.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {


    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resultado);

        txtResultado = findViewById(R.id.txtResultado);

        double resultado = getIntent().getDoubleExtra("resultado", 0);

        txtResultado.setText("Resultado: " + resultado);
    }
}
