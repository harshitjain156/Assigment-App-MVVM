package com.example.assigment_app_mvvm.ViewModel;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assigment_app_mvvm.Api.ApiService;
import com.example.assigment_app_mvvm.Api.RetroInstance;
import com.example.assigment_app_mvvm.Model.ImageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageViewModel extends ViewModel {
    private MutableLiveData<List<ImageModel>> imageList;
    public ImageViewModel(){
        imageList=new MutableLiveData<>();
    }
    public MutableLiveData<List<ImageModel>> getImageList(){
        return imageList;
    }

    public void makeApiCall(){
        ApiService apiService= RetroInstance.getRetroClient().create(ApiService.class);
        Call<List<ImageModel>> call=apiService.getImageList();
        call.enqueue(new Callback<List<ImageModel>>() {
            @Override
            public void onResponse(Call<List<ImageModel>> call, Response<List<ImageModel>> response) {
                if (response.isSuccessful()){
                    imageList.postValue(response.body());
                }
                
            }

            @Override
            public void onFailure(Call<List<ImageModel>> call, Throwable t) {
            }
        });
    }
}
