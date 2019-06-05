package com.example.resource.dog.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.resource.dog.R;
import com.example.resource.dog.presenter.ListAllBreedFragmentPresenter;
import com.example.resource.dog.presenter.ListAllBreedPresenter;
import com.example.resource.dog.repository.DogRepository;
import com.example.resource.dog.repository.IDogRepository;
import com.example.resource.dog.ui.IView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAllDogsFragment extends Fragment {

    private IDogRepository dogRepository;
    private Spinner listBreedsSpinner;
    private ImageView dogImage;

    public ListAllDogsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_all_dogs, container, false);

        listBreedsSpinner = view.findViewById(R.id.spinner_breed2);
        dogImage = view.findViewById(R.id.image_breed2);


//        final List<String> dogs = new ArrayList<>();
//        dogs.add("Selecione a ração do cão");
//
//        new DogRepository(new IView() {
//            @Override
//            public void onResponse(Object object) {
//                List<String> listDogs = (List<String>) object;
//                dogs.addAll(listDogs);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        }).listAllBreeds();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
//                android.R.layout.simple_spinner_dropdown_item, dogs);
        new ListAllBreedFragmentPresenter(new IListAllDogsFragmenteView() {
            @Override
            public Context getContextListAllDogs() {
                return getContext();
            }

            @Override
            public void getAdapter(ArrayAdapter<String> adp) {
                if(adp == null)
                    Toast.makeText(getContext(),"Não pode ser nulo", Toast.LENGTH_SHORT);
                listBreedsSpinner.setAdapter(adp);
            }
        }).listAllBreed();

//        listBreedsSpinner.setAdapter();

        listBreedsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelected = (String) listBreedsSpinner.getItemAtPosition(position);
                dogRepository = new DogRepository(new IView() {
                    @Override
                    public void onResponse(Object object) {
                        String image = (String) object;
                        Picasso.with(getContext()).load(image).into(dogImage);
                        dogImage.setScaleType(ImageView.ScaleType.FIT_XY);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                dogRepository.findName(itemSelected.replace(" ", "-"));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}
