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
    private ArrayList<Contacto> Contact_aux;
    private ListView lv;
    //private ContactosAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
        Intent i_aux = getIntent();
        Contact_aux = (ArrayList<Contacto>) i_aux.getSerializableExtra("listaContactos");
        lv = (ListView)findViewById(R.id.lv_id);

        //List<String> prueba = new ArrayList<>();
        //prueba.add("a");
        //cAdapter = new ContactosAdapter(this, Contact_aux.getArrayList());
        ArrayList<String> listaString = new ArrayList<>();
        for (int i = 0; i<Contact_aux.size();i++){
            listaString.add(Contact_aux.get(i).getNombre());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, listaString);
        lv.setAdapter(arrayAdapter);
    }



    public void toMainActivity(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("listaContactos", Contact_aux);
        startActivity(i);
    }
}
