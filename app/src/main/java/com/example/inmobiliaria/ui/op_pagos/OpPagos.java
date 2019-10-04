package com.example.inmobiliaria.ui.op_pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria.R;

public class OpPagos extends Fragment {

    private OpPagosViewModel opPagosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        opPagosViewModel =
                ViewModelProviders.of(this).get(OpPagosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        return root;
    }


}