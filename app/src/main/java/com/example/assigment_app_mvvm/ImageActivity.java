package com.example.assigment_app_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assigment_app_mvvm.Adapter.ImageListAdapter;
import com.example.assigment_app_mvvm.Model.ImageModel;
import com.example.assigment_app_mvvm.ViewModel.ImageViewModel;

import java.util.List;

public class ImageActivity extends AppCompatActivity {
RecyclerView recyclerView;
ImageListAdapter imageListAdapter;
List<ImageModel> imageList;
ImageViewModel imageViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        recyclerView=findViewById(R.id.imageRecycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        imageListAdapter=new ImageListAdapter(imageList);
        recyclerView.setAdapter(imageListAdapter);

        imageViewModel= ViewModelProviders.of(this).get(ImageViewModel.class);
        imageViewModel.getImageList().observe(this, new Observer<List<ImageModel>>() {
            @Override
            public void onChanged(List<ImageModel> list) {
                if (list!=null){
                    imageList=list;
                    imageListAdapter.updateData(list);
                    }
            }
        });
        imageViewModel.makeApiCall();

    }
}