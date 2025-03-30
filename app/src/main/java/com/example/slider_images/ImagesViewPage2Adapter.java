package com.example.slider_images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ImagesViewPage2Adapter extends RecyclerView.Adapter<ImagesViewPage2Adapter.ImagesViewHolder> {
    private Context context;
    private List<Images> imagesList;

    // Constructor đúng tên với class
    public ImagesViewPage2Adapter(Context context, List<Images> imagesList) {
        this.context = context;
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_images, parent, false);
        return new ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position) {
        Images images = imagesList.get(position);
        if (images != null) {
            Glide.with(context)
                    .load(images.getImageUrl())  // Load ảnh từ URL
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // Caching ảnh
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return imagesList == null ? 0 : imagesList.size();
    }

    public static class ImagesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
        }
    }
}
