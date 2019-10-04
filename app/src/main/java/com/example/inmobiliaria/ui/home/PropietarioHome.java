package com.example.inmobiliaria.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria.R;

public class PropietarioHome extends Fragment {
    private PropietarioViewModel propietarioViewModel;
    Button modificar;
    Button guardar;
    EditText apellido;
    EditText nombre;
    EditText dni;
    EditText telefono;
    EditText mail;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        propietarioViewModel =
                ViewModelProviders.of(this).get(PropietarioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propietario, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        propietarioViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        apellido=root.findViewById(R.id.tvApellido);
        apellido.setText("Gomez");
        nombre=root.findViewById(R.id.tvNombre);
        nombre.setText("Juan");
        dni=root.findViewById(R.id.tvDni);
        dni.setText("26112200");
        telefono=root.findViewById(R.id.tvTelefono);
        telefono.setText("2664001122");
        mail=root.findViewById(R.id.tvMail);
        mail.setText("juangomez@mail.com");

        modificar=root.findViewById(R.id.modificar);
        guardar=root.findViewById(R.id.guardar);
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apellido.setEnabled(true);
                nombre.setEnabled(true);
                dni.setEnabled(true);
                telefono.setEnabled(true);
                mail.setEnabled(true);
                guardar.setVisibility(View.VISIBLE);
                modificar.setVisibility(View.INVISIBLE);
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apellido.setEnabled(false);
                nombre.setEnabled(false);
                dni.setEnabled(false);
                telefono.setEnabled(false);
                mail.setEnabled(false);
                guardar.setVisibility(View.INVISIBLE);
                modificar.setVisibility(View.VISIBLE);
            }
        });

        return root;

    }
}