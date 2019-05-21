package android.com.example1views;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("MyService","onCreate");
        mediaPlayer = MediaPlayer.create(this, R.raw.manasuna_edho_raagam);// raw/s.mp3
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.v("MyService","onStart : "+Thread.currentThread().getName());

        // Our Logic
        mediaPlayer.start();
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                stopSelf();
//            }
//        });
        return super.onStartCommand(intent, flags, startId);

    }

    public void stopMp(){
        mediaPlayer.stop();
    }

    @Override
    public void onDestroy() {
        Log.v("MyService","onDestroy");
        super.onDestroy();
    }
}
