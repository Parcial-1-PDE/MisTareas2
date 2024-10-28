package com.myproyect.mistareas2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.myproyect.mistareas2.Tarea.Tarea;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvTareas;
    private ArrayList<Tarea> tareasPendientes;
    private ArrayList<Tarea> tareasHechas;
    private ArrayAdapter<String> tareasAdapter;
    private ArrayList<String> nombresTareas;
    private boolean mostrandoPendientes = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvTareas = findViewById(R.id.lvTareas);
        tareasPendientes = new ArrayList<>();
        tareasHechas = new ArrayList<>();
        nombresTareas = new ArrayList<>();
        tareasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombresTareas);
        lvTareas.setAdapter(tareasAdapter);

        // Registrar el menú contextual para la lista de tareas
        registerForContextMenu(lvTareas);

        lvTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tarea tarea = mostrandoPendientes ? tareasPendientes.get(position) : tareasHechas.get(position);
                Intent intent = new Intent(MainActivity.this, DetallesTareaActivity.class);
                intent.putExtra("tarea", tarea);
                startActivity(intent);
            }
        });

        Button btnHechas = findViewById(R.id.btnHechas);
        Button btnPendientes = findViewById(R.id.btnPendientes);

        btnHechas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrandoPendientes = false;
                actualizarLista();
            }
        });

        btnPendientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrandoPendientes = true;
                actualizarLista();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {
            // Abrir RegistroTareaActivity cuando se hace clic en el botón de añadir
            Intent intent = new Intent(MainActivity.this, RegistroTareaActivity.class);
            startActivityForResult(intent, 1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Tarea nuevaTarea = (Tarea) data.getSerializableExtra("tarea");
            tareasPendientes.add(nuevaTarea);
            actualizarLista();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarLista();
    }

    private void actualizarLista() {
        nombresTareas.clear();
        ArrayList<Tarea> listaActual = mostrandoPendientes ? tareasPendientes : tareasHechas;
        for (Tarea tarea : listaActual) {
            nombresTareas.add(tarea.getNombre());
        }
        tareasAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        if (mostrandoPendientes && item.getItemId() == R.id.menu_hecho) {
            Tarea tareaHecha = tareasPendientes.remove(position);
            tareasHechas.add(tareaHecha);
            actualizarLista();
            return true;
        } else if (item.getItemId() == R.id.menu_eliminar) {
            (mostrandoPendientes ? tareasPendientes : tareasHechas).remove(position);
            actualizarLista();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
