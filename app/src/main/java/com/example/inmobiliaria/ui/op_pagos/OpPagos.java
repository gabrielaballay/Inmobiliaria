package com.example.inmobiliaria.ui.op_pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria.Pagos;
import com.example.inmobiliaria.R;

import java.util.ArrayList;
import java.util.Locale;

public class OpPagos extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner viviendas;
    private ArrayAdapter<String> comboAdapter;
    private OpPagosViewModel opPagosViewModel;
    private String direccion;
    private ArrayList<String> listar;
    ArrayList<Pagos> listaPagos;
    TextView Pago,Pago2;
    TextView fechaP,fechaP2;
    TextView importe,importe2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        opPagosViewModel =
                ViewModelProviders.of(this).get(OpPagosViewModel.class);

        View root = inflater.inflate(R.layout.fragment_pagos, container, false);

        listar=new ArrayList<>();
        viviendas=root.findViewById(R.id.spinnerPropiedades);
        //Aplico el listener al spinner
        viviendas.setOnItemSelectedListener(this);

        listaPagos =new ArrayList<>();
        listaPagos.add(new Pagos(20020,"10-08-2019",25000,"Italia 1234"));
        listaPagos.add(new Pagos(20025,"10-09-2019",25000,"Italia 1234"));
        listaPagos.add(new Pagos(20021,"05-08-2019",18000,"Sarmiento 987"));
        listaPagos.add(new Pagos(20024,"07-09-2019",18000,"Sarmiento 987"));
        listaPagos.add(new Pagos(20022,"12-08-2019",12456,"Sucre 345"));
        listaPagos.add(new Pagos(20026,"10-09-2019",12456,"Sucre 345"));
        listaPagos.add(new Pagos(20023,"10-08-2019",22000,"Belgrano 970"));
        listaPagos.add(new Pagos(20027,"10-09-2019",22000,"Belgrano 970"));

        listar.add("Italia 1234");
        listar.add("Sarmiento 987");
        listar.add("Sucre 345");
        listar.add("Belgrano 970");
        listar.add("J.A. Roca 1234");
        //Implemento el adapter con el contexto, layout, lista de direcciones
        comboAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, listar);
        //Cargo el spinner con los datos
        viviendas.setAdapter(comboAdapter);

        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        switch (adapterView.getId()){
            case R.id.spinnerPropiedades:
                //Almaceno la direecion seleccionada
                direccion = listar.get(i);
                pagos(direccion,getView());

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void pagos(String direccion,View vista){
        int suma=0;

        TextView texto=new TextView(getContext());
        texto.setText("hola");
        Pago=vista.findViewById(R.id.nroPago);
        fechaP=vista.findViewById(R.id.fechaPago);
        importe=vista.findViewById(R.id.importePago);
        Pago2=vista.findViewById(R.id.nroPago2);
        fechaP2=vista.findViewById(R.id.fechaPago2);
        importe2=vista.findViewById(R.id.importePago2);
        Pago.setVisibility(View.INVISIBLE);
        fechaP.setVisibility(View.INVISIBLE);
        importe.setVisibility(View.INVISIBLE);
        Pago2.setVisibility(View.INVISIBLE);
        fechaP2.setVisibility(View.INVISIBLE);
        importe2.setVisibility(View.INVISIBLE);

        for (Pagos p:listaPagos) {
            if(p.getDire().equalsIgnoreCase(direccion)&& suma==0){
                Pago.setVisibility(View.VISIBLE);
                Pago.setText(p.getNroPago()+"");
                fechaP.setVisibility(View.VISIBLE);
                fechaP.setText(p.getFechaPago().toString());
                importe.setVisibility(View.VISIBLE);
                importe.setText("$ "+p.getImporte());
                suma++;
            }else if(p.getDire().equalsIgnoreCase(direccion)&& suma==1) {
                Pago2.setVisibility(View.VISIBLE);
                Pago2.setText(p.getNroPago() + "");
                fechaP2.setVisibility(View.VISIBLE);
                fechaP2.setText(p.getFechaPago().toString());
                importe2.setVisibility(View.VISIBLE);
                importe2.setText("$ " + p.getImporte());
            }
        }
    }
}