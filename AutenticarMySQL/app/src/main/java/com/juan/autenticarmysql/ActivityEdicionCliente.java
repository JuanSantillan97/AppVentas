package com.juan.autenticarmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityEdicionCliente extends AppCompatActivity {

    Button btnEditarCliente, btnEliminarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion_cliente);
        getSupportActionBar().hide();

        // Guardar cambios.
        // Boton editar cliente. ----------------------------------------------------------------------------------------------------------------------
        btnEditarCliente = findViewById(R.id.btnEditarCliente);
        btnEditarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





            }
        });

        // Boton eliminar cliente. --------------------------------------------------------------------------------------------------------------------
        btnEliminarCliente = findViewById(R.id.btnEliminarCliente);
        btnEliminarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






            }
        });

    }
}
