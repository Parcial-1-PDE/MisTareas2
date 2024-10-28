package com.myproyect.mistareas2.Tarea;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.myproyect.mistareas2.R;

public class DetallesTareaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_tarea);

        // Obtener la tarea pasada como extra en el Intent
        Tarea tarea = (Tarea) getIntent().getSerializableExtra("tarea");

        // Inicializar los TextViews para mostrar los detalles de la tarea
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvDescripcion = findViewById(R.id.tvDescripcion);
        TextView tvFecha = findViewById(R.id.tvFecha);
        TextView tvPrioridad = findViewById(R.id.tvPrioridad);
        TextView tvCoste = findViewById(R.id.tvCoste);

        // Configurar los TextViews con los datos de la tarea
        if (tarea != null) {
            tvNombre.setText(tarea.getNombre());
            tvDescripcion.setText(tarea.getDescripcion().isEmpty() ? "No disponible" : tarea.getDescripcion());
            tvFecha.setText("Fecha: " + (tarea.getFecha().isEmpty() ? "No disponible" : tarea.getFecha()));
            tvPrioridad.setText("Prioridad: " + (tarea.getPrioridad().isEmpty() ? "No especificada" : tarea.getPrioridad()));
            tvCoste.setText(String.format("Coste: %.2f €", tarea.getCoste()));
        }

        // Configuración del botón de Volver
        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
