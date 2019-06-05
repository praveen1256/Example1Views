package android.com.example1views.dagger.model;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class ImageDownloader {
    private Context context;

    public ImageDownloader(Context context) {
        this.context = context;
    }

    public void toImageView(ImageView imageView, String url) {
//        Glide.with(context).load(url).into(imageView);
        // (one of the) advantage of Dagger: you can now simply switch between two libraries
        Picasso.with(context).load(url).into(imageView);
    }
}
