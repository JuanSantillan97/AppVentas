package com.juan.autenticarmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.juan.autenticarmysql.Model.Producto;

import java.util.ArrayList;

public class ActivityProducto extends AppCompatActivity {

    Button btnNuevoProducto;
    ListView ListaDeProductos;
    ArrayList productos;

    private void rellenarArrayList() {
        productos.add(new Producto("keyProducto123","Jitomates",50 ,1, 25, "Mexico Colima", Integer.toString(R.drawable.jitomates)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        getSupportActionBar().hide();

        // Boton Nuevo Producto. ---------------------------------------------------------------------------------------------------------------------------
        btnNuevoProducto = findViewById(R.id.btnNuevoProducto);
        btnNuevoProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityRegistroProducto.class);
                startActivity(intent);
            }
        });

        // Lista de Productos. -----------------------------------------------------------------------------------------------------------------------------
        productos = new ArrayList<Producto>();
        ListaDeProductos = findViewById(R.id.lvProductos);
        rellenarArrayList();
        ProductosAdapter adapter = new ProductosAdapter(this, productos);
        ListaDeProductos.setAdapter(adapter);
        ListaDeProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private String text;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                Producto elegido = (Producto) parent.getItemAtPosition(pos);
                Intent intent = new Intent(view.getContext(), ActivityEdicionProducto.class);
                startActivity(intent);
            }
        });

    }
}
