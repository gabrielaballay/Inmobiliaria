package com.example.inmobiliaria.ui.op_pagos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OpPagosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OpPagosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Listado de Pagos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}