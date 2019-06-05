package com.example.resource.dog.presenter;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.resource.dog.repository.DogRepository;
import com.example.resource.dog.ui.IView;
import com.example.resource.dog.ui.fragment.IListAllDogsFragmenteView;

import java.util.ArrayList;
import java.util.List;

public class ListAllBreedFragmentPresenter implements IListAllBreedFragmentPresenter {

    IListAllDogsFragmenteView view;

    public ListAllBreedFragmentPresenter(IListAllDogsFragmenteView view) {
        this.view = view;
    }

    @Override
    public void listAllBreed() {

        final List<String> dogs = new ArrayList<>();
        dogs.add("Selecione a ração do cão");

        new DogRepository(new IView() {
            @Override
            public void onResponse(Object object) {
                List<String> listDogs = (List<String>) object;
                dogs.addAll(listDogs);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContextListAllDogs(),
                        android.R.layout.simple_spinner_dropdown_item, dogs);
                view.getAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(view.getContextListAllDogs(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        }).listAllBreeds();

    }
}
