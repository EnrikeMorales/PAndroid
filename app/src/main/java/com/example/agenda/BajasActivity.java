package com.example.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BajasActivity extends AppCompatActivity {
    private MainActivity.Contactos Contact_aux;
    private ListView lv;
    //private ContactosAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);

        lv = (ListView)findViewById(R.id.lv_id);

        Intent i_aux = getIntent();
        Contact_aux = (MainActivity.Contactos) i_aux.getSerializableExtra("Clase");
        //List<String> prueba = new ArrayList<>();
        //prueba.add("a");
        //cAdapter = new ContactosAdapter(this, Contact_aux.getArrayList());
        ArrayAdapter<MainActivity.Contactos> arrayAdapter = new ArrayAdapter<MainActivity.Contactos>
                (this, android.R.layout.simple_list_item_1, Contact_aux.getArrayList());
        lv.setAdapter(arrayAdapter);
    }

    public void toMainActivity(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("ClaseBaja", Contact_aux);
        startActivity(i);
    }
}
