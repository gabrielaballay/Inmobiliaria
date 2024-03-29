package com.example.inmobiliaria;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContratosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContratosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContratosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ContratosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContratosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContratosFragment newInstance(String param1, String param2) {
        ContratosFragment fragment = new ContratosFragment();
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
        View vista=inflater.inflate(R.layout.fragment_contratos, container, false);

        CharSequence s=getArguments().getCharSequence("direccion");

        muestraContrato(s.toString(),vista);

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

    public void muestraContrato(String dir, View view){
        ArrayList<Alquiler> listaAlquiler=new ArrayList<>();

        listaAlquiler.add(new Alquiler(25000,"23-01-2019","23-01-2020","Italia 1234"));
        listaAlquiler.add(new Alquiler(18000,"10-10-2018","10-10-2019","Sarmiento 987"));
        listaAlquiler.add(new Alquiler(12456,"05-07-2019","05-07-2020","Sucre 345"));
        listaAlquiler.add(new Alquiler(22000,"03-04-2019","03-04-2020","Belgrano 970"));
        TextView precio=view.findViewById(R.id.precioContrato);
        TextView fInicio=view.findViewById(R.id.fechaInicio);
        TextView fFin=view.findViewById(R.id.fechaFin);
        TextView dirCon=view.findViewById(R.id.dirContrato);
        for (Alquiler a:listaAlquiler) {
            if(dir.equalsIgnoreCase(a.getInmueble())) {
                dirCon.setText(a.getInmueble());
                precio.setVisibility(View.VISIBLE);
                precio.setText("$ " + a.getPrecio());
                fInicio.setVisibility(View.VISIBLE);
                fInicio.setText(a.getFechaInicio());
                fFin.setVisibility(View.VISIBLE);
                fFin.setText(a.getFechaFin());
            }
        }

        if(dirCon.getText().equals("")){
            dirCon.setText("Sin Conrato");
        }

    }
}
