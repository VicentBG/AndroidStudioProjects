package com.example.firstappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public void desordenar(View view) {

        EditText et = findViewById(R.id.editText);

        String res = "prova";

        Log.i("Texto: ", res);

        et.setText(res);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
