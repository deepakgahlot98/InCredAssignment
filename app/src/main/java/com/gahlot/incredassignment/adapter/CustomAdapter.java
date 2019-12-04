package com.gahlot.incredassignment.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gahlot.incredassignment.R;
import com.gahlot.incredassignment.model.Size;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    private List<Size> urls = new ArrayList<>();
    private static final String TAG = "CustomAdapter";

    public CustomAdapter(Context context, List<Size> urls) {
        this.context = context;
        this.urls = urls;
    }

    public void setData(List<Size> data){
        urls.clear();
        urls.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(urls.get(position).getSource()).into(holder.image);
        Log.d(TAG, "onBindViewHolder: "+ urls.get(position).getSource());
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
