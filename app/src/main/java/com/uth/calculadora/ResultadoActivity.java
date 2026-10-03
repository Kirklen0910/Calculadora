package com.uth.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    // Declaramos el TextView que mostrará el resultado
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Conectamos esta actividad con su layout activity_resultado.xml
        setContentView(R.layout.activity_resultado);

        // Vinculamos el TextView del XML con la variable en Java
        txtResultado = findViewById(R.id.txtResultado);

        // Recibimos el resultado enviado desde MainActivity
        double resultado = getIntent().getDoubleExtra("resultado", 0);

        // Mostramos el resultado en pantalla
        txtResultado.setText("Resultado: " + resultado);
    }
}
