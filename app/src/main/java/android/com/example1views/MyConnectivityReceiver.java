package android.com.example1views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyConnectivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = Thread.currentThread().getName();
        Toast.makeText(context,name+" : Tapped on Network",Toast.LENGTH_LONG).show();
    }
}
