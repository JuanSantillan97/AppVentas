package com.juan.autenticarmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.juan.autenticarmysql.Model.Cliente;

import java.util.ArrayList;

public class ActivityCliente extends AppCompatActivity {

    Button btnNuevoCliente;
    ListView ListaDeClientes;
    ArrayList clientes;

    private void rellenarArrayList() {
        clientes.add(new Cliente("key1", "Kamryn", "California", "3121116598" , "kym@gmail.com", Integer.toString(R.drawable.kam)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        getSupportActionBar().hide();

        // Boton Nuevo Cliente. ---------------------------------------------------------------------------------------------------------------------------
        btnNuevoCliente = findViewById(R.id.btnNuevoCliente);
        btnNuevoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityRegistroCliente.class);
                startActivity(intent);
            }
        });

        // Lista de Clientes. -----------------------------------------------------------------------------------------------------------------------------
        clientes = new ArrayList<Cliente>();
        ListaDeClientes = findViewById(R.id.lvClientes);
        rellenarArrayList();
        ClientesAdapter adapter = new ClientesAdapter(this, clientes);
        ListaDeClientes.setAdapter(adapter);
        ListaDeClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private String text;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                Cliente elegido = (Cliente) parent.getItemAtPosition(pos);
                Intent intent = new Intent(view.getContext(), ActivityEdicionCliente.class);
                startActivity(intent);
            }
        });

    }
}
