package com.gahlot.incredassignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gahlot.incredassignment.model.Size;
import com.gahlot.incredassignment.model.VMIterface;
import com.gahlot.incredassignment.rest.ApiCallInterface;
import com.gahlot.incredassignment.rest.FlickrRepository;

import java.util.List;

public class ImageViewModel extends ViewModel implements VMIterface {

    private FlickrRepository mRepo;
    public MutableLiveData<List<Size>> mSize;
    private  ApiCallInterface apiCallInterface;



    public void setDetails(ApiCallInterface apiCallInterface){
        this.apiCallInterface = apiCallInterface;
        mRepo = FlickrRepository.getInstance(this.apiCallInterface);
        mSize = mRepo.getImageUrl();
    }

    public LiveData<List<Size>> getSize() {
        return mSize;
    }

    @Override
    public MutableLiveData<List<Size>> onLiveDataObtained(MutableLiveData<List<Size>> data) {
        mSize = data;
       return mSize;

    }
}
