package com.example.projectapi.api;

import com.example.projectapi.model.JsonFile;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("15baeq")
    Call<JsonFile>getResult();
}
