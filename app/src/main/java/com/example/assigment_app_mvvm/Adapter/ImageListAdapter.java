package com.example.assigment_app_mvvm.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assigment_app_mvvm.Model.ImageModel;
import com.example.assigment_app_mvvm.R;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.MyViewHolder> {
    List<ImageModel> imageList;
    public ImageListAdapter(List<ImageModel> list){
        this.imageList=list;
    }

    public void updateData(List<ImageModel> list){
        this.imageList=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.MyViewHolder holder, int position) {
        if (imageList.isEmpty()){

        }
        else {
            Glide.with(holder.imageView.getContext()).load(imageList.get(position).getUrl()).into(holder.imageView);

        }

    }

    @Override
    public int getItemCount() {
        if (this.imageList!=null){
            return this.imageList.size();
        }
        else
        {
            return 0;
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageCard);
        }
    }
}
