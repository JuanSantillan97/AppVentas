package com.juan.autenticarmysql;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ActivityVenta extends AppCompatActivity {

    EditText etFecha;
    Spinner spinnerCliente, spinnerProducto;
    Button btnRegistrarVenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);
        getSupportActionBar().hide();

        etFecha = findViewById(R.id.etFecha);
        String date = DateFormat.getDateTimeInstance().format(new Date());
        etFecha.setText(date);

        spinnerCliente = findViewById(R.id.spinnerCliente);
        String[] opcionesCliente = {"Omar","Emily","Alan","Yolanda"};
        ArrayAdapter<String> adapterCliente = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesCliente);
        spinnerCliente.setAdapter(adapterCliente);

        spinnerProducto = findViewById(R.id.spinnerProducto);
        String[] opcionesProducto = {"Jitomates","Manzanas","Mangos","Bananos"};
        ArrayAdapter<String> adapterProducto = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesProducto);
        spinnerProducto.setAdapter(adapterProducto);

        btnRegistrarVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





            }
        });

    }
}
