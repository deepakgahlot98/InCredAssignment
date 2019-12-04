package com.gahlot.incredassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.gahlot.incredassignment.adapter.CustomAdapter;
import com.gahlot.incredassignment.model.FinalSize;
import com.gahlot.incredassignment.model.MyFlicker;
import com.gahlot.incredassignment.model.Photo;
import com.gahlot.incredassignment.model.Size;
import com.gahlot.incredassignment.rest.ApiCallInterface;
import com.gahlot.incredassignment.viewmodel.ImageViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<Photo> photo = new ArrayList<>();
    private ArrayList<Size> Size = new ArrayList<>();
    private ArrayList<Size> urls = new ArrayList<>();
    private ApiCallInterface apiCallInterface;
    private RecyclerView recyclerView;
    private ImageViewModel imageViewModel;
    private CustomAdapter customAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/services/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        apiCallInterface = retrofit.create(ApiCallInterface.class);

//        getPosts();


        imageViewModel = ViewModelProviders.of(this).get(ImageViewModel.class);
        imageViewModel.setDetails(apiCallInterface);

        imageViewModel.mSize.observe(this, new Observer<List<Size>>() {
            @Override
            public void onChanged(List<Size> sms) {
                customAdapter.setData(sms);
            }
        });

        initRecyclerView();

    }

    private void initRecyclerView() {

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
                recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                customAdapter = new CustomAdapter(MainActivity.this, imageViewModel.getSize().getValue()==null ? new ArrayList<com.gahlot.incredassignment.model.Size>() : imageViewModel.getSize().getValue());
                recyclerView.setAdapter(customAdapter);
                customAdapter.notifyDataSetChanged();
    }
}
