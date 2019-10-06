package com.example.inmobiliaria.ui.op_contratos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.inmobiliaria.Inmueble;
import com.example.inmobiliaria.ItemVistas;
import com.example.inmobiliaria.R;

import java.util.ArrayList;

public class OpContrato extends Fragment {

    private OpContratoViewModel opContratoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        opContratoViewModel =
                ViewModelProviders.of(this).get(OpContratoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);

        final ListView listView=root.findViewById(R.id.galeriaImagen);

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
                Bundle datos=new Bundle();
                Inmueble a=(Inmueble)listView.getItemAtPosition(i);
                datos.putCharSequence("direccion",a.getDireccion());
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.contratosFragment,datos);
            }
        });

        return root;
    }
}