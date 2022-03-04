package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Calcular extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        Bundle datos = getIntent().getExtras();

        int cifra = datos.getInt("calculo");

        TextView valor_resultado = (TextView) findViewById(R.id.resultado);

        valor_resultado.setText("El doble es: " + cifra);

    }

}
