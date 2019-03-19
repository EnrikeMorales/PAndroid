package com.example.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static class Contactos implements Serializable {
        private String Nombre;
        private String telefono;
        private String email;
        private ArrayList<Contactos> itemList = new ArrayList<Contactos>();

        public String getNombre() {
            return Nombre;
        }
        public void setNombre(String Nombre){
            this.Nombre = Nombre;
        }
        public String getTelefono(){
            return telefono;
        }
        public void setTelefono(String telefono){
            this.telefono = telefono;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public ArrayList<Contactos> getArrayList(){
            return itemList;
        }
        public int getSize(){
            return itemList.size();
        }
        public void addNewItem(Contactos item){
            this.itemList.add(item);
        }
    }
    //private ArrayList<Contactos> itemList = new ArrayList<Contactos>();
    private Contactos item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = new Contactos();
        item.setNombre("Luis Morales");
        item.setTelefono("6861167489");
        item.setEmail("enrike.mles@hotmail.com");
        //item.itemList.add(item);
        item.addNewItem(item);
        //itemList.add(item);
        //itemList.size();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        item = (Contactos) i.getSerializableExtra("ClaseMod");
    }

    public void toActivityAlta(View view) {
        Intent i = new Intent( this, AltasActivity.class);
        i.putExtra("Clase", item);
        startActivity(i);
    }

    public void toActivityBajas(View view) {
        Intent iB = new Intent( this, BajasActivity.class);
        iB.putExtra("Clase", item);
        startActivity(iB);
    }

    public void toActivityBuscar(View view) {
        Intent iC = new Intent( this, ConsultaActivity.class);
        iC.putExtra("Clase", item);
        startActivity(iC);
    }
}
