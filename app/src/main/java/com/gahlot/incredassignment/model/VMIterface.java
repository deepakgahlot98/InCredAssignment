package com.gahlot.incredassignment.model;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public interface VMIterface {

    MutableLiveData<List<Size>> onLiveDataObtained(MutableLiveData<List<Size>> data);
}
