package com.example.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ConsultaActivity extends AppCompatActivity {
    private ArrayList<Contacto> Contact_aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        Intent i_aux = getIntent();
        Contact_aux = (ArrayList<Contacto>) i_aux.getSerializableExtra("listaContactos");
    }

    public void toMainActivity(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("listaContactos", Contact_aux);
        startActivity(i);
    }
}
