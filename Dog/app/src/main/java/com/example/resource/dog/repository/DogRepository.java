package com.example.resource.dog.repository;

import com.example.resource.dog.model.DogListAll;
import com.example.resource.dog.model.DogRandom;
import com.example.resource.dog.infra.RetrofitConfig;
import com.example.resource.dog.service.IDogService;
import com.example.resource.dog.ui.IView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogRepository implements IDogRepository {

    public static final String ERRO_EXCEPTION = "Erro ao buscar!";
    private final IView view;
    private final IDogService dogService;

    public DogRepository(IView view) {
        this.dogService = new RetrofitConfig().getDogService();
        this.view = view;
    }

    @Override
    public void findRandom(){


        dogService.findRandom().enqueue(new Callback<DogRandom>() {
            @Override
            public void onResponse(Call<DogRandom> call, Response<DogRandom> response) {
                if (!response.isSuccessful()) {
                    view.onFailure(new Exception(ERRO_EXCEPTION));
                    return;
                }

                if (response.body() == null) {
                    view.onFailure(new Exception(ERRO_EXCEPTION));
                    return;
                }
                view.onResponse(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<DogRandom> call, Throwable t) {
                view.onFailure(t);
            }
        });
    }

    @Override
    public void listAllBreeds() {

        dogService.listAllBreeds().enqueue(new Callback<DogListAll>() {
            @Override
            public void onResponse(Call<DogListAll> call, Response<DogListAll> response) {
                if (!response.isSuccessful()) {
                    view.onFailure(new Exception(ERRO_EXCEPTION));
                    return;
                }

                if (response.body() == null) {
                    view.onFailure(new Exception(ERRO_EXCEPTION));
                    return;
                }
                Iterator<Map.Entry<String, List<String>>> i =
                        response.body().getMessage().entrySet().iterator();

                List<String> breeds = new ArrayList<>();

                while (i.hasNext()){
                    Map.Entry<String, List<String>> entry = i.next();
                    String breed = entry.getKey();
                    List<String> subs = entry.getValue();

                    if (subs.isEmpty())
                        breeds.add(breed);
                    else
                        for (String s : subs) {
                            breeds.add(breed + " " + s);
                        }
                }
                view.onResponse(breeds);
            }

            @Override
            public void onFailure(Call<DogListAll> call, Throwable t) {
                view.onFailure(t);
            }
        });
    }

    @Override
    public void findName(String breed) {
        dogService.findName(breed).enqueue(new Callback<DogRandom>() {
            @Override
            public void onResponse(Call<DogRandom> call, Response<DogRandom> response) {
                if(!response.isSuccessful()){
                    view.onFailure(new Exception(ERRO_EXCEPTION));
                    return;
                }
                if(response.body() == null){
                    view.onFailure(new Exception(ERRO_EXCEPTION));
                    return;
                }

                view.onResponse(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<DogRandom> call, Throwable t) {

            }
        });
    }


}