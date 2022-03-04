package com.example.hilos_persistencia_sonido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ayuda(View vista) {

        Intent intencion = new Intent(this, AyudaActividad.class);

        startActivity(intencion);

    }
}