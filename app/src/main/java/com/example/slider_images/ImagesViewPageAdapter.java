package com.example.slider_images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import java.util.List;

public class ImagesViewPageAdapter extends PagerAdapter {
    private Context context;
    private List<Images> imagesList;

    public ImagesViewPageAdapter(Context context, List<Images> imagesList) {
        this.context = context;
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_images, container, false);
        ImageView imageView = view.findViewById(R.id.imgView);

        // Lấy URL của ảnh từ danh sách
        String imageUrl = imagesList.get(position).getImageUrl();

        // Sử dụng Glide để tải ảnh từ URL
        Glide.with(context)
                .load(imageUrl)
                .into(imageView);

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return (imagesList != null) ? imagesList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
