package com.juan.autenticarmysql;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.juan.autenticarmysql.Model.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ActivityRegistroCliente extends AppCompatActivity {

    Button btnRegistrarCliente;
    Uri imageUri;
    ImageButton ibCliente;

    EditText etNombreCliente, etDireccionCliente, etTelefonoCliente, etCorreoCliente;

    FirebaseDatabase db;
    DatabaseReference customers;
    DatabaseReference keyP;
    DatabaseReference keyCustomer;

    private FirebaseAuth mAuth;
    private DatabaseReference mUserDatabase;
    private String userID;

    String keyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Vendedores").child(userID);

        // Init firebase.
        db = FirebaseDatabase.getInstance();
        customers = db.getReference("Clientes");
        keyP = customers;
        // Create a empty field(key) in the child Customers.
        keyCustomer = keyP.push();

        etNombreCliente = findViewById(R.id.etNombreCliente);
        etDireccionCliente = findViewById(R.id.etDireccionCliente);
        etTelefonoCliente = findViewById(R.id.etTelefonoCliente);
        etCorreoCliente = findViewById(R.id.etCorreoCliente);

        ibCliente = findViewById(R.id.ibCliente);

        // Boton registrar cliente. -----------------------------------------------------------------------------------------------------------------
        btnRegistrarCliente = findViewById(R.id.btnRegistrarCliente);
        btnRegistrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarCliente();
            }
        });

        // Foto. -----------------------------------------------------------------------------------------------------------------------------------
        ibCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/");
                startActivityForResult(intent.createChooser(intent, "Selecciona la Aplicación"), 10);
            }
        });
    }

    // Metodo para registrar un Cliente. -------------------------------------------------------------------------------------------------------------
    private void registrarCliente(){
        keyDb = keyCustomer.getKey();
        // Save customer to db
        Cliente cliente = new Cliente();
        cliente.setKey(keyDb);
        cliente.setNombre(etNombreCliente.getText().toString());
        cliente.setDireccion(etDireccionCliente.getText().toString());
        cliente.setTelefono(etTelefonoCliente.getText().toString());
        cliente.setCorreo(etCorreoCliente.getText().toString());
        cliente.setImagen("Soy Imagen por URL");

        // Save the product
        customers.child(keyDb)
                .setValue(cliente)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ActivityRegistroCliente.this, "Cliente registrado correctamente", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ActivityRegistroCliente.this, ActivityCliente.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ActivityRegistroCliente.this, "Hubo un problema" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
