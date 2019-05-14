package android.com.example1views;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {

    String data[];
    int images[];
    Activity context;

    public MyAdapter(Activity context,String data[],int images[]){
        super(context,R.layout.item_list,data);
        this.context = context;
        this.data = data;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_list,null,true);
        ImageView imageView = view.findViewById(R.id.iv_icon);
        TextView textView = view.findViewById(R.id.tv_item_lv);
        imageView.setImageResource(images[position]);
        textView.setText(data[position]);
        Log.v("MyAdapter","Hai "+position+",Hashcode "+view.hashCode());
        return view;
    }



}
