package com.juan.autenticarmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityEdicionProducto extends AppCompatActivity {

    Button btnEditarProducto, btnEliminarProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion_producto);
        getSupportActionBar().hide();

        // Guardar cambios.
        // Boton editar producto. ----------------------------------------------------------------------------------------------------------------------
        btnEditarProducto = findViewById(R.id.btnEditarProducto);
        btnEditarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





            }
        });

        // Boton eliminar producto. --------------------------------------------------------------------------------------------------------------------
        btnEliminarProducto = findViewById(R.id.btnEliminarProducto);
        btnEliminarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






            }
        });


    }
}
