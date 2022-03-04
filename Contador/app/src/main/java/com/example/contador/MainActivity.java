package com.example.contador;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int contador;

    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = (TextView) findViewById(R.id.textoContador);

        contador = 0;

        textoResultado.setText("" + contador);

        EventoTeclado teclado = new EventoTeclado();

        TextView n_reseteo = (TextView) findViewById(R.id.n_reseteo);

        n_reseteo.setOnEditorActionListener(teclado);

    }

    /* public void onSaveInstanceState(Bundle estado) {

        estado.putInt("cuenta", contador);

        super.onSaveInstanceState(estado);

    }

    public void onRestoreInstanceState(Bundle estado) {

        super.onRestoreInstanceState(estado);

        contador = estado.getInt("cuenta");

        textoResultado.setText("" + contador);

    } */

    public void onPause() {

        super.onPause();

        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor miEditor = datos.edit();

        miEditor.putInt("cuenta", contador);

        miEditor.apply();

    }

    public void onResume() {

        super.onResume();

        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

        contador = datos.getInt("cuenta", 0);

        textoResultado.setText("" + contador);

    }

    class EventoTeclado implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            if(actionId == EditorInfo.IME_ACTION_DONE) {

                reset(null);

            }

            return false;
        }
    }

    public void incrementContador(View vista) {

        contador++;

        textoResultado.setText("" + contador);

    }

    public void decrementContador(View vista) {

        contador--;

        if(contador < 0) {

            CheckBox negativos = (CheckBox) findViewById(R.id.negativos);

            if(!negativos.isChecked()) {

                contador = 0;
            }
        }

        textoResultado.setText("" + contador);

    }

    public void reset(View vista) {

        EditText numero_reset = (EditText) findViewById(R.id.n_reseteo);

        try {

            contador = Integer.parseInt(numero_reset.getText().toString());

        } catch(Exception e) {

            contador = 0;

        }

        numero_reset.setText("");

        textoResultado.setText("" + contador);

        InputMethodManager miTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        miTeclado.hideSoftInputFromWindow(numero_reset.getWindowToken(), 0);

    }

    public void duplicar(View view) {

        TextView numero = (TextView) findViewById(R.id.textoContador);

        int calculo = Integer.parseInt(numero.getText().toString()) * 2;

        Intent i = new Intent(this, Calcular.class);

        i.putExtra("calculo", calculo);

        startActivity(i);

    }

}
