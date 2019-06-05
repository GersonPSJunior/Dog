package com.example.resource.dog.service;

import com.example.resource.dog.model.DogListAll;
import com.example.resource.dog.model.DogRandom;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDogService {

    @GET("breeds/image/random")
    Call<DogRandom> findRandom();

    @GET("breeds/list/all")
    Call<DogListAll> listAllBreeds();

    @GET("breed/{name}/images/random")
    Call<DogRandom> findName(@Path("name") String breed);
}
