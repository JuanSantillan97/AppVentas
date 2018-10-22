package com.juan.autenticarmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    Button btnNuevaVenta, btnClientes, btnProductos;
    ListView lvVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        // Boton Nueva Venta. -------------------------------------------------------------------------------------------------------------------------------
        btnNuevaVenta = findViewById(R.id.btnNuevaVenta);
        btnNuevaVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ActivityVenta.class);
                startActivity(intent);
            }
        });

        // Boton Clientes. ---------------------------------------------------------------------------------------------------------------------------------
        btnClientes = findViewById(R.id.btnClientes);
        btnClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ActivityCliente.class);
                startActivity(intent);
            }
        });

        // Boton Productos. --------------------------------------------------------------------------------------------------------------------------------
        btnProductos = findViewById(R.id.btnProductos);
        btnProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityProducto.class);
                startActivity(intent);
            }
        });

        // Lista Ventas. -----------------------------------------------------------------------------------------------------------------------------------
        lvVentas = findViewById(R.id.lvVentas);
        lvVentas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}
