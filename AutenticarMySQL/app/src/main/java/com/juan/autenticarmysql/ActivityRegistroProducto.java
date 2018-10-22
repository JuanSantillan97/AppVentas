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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.juan.autenticarmysql.Model.Cliente;
import com.juan.autenticarmysql.Model.Producto;

public class ActivityRegistroProducto extends AppCompatActivity {

    Button btnRegistrarProducto;
    EditText etNombreProducto, etPrecioCostoProducto, etCantidadProducto, etPrecioVentaProducto, etDescripcionProducto;

    FirebaseDatabase db;
    DatabaseReference productos;
    DatabaseReference keyP;
    DatabaseReference keyCustomer;

    private FirebaseAuth mAuth;
    private DatabaseReference mUserDatabase;
    private String userID;

    String keyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_producto);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Vendedores").child(userID);

        // Init firebase.
        db = FirebaseDatabase.getInstance();
        productos = db.getReference("Productos");
        keyP = productos;
        // Create a empty field(key) in the child Customers.
        keyCustomer = keyP.push();

        etNombreProducto = findViewById(R.id.etNombreProducto);
        etPrecioCostoProducto = findViewById(R.id.etPrecioCostoProducto);
        etCantidadProducto = findViewById(R.id.etCantidadProducto);
        etPrecioVentaProducto = findViewById(R.id.etPrecioVentaProducto);
        etDescripcionProducto = findViewById(R.id.etDescripcionProducto);

        // Boton registrar producto. -----------------------------------------------------------------------------------------------------------------
        btnRegistrarProducto = findViewById(R.id.btnRegistrarProducto);
        btnRegistrarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarProducto();
            }
        });
    }

    // Metodo para registrar un Cliente. -------------------------------------------------------------------------------------------------------------
    private void registrarProducto(){
        keyDb = keyCustomer.getKey();
        // Save customer to db
        Producto producto = new Producto();
        producto.setkey(keyDb);
        producto.setNombreP(etNombreProducto.getText().toString());
        producto.setPrecioCosto(Integer.valueOf(etPrecioCostoProducto.getText().toString()));
        producto.setCantidad(Integer.valueOf(etPrecioVentaProducto.getText().toString()));
        producto.setPrecioVenta(Integer.valueOf(etCantidadProducto.getText().toString()));
        producto.setDescripcion(etDescripcionProducto.getText().toString());
        producto.setImagenP("Soy Imagen por URL");

        // Save the product
        productos.child(keyDb)
                .setValue(producto)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ActivityRegistroProducto.this, "Producto registrado correctamente", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ActivityRegistroProducto.this, ActivityProducto.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ActivityRegistroProducto.this, "Hubo un problema" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
