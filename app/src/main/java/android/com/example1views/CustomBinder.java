package android.com.example1views;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

public class CustomBinder {

    @BindingAdapter({"bind:imageUrl","bind:listImages"})
    public static void loadImage(ImageView imageView, String imageUrl, String[] listImages) {
        Log.v("listImages","Size "+listImages.length);
        // GIF Support
//        Glide.with(imageView.getContext())
//                .load(imageUrl)
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_background)
//                .into(imageView);

        // GIF not support
//        Picasso.with(imageView.getContext()).load("https://api-logistics.jazeerapaints.com/api/filedata/RAVATHI_USE").into(imageView);

    }

}
