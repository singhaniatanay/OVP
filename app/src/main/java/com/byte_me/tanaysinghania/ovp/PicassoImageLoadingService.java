package com.byte_me.tanaysinghania.ovp;

import android.content.Context;
import android.widget.ImageView;

import ss.com.bannerslider.ImageLoadingService;

public class PicassoImageLoadingService implements ImageLoadingService {
    public Context context;

    public PicassoImageLoadingService(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        imageView.setImageResource(R.mipmap.about);
    }

    @Override
    public void loadImage(int resource, ImageView imageView) {
        imageView.setImageResource(resource);
    }

    @Override
    public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
        //Picasso.with(context).load(url).placeholder(placeHolder).error(errorDrawable).into(imageView);
    }
}
