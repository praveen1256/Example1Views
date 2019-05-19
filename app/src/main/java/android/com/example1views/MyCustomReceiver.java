package android.com.example1views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyCustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"My Custom Receiver "+intent.getStringExtra("key"),Toast.LENGTH_LONG).show();
        // Do something what to need
    }
}
