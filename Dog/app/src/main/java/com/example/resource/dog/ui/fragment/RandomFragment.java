package com.example.resource.dog.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.resource.dog.R;
import com.example.resource.dog.repository.DogRepository;
import com.example.resource.dog.repository.IDogRepository;
import com.example.resource.dog.ui.IView;
import com.squareup.picasso.Picasso;

public class RandomFragment extends Fragment {

    private ImageView imageDog;
    private Button buttonRandom;

    public RandomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_random, container, false);

        imageDog = view.findViewById(R.id.image_dog2);
        buttonRandom = view.findViewById(R.id.button_random2);

        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DogRepository(new IView() {
                    @Override
                    public void onResponse(Object object) {
                        String result = (String) object;
                        Picasso.with(getContext()).load(result).into(imageDog);
                        imageDog.setScaleType(ImageView.ScaleType.FIT_XY);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }).findRandom();
            }
        });

        return view;
    }
}
