package com.example.inmobiliaria.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PropietarioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PropietarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Perfil Propietario");
    }

    public LiveData<String> getText() {
        return mText;
    }
}