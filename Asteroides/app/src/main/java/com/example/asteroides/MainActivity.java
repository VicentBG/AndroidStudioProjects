package com.example.asteroides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
    }

    public void ejecutar_info(View view) {

        Intent i = new Intent(this, InfoActivity.class);

        startActivity(i);

    }

    public void salir(View view) {

        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {

        getMenuInflater().inflate(R.menu.menu_en_main, mimenu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {

        int id = opcion_menu.getItemId();

        if(id == R.id.configuracion) {

            return true;
        }

        if(id == R.id.info) {

            ejecutar_info(null);

            return true;

        }

        return onOptionsItemSelected(opcion_menu);

    }

}
