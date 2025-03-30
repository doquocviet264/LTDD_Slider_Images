package com.example.slider_images;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class SliderActivity extends AppCompatActivity {

    private SliderView sliderView;
    private ArrayList<Images> arrayList;
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slider);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sliderView = findViewById(R.id.imageSlider);
        arrayList = new ArrayList<>();

        // Thêm ảnh vào danh sách
        arrayList.add(new Images("http://app.iotstar.vn:8081/appfoods/flipper/quangcao.png"));
        arrayList.add(new Images("http://app.iotstar.vn:8081/appfoods/flipper/coffee.jpg"));
        arrayList.add(new Images("http://app.iotstar.vn:8081/appfoods/flipper/companypizza.jpeg"));
        arrayList.add(new Images("http://app.iotstar.vn:8081/appfoods/flipper/themoinong.jpeg"));


        sliderAdapter = new SliderAdapter(getApplicationContext(), arrayList);
        sliderView.setSliderAdapter(sliderAdapter);

        // Cấu hình sliderView
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.red));
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();
        sliderView.setScrollTimeInSec(5);
    }
}
