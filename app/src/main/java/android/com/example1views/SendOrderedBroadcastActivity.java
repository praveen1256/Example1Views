package android.com.example1views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class SendOrderedBroadcastActivity extends Activity {
    private static String Log_Tag = "SendOrderedBroadcastActivity";
    private static String Action = "com.truiton.OrderedBroadcast";
    private static String Extras = "Breadcrumb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter(Action);


        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle results = getResultExtras(true);
                String trail = results.getString(Extras);
                results.putString(Extras, trail + "->" + Log_Tag);
                Log.i(Log_Tag, "Same Class Receiver");
            }
        }, filter);

        Intent intent = new Intent(Action);//1-intent,3 result recevier,5 result ok
        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @SuppressLint("NewApi")
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle results = getResultExtras(true);
                Log.i(Log_Tag, "Final Result Receiver = " + results.getString(Extras, "nil"));
            }
        }, null, Activity.RESULT_OK, null, null);
    }

}

