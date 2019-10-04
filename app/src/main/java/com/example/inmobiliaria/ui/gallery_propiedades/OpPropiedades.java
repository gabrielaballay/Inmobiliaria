package com.example.inmobiliaria.ui.gallery_propiedades;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inmobiliaria.Inmueble;
import com.example.inmobiliaria.ItemVistas;
import com.example.inmobiliaria.R;

import java.util.ArrayList;
import java.util.List;

public class OpPropiedades extends Fragment {

    private OpPropiedadesViewModel opPropiedadesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        opPropiedadesViewModel =
                ViewModelProviders.of(this).get(OpPropiedadesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);

        ListView listView=root.findViewById(R.id.galeriaImagen);

        ArrayList<Inmueble> listar=new ArrayList<>();

        listar.add(new Inmueble(1,R.drawable.casa1,"Italia 1234","familiar",25000));
        listar.add(new Inmueble(1,R.drawable.casa2,"Sarmiento 987","familiar",18000));
        listar.add(new Inmueble(1,R.drawable.casa3,"Sucre 345","familiar",12456));
        listar.add(new Inmueble(1,R.drawable.casa4,"Belgrano 970","familiar",22000));
        listar.add(new Inmueble(1,R.drawable.casa5,"J.A. Roca 1234","Deposito",140000));

        ItemVistas iv=new ItemVistas(getContext(),R.layout.fragment_item_prop,listar, inflater);
        listView.setAdapter(iv);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.item_prop);
            }
        });

        return root;
    }

}