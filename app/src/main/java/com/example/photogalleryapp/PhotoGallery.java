package com.example.photogalleryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.photogalleryapp.api.FlickrAPI;
import com.example.photogalleryapp.api.ServiceAPI;
import com.example.photogalleryapp.db.PhotosDB;
import com.example.photogalleryapp.model.Photo;
import com.example.photogalleryapp.model.Photos;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoGallery extends AppCompatActivity implements PhotoAdapter.ItemClickListener {
    // переменные для объектов
    private RecyclerView recyclerView;
    private PhotoAdapter adapter;
    PhotosDB db;

    List<Photo> photos;

    // метод выполняется при создании активности
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);

        // создание объекта БД
        //db=PhotosDB.getDatabase(this);
        //photos=db.photoDao().LoadAll();


        // связывается объект с представлением
        recyclerView = findViewById(R.id.recycle_view);
        // для RecyclerView обязательно определить менеджер макета
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        // инициализация адаптера и установка его для RecyclerView
        adapter = new PhotoAdapter(this, this);
        recyclerView.setAdapter(adapter);


        FlickrAPI flickrAPI = ServiceAPI.getRetrofit().create(FlickrAPI.class);
        try {
            Response response = flickrAPI.getRecent().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        flickrAPI.getRecent().enqueue(new Callback<List<Photo>>(){
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photos.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Toast.makeText(PhotoGallery.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }

        });




    }

    @Override
    public void onItemClickListener(String itemId) {

    }
}