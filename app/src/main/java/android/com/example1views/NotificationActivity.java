package android.com.example1views;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NotificationActivity extends AppCompatActivity {

    String TAG = "MainActivity LifeCycle";
    Intent service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,TAG+" : onCreate");
    }


    private void showNotification(){
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
        Notification n  = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pIntent)
                .setStyle(new Notification.BigTextStyle().bigText("jdksjfakfllaffafdddddddddjdksjfakfllaffafdddddddddddddddddddddddddddddddddddddddjdksj" +
                        "fakfllaffafdddddddddddddddddddddddddddddddddddddddjdksjfakfllaffafdddddddddddddddddddddddddddddddddddddddjdksjfakfllaffafddddddddddd" +
                        "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddjdksjfakfllaffafddddddddddddddddddddddddddddddddddddddd" +
                        "jdksjfakfllaffafdddddddddddddddddddddddddddddddddddddddjdksjfakfllaffafdddddddddddddddddddddddddddddddddddddddjdksjfakfllaffafdddddddddddddddddddddddddddddddddddddddjdksjfakfllaffafddddddddddddddddddddddddddddddddddddddd" +
                        "jdksjfakfllaffafdddddddddddddddddddddddddddddddddddddddjdksjfakfllaffafddddddddddddddddddddddddddddddddddddddd"))
                .setAutoCancel(true)
                .addAction(R.mipmap.ic_launcher, "Call", pIntent)
                .addAction(R.mipmap.ic_launcher, "More", pIntent)
                .addAction(R.mipmap.ic_launcher, "And more", pIntent).build();
        notificationManager.notify(0, n);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,TAG+" : onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        showNotification();
        Log.v(TAG,TAG+" : onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,TAG+" : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        stopService(service);
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
}
