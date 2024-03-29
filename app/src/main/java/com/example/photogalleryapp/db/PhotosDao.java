package com.example.photogalleryapp.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.photogalleryapp.model.Photo;

import java.util.List;



@Dao
public interface PhotosDao {
    @Query("SELECT * FROM photo")
    public List<Photo> LoadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertPhoto(Photo photo);

    @Delete
    public void deletePhoto(Photo photo);
}
