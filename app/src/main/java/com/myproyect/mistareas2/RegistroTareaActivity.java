package com.myproyect.mistareas2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroTareaActivity extends AppCompatActivity {

    private EditText etNombre, etDescripcion, etFecha, etPrioridad, etCoste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tarea);

        etNombre = findViewById(R.id.etNombre);
        etDescripcion = findViewById(R.id.etDescripcion);
        etFecha = findViewById(R.id.etFecha);
        etPrioridad = findViewById(R.id.etPrioridad);
        etCoste = findViewById(R.id.etCoste);

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        Button btnCancelar = findViewById(R.id.btnCancelar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String descripcion = etDescripcion.getText().toString();
                String fecha = etFecha.getText().toString();
                String prioridad = etPrioridad.getText().toString();
                double coste = etCoste.getText().toString().isEmpty() ? 0 : Double.parseDouble(etCoste.getText().toString());

                if (!nombre.isEmpty()) {
                    Tarea tarea = new Tarea(nombre, descripcion, fecha, prioridad, coste);
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("tarea", tarea);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    etNombre.setError("El nombre es obligatorio");
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
