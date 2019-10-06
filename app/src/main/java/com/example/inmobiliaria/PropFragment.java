package com.example.inmobiliaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button editar,guardar;
    private ImageView foto;
    private EditText direccion, tipo, precio, ambientes, uso;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PropFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropFragment newInstance(String param1, String param2) {
        PropFragment fragment = new PropFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_prop, container, false);
        CharSequence s=getArguments().getCharSequence("direccion");

        foto=vista.findViewById(R.id.ImagenProp);
        direccion=vista.findViewById(R.id.direccionProp);
        tipo=vista.findViewById(R.id.tipoProp);
        precio=vista.findViewById(R.id.precioProp);
        ambientes =vista.findViewById(R.id.ambienteProp);
        uso=vista.findViewById(R.id.usoProp);
        editar=vista.findViewById(R.id.btnEditar);
        guardar=vista.findViewById(R.id.btnGuardarCambio);

        cargarVista(s.toString(), vista);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                direccion.setEnabled(true);
                tipo.setEnabled(true);
                precio.setEnabled(true);
                ambientes.setEnabled(true);
                uso.setEnabled(true);
                guardar.setVisibility(View.VISIBLE);
                editar.setVisibility(View.INVISIBLE);
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                direccion.setEnabled(false);
                tipo.setEnabled(false);
                precio.setEnabled(false);
                ambientes.setEnabled(false);
                uso.setEnabled(false);
                guardar.setVisibility(View.INVISIBLE);
                editar.setVisibility(View.VISIBLE);
            }
        });

        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void cargarVista(String dire, View view){
        ArrayList<Inmueble> listar=new ArrayList<>();

        listar.add(new Inmueble(R.drawable.casa1,"Italia 1234",6,"familiar","Vivienda Familiar",25000));
        listar.add(new Inmueble(R.drawable.casa2,"Sarmiento 987",4,"familiar","Vivienda Familiar",18000));
        listar.add(new Inmueble(R.drawable.casa3,"Sucre 345",4,"familiar","Vivienda Familiar",12456));
        listar.add(new Inmueble(R.drawable.casa4,"Belgrano 970",6,"familiar","Vivienda Familiar",22000));
        listar.add(new Inmueble(R.drawable.casa5,"J.A. Roca 1234",4,"Deposito","Deposito de Mercaderia",140000));

        /*foto=view.findViewById(R.id.ImagenProp);
        direccion=view.findViewById(R.id.direccionProp);
        tipo=view.findViewById(R.id.tipoProp);
        precio=view.findViewById(R.id.precioProp);
        ambientes =view.findViewById(R.id.ambienteProp);
        uso=view.findViewById(R.id.usoProp);
        editar=view.findViewById(R.id.btnEditar);
        guardar=view.findViewById(R.id.btnGuardarCambio);*/

        for (Inmueble in:listar) {
            if(in.getDireccion().equalsIgnoreCase(dire)){
                foto.setImageResource(in.getFoto());
                direccion.setText(in.getDireccion());
                tipo.setText(in.getTipo());
                precio.setText("$ "+in.getPrecio());
                ambientes.setVisibility(View.VISIBLE);
                uso.setVisibility(View.VISIBLE);
                ambientes.setText("Ambientes: "+in.getAmbientes());
                uso.setText("Uso: "+in.getUso());
            }
        }
        direccion.setEnabled(false);
        tipo.setEnabled(false);
        precio.setEnabled(false);
        ambientes.setEnabled(false);
        uso.setEnabled(false);
    }
}
