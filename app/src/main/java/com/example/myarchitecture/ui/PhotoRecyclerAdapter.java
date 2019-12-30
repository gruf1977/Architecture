package com.example.myarchitecture.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myarchitecture.R;
import com.example.myarchitecture.domain.Photo;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

class PhotoRecyclerAdapter extends
        RecyclerView.Adapter<PhotoRecyclerAdapter.ViewHolder> {
    private List<Photo> data = new ArrayList<>();

    PhotoRecyclerAdapter(ArrayList data) {
        if (data != null) {
            this.data = data;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.photo_recycler_item, parent, false);
        return new PhotoRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(data.get(position).getUrl()).resize(220, 220)
                .centerCrop().into(holder.imagePhoto);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePhoto;

        ViewHolder(View view) {
            super(view);
            imagePhoto = view.findViewById(R.id.imagePhoto);
        }
    }
}
