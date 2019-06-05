package com.example.resource.dog.ui.fragment;

import android.content.Context;
import android.widget.ArrayAdapter;

public interface IListAllDogsFragmenteView {

    Context getContextListAllDogs();

    void getAdapter(ArrayAdapter<String> adp);
}
