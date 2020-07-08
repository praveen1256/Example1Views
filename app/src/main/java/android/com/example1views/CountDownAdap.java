package android.com.example1views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CountDownAdap extends ArrayAdapter<Product> {

    private LayoutInflater lf;

    public CountDownAdap(Context context, List<Product> objects) {
        super(context, 0, objects);
        lf = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = lf.inflate(R.layout.counter_item, parent, false);
            holder.tvProduct = (TextView) convertView.findViewById(R.id.tvProduct);
            holder.tvTimeRemaining = (TextView) convertView.findViewById(R.id.tvTimeRemaining);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.setData(getItem(position));
        return convertView;
    }


}
