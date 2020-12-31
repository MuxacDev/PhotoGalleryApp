package com.example.photogalleryapp.api;
import com.example.photogalleryapp.model.Photo;
import com.example.photogalleryapp.model.Photos;
import com.example.photogalleryapp.model.PhotosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrAPI {
    @GET("services/rest/?method=flickr.photos.getRecent&api_key=Your API&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getRecent();
    @GET("services/rest/?method=flickr.photos.search&api_key=d Your API&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getSearchPhotos(@Query("text") String keyWord);
}

