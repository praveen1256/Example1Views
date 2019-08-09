package android.com.example1views;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BoundActivity extends AppCompatActivity {

    BoundService2 mBoundService;
    boolean mServiceBound = false;
    Button bt_start;
    Button bt_stop;
    Button bt_getvalue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);
        bt_start = findViewById(R.id.bt_start);
        bt_stop = findViewById(R.id.bt_stop);
        bt_getvalue = findViewById(R.id.bt_getvalue);
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });
        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });
        bt_getvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBoundService != null)
                    Toast.makeText(BoundActivity.this, mBoundService.getData(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService2.MyBinder myBinder = (BoundService2.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };


    private void stopService() {
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
//        Intent intent = new Intent(this,
//                BoundService.class);
//        stopService(intent);
    }

    private void startService() {
        Intent intent = new Intent(this, BoundService2.class);
//        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }



}
