package android.com.example1views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //  Some of the important system wide intents

    //  android.intent.action.BATTERY_LOW
    //  android.intent.action.BOOT_COMPLETED
    //  android.intent.action.CALL
    //  android.intent.action.DATE_CHANGED
    //  android.intent.action.REBOOT
    //  android.net.conn.CONNECTIVITY_CHANGE

    String TAG = "MainActivity LifeCycle";
    LocalBroadcastManager localBroadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Log.v(TAG,TAG+" : onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        localBroadcastManager.registerReceiver(broadcastReceiver,
                new IntentFilter("localbroadcast"));
        Log.v(TAG,TAG+" : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,TAG+" : onResume");
        sendLocalBroadcast();
//        broadcastIntent();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,TAG+" : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
        Log.v(TAG,TAG+": onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,TAG+" : onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,TAG+" : onRestart");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v(TAG,TAG+" : onBackPressed");
    }

    public void broadcastIntent(){
        Intent intent = new Intent();
        intent.setAction("myCustomReceiver");
        intent.putExtra("key","Main Activity");
        sendBroadcast(intent);
    }

    private void sendLocalBroadcast(){
        Intent intent = new Intent("localbroadcast");
        localBroadcastManager.sendBroadcast(intent);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Local Broadcast",Toast.LENGTH_LONG).show();
        }
    };


}
