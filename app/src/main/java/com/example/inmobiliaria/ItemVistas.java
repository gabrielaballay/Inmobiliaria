package com.example.inmobiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemVistas extends ArrayAdapter<Inmueble> {
    private Context context;
    private List<Inmueble> lista;
    private LayoutInflater li;

    public ItemVistas(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context=context;
        this.lista=objects;
        this.li=li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=li.inflate(R.layout.fragment_item_prop,parent,false);
        }
        Inmueble inmueble=lista.get(position);
        ImageView imagen=itemView.findViewById(R.id.itemImagen);
        TextView direccion=itemView.findViewById((R.id.direccion));
        TextView precio=itemView.findViewById((R.id.precio));
        TextView tipo=itemView.findViewById((R.id.tipo));

        imagen.setImageResource(inmueble.getFoto());
        direccion.setText(inmueble.getDireccion());
        precio.setText(inmueble.getPrecio()+"");
        tipo.setText(inmueble.getTipo());
        return itemView;
    }
}
