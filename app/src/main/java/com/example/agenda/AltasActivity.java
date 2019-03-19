package com.example.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AltasActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Tel;
    private EditText Mail;
    private TextView Total;
    private MainActivity.Contactos Contact_aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);

        Intent i_aux = getIntent();
        Contact_aux = (MainActivity.Contactos) i_aux.getSerializableExtra("Clase");

        Name = (EditText)findViewById(R.id.eTNombre);
        Tel = (EditText)findViewById(R.id.eTTelefono);
        Mail = (EditText)findViewById(R.id.eTEmail);
        //Total = (TextView)findViewById(R.id.tvTotal);
    }

    public void AgregarContacto(View view){
        //String aux = Total.getText().toString();
        //int tot = Integer.parseInt(aux);
        Contact_aux.setNombre(Name.getText().toString());
        Contact_aux.setTelefono(Tel.getText().toString());
        Contact_aux.setEmail(Mail.getText().toString());
        Contact_aux.addNewItem(Contact_aux);
        //int totalentero = Contact_aux.getSize();
        //Total.setText(String.valueOf(totalentero));
    }

    public void toMainActivity(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("ClaseAlta", Contact_aux);
        startActivity(i);
    }
}
