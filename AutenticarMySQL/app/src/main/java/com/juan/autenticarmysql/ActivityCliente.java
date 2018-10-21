package com.juan.autenticarmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityCliente extends AppCompatActivity {

    Button btnNuevoCliente;
    ListView ListaDeClientes;
    ArrayList clientes;

    private void rellenarArrayList() {
        clientes.add(new Cliente("Kamryn", "California", "3121116598" , "kym@gmail.com", R.drawable.kam));
        clientes.add(new Cliente("Alberto", "Guadalajara", "3148976644" , "albert@gmail.com", R.drawable.kam));
        clientes.add(new Cliente("Millie", "Colima", "3120000000" , "emillie@gmail.com", R.drawable.kam));

        // poner codigo que jale datos de la BD y los ponga en el arrayList.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

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
