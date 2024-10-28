package com.myproyect.mistareas2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvTareas;
    private ArrayList<Tarea> tareas;
    private ArrayAdapter<String> tareasAdapter;
    private ArrayList<String> nombresTareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTareas = findViewById(R.id.lvTareas);
        tareas = new ArrayList<>();
        nombresTareas = new ArrayList<>();
        tareasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombresTareas);
        lvTareas.setAdapter(tareasAdapter);

        lvTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetallesTareaActivity.class);
                intent.putExtra("tarea", tareas.get(position));
                startActivity(intent);
            }
        });

        Button btnAddTask = findViewById(R.id.btnAddTask);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroTareaActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Tarea nuevaTarea = (Tarea) data.getSerializableExtra("tarea");
            tareas.add(nuevaTarea);
            nombresTareas.add(nuevaTarea.getNombre());
            tareasAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        tareasAdapter.notifyDataSetChanged(); // Asegura que la lista se actualice al regresar
    }
}
