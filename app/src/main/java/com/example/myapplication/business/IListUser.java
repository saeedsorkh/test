package com.example.myapplication.business;


import com.example.myapplication.model.Container;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IListUser {


    @GET("/api/users")
    Call<Container> getUsers(@Query("page") int myPage);
}
