package com.h5190037.oguzhan_gunaydin_final.util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class GlideUtil {

    public  static  void resimIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
