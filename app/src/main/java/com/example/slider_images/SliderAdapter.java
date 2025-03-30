package com.example.slider_images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderHolder> {
    private Context context;
    private ArrayList<Images> imageList;

    public SliderAdapter(Context context, ArrayList<Images> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public SliderHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.images_slider_shopee, parent, false);
        return new SliderHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderHolder viewHolder, int position) {
        Glide.with(context)
                .load(imageList.get(position).getImageUrl()) // Load ảnh từ URL
                .into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    public static class SliderHolder extends SliderViewAdapter.ViewHolder {
        private ImageView imageView;

        public SliderHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_auto_image_slider);
        }
    }
}
