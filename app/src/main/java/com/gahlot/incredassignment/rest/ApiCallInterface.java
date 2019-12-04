package com.gahlot.incredassignment.rest;

import com.gahlot.incredassignment.model.FinalSize;
import com.gahlot.incredassignment.model.MyFlicker;
import com.gahlot.incredassignment.model.Photos;
import com.gahlot.incredassignment.model.VMIterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCallInterface {

    @GET("?method=flickr.people.getPublicPhotos&api_key=227be805b3d6e934926d049533bb938a&user_id=135487628%40N06&format=json&nojsoncallback=1")
    Call<MyFlicker> getPhotos();

    @GET("?method=flickr.photos.getSizes&photo_id=&api_key=227be805b3d6e934926d049533bb938a&user_id=135487628%40N06&format=json&nojsoncallback=1")
    Call<FinalSize> getSize(@Query("photo_id") String postId);

}
