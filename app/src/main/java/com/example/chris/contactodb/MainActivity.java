package com.example.chris.contactodb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ListView lsv;
    ArrayList<Contacto> contactos;
    DaoContacto daoContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.btnAgregar);
        lsv=(ListView) findViewById(R.id.lista);
        daoContacto=new DaoContacto(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplication(),Main2Activity.class);
                startActivity(i);
            }
        });

        mostrar();

    }

    public void mostrar(){
        contactos=daoContacto.getAll();
        ArrayAdapter<Contacto> adp=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contactos);
        lsv.setAdapter(adp);
    }
}
