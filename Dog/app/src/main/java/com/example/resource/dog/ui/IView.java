package com.example.resource.dog.ui;

public interface IView<T> {
    void onResponse(T object);
    void onFailure(Throwable t);
}
