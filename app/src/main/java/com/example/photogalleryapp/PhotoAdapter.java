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

import com.example.photogalleryapp.db.PhotosDB;
import com.example.photogalleryapp.model.Photo;
import com.example.photogalleryapp.model.Photos;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder>
{
    // переменная слушателя при выборе элемента списка
    final private ItemClickListener itemClickListener;

    private Context context;

    private final List<Photo> photos=null;


    public PhotoAdapter(Context context, ItemClickListener listener){
        this.context = context;
        itemClickListener=listener;
        //photos=PhotosDB.getDatabase(context).photoDao().LoadAll();


    }

    class PhotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // переменные класса для изображений представления
        public final ImageView image;
        public PhotoHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(this);
        }
        /* метод обработки выбора элемента и определения позиции выбранного элемента в БД */
        @Override
        public void onClick(View view) {
            //String elementId = photos.get(getAdapterPosition()).getId();
            //itemClickListener.onItemClickListener(elementId);
        }

    }

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // заполнение представления элемента списка
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_photo,parent,false);
        return new PhotoHolder(itemView);
    }

    // метод связывает данные списка с представлением на экране
    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        // определение значений выбранного элемента
        //Photo photo = photos.get(position);
        //String title = photo.getTitle();
        // вывод значений на экран
        holder.image.setImageResource(android.R.color.transparent);







    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    // реализация интерфейса при выборе элемента из списка
    public interface ItemClickListener {
        void onItemClickListener(String itemId); }



    }
