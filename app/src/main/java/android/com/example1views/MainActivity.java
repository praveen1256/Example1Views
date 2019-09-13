package android.com.example1views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


//      3 Types
//
//      1	Normal BR - Custom BR 		// Register the BR in manifest file
//      2	Local BR - By Default Custom 	// Need to Register/unregister in the Activity onResume/onStop
//            LocalBroadCastManager
//
//      3	Ordered BR - Result Back in Activity
//
//
//    Services/Unbound Service/Started Service 	:	Background ex : Playing Music/Download Something(Normal Data)
//    We can't communicate (Run in the UI Thread)
//    Activity will startService and stopService belongs to activity methods
//            ( selfStop) is belongs to service method
//    Wont any UI
//    boundService	:	Interact with Service and Activity
//    We can communicate
//    IntentService	:	Background ex Worker Thread/Async Call/Separate Thread
//    After completing the work it stops itself


    // ANR - Application Not Responding

    String TAG = "MainActivity LifeCycle";
    Intent service;
    TextView tv_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_view = findViewById(R.id.tv_view);
        Log.v(TAG,TAG+" : onCreate");
//        service = new Intent(this,MyService.class);
        service = new Intent(this,IntentServiceExample.class);
        startService(service);
        getResources().getString(R.string.app_name);

        tv_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,TAG+" : onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
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
        stopService(service);
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
