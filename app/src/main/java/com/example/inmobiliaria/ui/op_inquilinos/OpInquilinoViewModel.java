package com.example.inmobiliaria.ui.op_inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OpInquilinoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OpInquilinoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Lista de Inquilinos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}