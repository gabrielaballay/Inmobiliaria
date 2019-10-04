package com.example.inmobiliaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Button btEntrar;
    private Button btSalir;
    private EditText correo;
    private EditText pass;
    private ArrayList<Propietario> propietarios=new ArrayList<Propietario>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEntrar=findViewById(R.id.btIngresar);
        btSalir=findViewById(R.id.btSalir);
        correo=findViewById(R.id.etCorreo);
        pass=findViewById(R.id.etPass);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarPropietarios();
                for (Propietario p:propietarios) {
                    if (correo.getText().toString().equalsIgnoreCase(p.getMail())&& pass.getText().toString().equalsIgnoreCase(p.getPass())){
                        Intent i = new Intent(getApplicationContext(), Principal.class);
                        i.putExtra("id", p.getIdPropietario());
                        i.putExtra("nombre",p.getNombre());
                        i.putExtra("apellido",p.getApellido());
                        i.putExtra("mail",p.getMail());
                        startActivity(i);
                    }
                }

            }
        });

        btSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void cargarPropietarios(){
        propietarios.add(new Propietario(1,"juan","gomez",12345678, "2664000001","juangomez@mail.com","juan1234"));
        propietarios.add(new Propietario(2,"mario","lopez",13345678, "2664000002","mariolopez@mail.com","mario1234"));
        propietarios.add(new Propietario(3,"ana","gomez",13345678, "2664000003","anagomez@mail.com","ana1234"));
        propietarios.add(new Propietario(1,"maria","gomez",14345678, "2664000004","mariagomez@mail.com","maria1234"));
        propietarios.add(new Propietario(1,"leo","ortiz",22345678, "2664000005","leoortiz@mail.com","leo1234"));
    }


}
