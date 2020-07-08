package android.com.example1views;

import android.widget.TextView;

public class ViewHolder {

    TextView tvProduct;
    TextView tvTimeRemaining;
    Product mProduct;

    public void setData(Product item) {
        mProduct = item;
        tvProduct.setText(item.name);
        updateTimeRemaining(System.currentTimeMillis());
    }

    public void updateTimeRemaining(long currentTime) {
        long timeDiff = mProduct.expirationTime - currentTime;
        if (timeDiff > 0) {
            int seconds = (int) (timeDiff / 1000) % 60;
            int minutes = (int) ((timeDiff / (1000 * 60)) % 60);
            int hours = (int) ((timeDiff / (1000 * 60 * 60)) % 24);
            tvTimeRemaining.setText(hours + " hrs " + minutes + " mins " + seconds + " sec");
        } else {
            tvTimeRemaining.setText("Expired!!");
        }
    }

}
