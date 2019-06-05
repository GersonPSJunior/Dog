package com.example.resource.dog.repository;

public interface IDogRepository {

    void findRandom();
    void listAllBreeds();
    void findName(String breed);
}
