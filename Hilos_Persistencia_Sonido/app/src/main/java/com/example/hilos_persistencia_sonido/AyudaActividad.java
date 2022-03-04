package com.example.hilos_persistencia_sonido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class AyudaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda_actividad);
    }

    public void volver(View vista) {

        onBackPressed();

    }
}