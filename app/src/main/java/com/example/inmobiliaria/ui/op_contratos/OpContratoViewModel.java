package com.example.inmobiliaria.ui.op_contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OpContratoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OpContratoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Listado de Contratos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}