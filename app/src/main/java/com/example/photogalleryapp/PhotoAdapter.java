package com.example.photogalleryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photogalleryapp.model.Photo;
import com.example.photogalleryapp.model.Photos;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder>
{
    private final List<Photo> photos;

    public PhotoAdapter(List<Photo> photos){
        this.photos = photos;
    }

    static class PhotoHolder extends RecyclerView.ViewHolder{
        public final ImageView image;

        public PhotoHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
        }
    }

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_photo,parent,false);
        return new PhotoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        Photo photo = photos.get(position);

        //Picasso.get().load(grumpyCat.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
