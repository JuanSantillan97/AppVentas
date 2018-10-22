package com.juan.autenticarmysql;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.juan.autenticarmysql.Model.Vendedor;

public class ActivityRegistro extends AppCompatActivity {

    Button btnRegistrar;

    EditText etUsuario, etContrasena, etDireccion, etTelefono, etCorreo;

    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

        // Init firebase
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Vendedores");

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        etDireccion = findViewById(R.id.etDireccion);
        etTelefono = findViewById(R.id.etTelefono);
        etCorreo = findViewById(R.id.etCorreo);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarVendedor();
            }
        });
    }

    // Metodo para registrar vendedor. --------------------------------------------------------------------------------------------------------------
    private void registrarVendedor(){
        auth.createUserWithEmailAndPassword(etCorreo.getText().toString(), etContrasena.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        // Save user to db
                        Vendedor user = new Vendedor();
                        user.setNombre(etUsuario.getText().toString());
                        user.setCorreo(etCorreo.getText().toString());
                        user.setContrasena(etContrasena.getText().toString());
                        user.setDireccion(etDireccion.getText().toString());
                        user.setTelefono(etTelefono.getText().toString());

                        users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(ActivityRegistro.this, "Vendedor Registrado", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(ActivityRegistro.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        return;
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ActivityRegistro.this, "Hubo algun problema" + e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ActivityRegistro.this, "Hubo algun problema" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
