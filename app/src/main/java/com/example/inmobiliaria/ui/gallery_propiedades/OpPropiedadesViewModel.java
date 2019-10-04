package com.example.inmobiliaria.ui.gallery_propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OpPropiedadesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OpPropiedadesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Galeria de Propiedades");
    }

    public LiveData<String> getText() {
        return mText;
    }
}