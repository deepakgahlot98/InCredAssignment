package com.gahlot.incredassignment.rest;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;

import com.gahlot.incredassignment.MainActivity;
import com.gahlot.incredassignment.adapter.CustomAdapter;
import com.gahlot.incredassignment.model.FinalSize;
import com.gahlot.incredassignment.model.MyFlicker;
import com.gahlot.incredassignment.model.Photo;
import com.gahlot.incredassignment.model.Size;
import com.gahlot.incredassignment.model.VMIterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickrRepository {

    private static final String TAG = "FlickrRepository";
    private final ApiCallInterface apiCallInterface;
    private ArrayList<Photo> photo = new ArrayList<>();
    private ArrayList<com.gahlot.incredassignment.model.Size> Size = new ArrayList<>();
    private ArrayList<Size> urls = new ArrayList<>();
    private static FlickrRepository instance;

    public FlickrRepository(ApiCallInterface apiCallInterface) {

        this.apiCallInterface = apiCallInterface;
    }

    public static FlickrRepository getInstance(ApiCallInterface apiCallInterface){
        if(instance == null){
            instance = new FlickrRepository(apiCallInterface);
        }
        return instance;
    }

    public MutableLiveData<List<Size>> getImageUrl() {
        Call<MyFlicker> call = apiCallInterface.getPhotos();
        final MutableLiveData<List<Size>> liveData = new MutableLiveData<>();

        call.enqueue(new Callback<MyFlicker>() {
            @Override
            public void onResponse(Call<MyFlicker> call, Response<MyFlicker> response) {
                if (!response.isSuccessful()) {
                    Log.e(TAG, "onResponse: " + response.code());
                    return;
                }
                photo = response.body().getPhotos().getPhoto();
                for (int i=0; i< photo.size();i++) {
                    //getSize(photo.get(i).getId());
                    Call<FinalSize> call2 = apiCallInterface.getSize(photo.get(i).getId());

                    //final ArrayList<Size> urls = new ArrayList<>();

                    call2.enqueue(new Callback<FinalSize>() {
                        @Override
                        public void onResponse(Call<FinalSize> call, Response<FinalSize> response) {
                            Size = response.body().getSizes().getSize();
                            for (int i=0; i< Size.size();i++) {
                                if (Size.get(i).getLabel().equals("Thumbnail")) {
                                    urls.add(Size.get(i));
                                    Log.i(TAG, "onResponse: "
                                            + Size.get(i).getSource());
                                }
                            }
                            liveData.setValue(urls);
                        }

                        @Override
                        public void onFailure(Call<FinalSize> call, Throwable t) {
                            Log.e(TAG, "onFailure: " + t.getMessage());
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<MyFlicker> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });
        return liveData;
    }
}
