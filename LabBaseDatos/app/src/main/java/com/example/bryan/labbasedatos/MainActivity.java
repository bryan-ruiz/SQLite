package com.example.bryan.labbasedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button orden, plato, insumo, imprimir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orden = (Button) findViewById(R.id.buttonInsertarOrden);
        plato = (Button) findViewById(R.id.buttonInsertarPlato);
        insumo = (Button) findViewById(R.id.buttonInsertarInsumo);
        imprimir = (Button) findViewById(R.id.buttonImprimirOrden);

        orden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InsertarOrden.class);
                startActivity(intent);
            }
        });
        plato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InsertarPlato.class);
                startActivity(intent);
            }
        });
        insumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InsertarInsumo.class);
                startActivity(intent);
            }
        });
        imprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostrarOrdenes.class);
                startActivity(intent);
            }
        });
    }

}
