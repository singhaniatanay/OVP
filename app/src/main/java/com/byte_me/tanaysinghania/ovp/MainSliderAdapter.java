package com.byte_me.tanaysinghania.ovp;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
                viewHolder.bindImageSlide(R.drawable.a);
                break;
            case 1:
                viewHolder.bindImageSlide(R.drawable.b);
                break;
            case 2:
                viewHolder.bindImageSlide(R.drawable.c);
                break;
            case 3:
                viewHolder.bindImageSlide(R.drawable.d);
                break;
        }
    }
}