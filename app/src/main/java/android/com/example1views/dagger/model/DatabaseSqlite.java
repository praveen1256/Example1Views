package android.com.example1views.dagger.model;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class DatabaseSqlite {
    private Context context;

    public DatabaseSqlite(Context context) {
        this.context = context;
    }

    public void toImageView(ImageView imageView, String url) {
                Glide.with(context).load(url).into(imageView);
        // (one of the) advantage of Dagger: you can now simply switch between two libraries
        Picasso.with(context).load(url).into(imageView);

        // Update some data in db
    }

    public void update(String tableName,String[] columnNames,String[] values){
        // querty
    }




}
