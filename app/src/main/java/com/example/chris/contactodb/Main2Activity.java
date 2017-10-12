package com.example.chris.contactodb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btnGuardar;
    EditText txtU,txtE,txtTW,txtTel,txtF;
    DaoContacto daoContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtU=(EditText) findViewById(R.id.txtUsuario);
        txtE=(EditText) findViewById(R.id.txtmail);
        txtTW=(EditText)findViewById(R.id.txtTwitter);
        txtTel=(EditText)findViewById(R.id.txtTel);
        txtF=(EditText)findViewById(R.id.txtDate);
        btnGuardar=(Button)findViewById(R.id.btnGuardar);
        daoContacto=new DaoContacto(getApplication());

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacto c=new Contacto();
                c.setUsuario(txtU.getText().toString());
                c.setEmail(txtE.getText().toString());
                c.setTw(txtTW.getText().toString());
                c.setTel(Integer.parseInt(txtTel.getText().toString()));
                c.setFechaN(txtF.getText().toString());
                Toast.makeText(getApplication(),"LONG: "+daoContacto.insert(c),Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplication(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
