package com.uth.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir;
    OperacionesMatematicas operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        operaciones = new OperacionesMatematicas();

        btnSumar.setOnClickListener(v -> ejecutarOperacion("suma"));
        btnRestar.setOnClickListener(v -> ejecutarOperacion("resta"));
        btnMultiplicar.setOnClickListener(v -> ejecutarOperacion("multiplicacion"));
        btnDividir.setOnClickListener(v -> ejecutarOperacion("division"));
    }

    private void ejecutarOperacion(String tipo) {
        String n1 = numero1.getText().toString();
        String n2 = numero2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(n1);
        double b = Double.parseDouble(n2);
        double resultado = 0;

        try {
            switch (tipo) {
                case "suma": resultado = operaciones.sumar(a, b); break;
                case "resta": resultado = operaciones.restar(a, b); break;
                case "multiplicacion": resultado = operaciones.multiplicar(a, b); break;
                case "division": resultado = operaciones.dividir(a, b); break;
            }

            // Enviar resultado a ResultadoActivity
            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtra("resultado", resultado);
            startActivity(intent);

        } catch (IllegalArgumentException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
