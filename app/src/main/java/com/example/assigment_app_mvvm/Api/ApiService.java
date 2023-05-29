package com.example.assigment_app_mvvm.Api;

import com.example.assigment_app_mvvm.Model.ImageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/photos")
    Call<List<ImageModel>> getImageList();

}
