package com.example.slider_images;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator;

public class CircleIndicatorViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private List<Images> imagesList;
    private Handler handler = new Handler();

    // 🟢 Định nghĩa Runnable trước khi sử dụng
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int nextPage = (viewPager.getCurrentItem() + 1) % imagesList.size();
            viewPager.setCurrentItem(nextPage);
            handler.postDelayed(this, 3000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circleindicator_viewpager);

        viewPager = findViewById(R.id.viewpage);
        circleIndicator = findViewById(R.id.circle_indicator);

        imagesList = getListImages();
        ImagesViewPageAdapter adapter = new ImagesViewPageAdapter(this, imagesList);
        viewPager.setAdapter(adapter);

        // Liên kết ViewPager với CircleIndicator
        circleIndicator.setViewPager(viewPager);

        // 🔹 Auto-scroll ViewPager sau 3 giây
        handler.postDelayed(runnable, 3000);

        // Lắng nghe sự kiện thay đổi trang
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images("http://app.iotstar.vn:8081/appfoods/flipper/quangcao.png"));
        list.add(new Images("http://app.iotstar.vn:8081/appfoods/flipper/coffee.jpg"));
        list.add(new Images("http://app.iotstar.vn:8081/appfoods/flipper/companypizza.jpeg"));
        list.add(new Images("http://app.iotstar.vn:8081/appfoods/flipper/themoinong.jpeg"));
        return list;
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }
}
