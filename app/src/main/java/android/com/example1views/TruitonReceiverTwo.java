package android.com.example1views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class TruitonReceiverTwo extends BroadcastReceiver {
    private static String Log_Tag = "SendOrderedBroadcastActivity:TruitonReceiverTwo";
    private static String Extras = "Breadcrumb";
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle results = getResultExtras(true);
        results.putString(Extras, Log_Tag);
        Log.i(Log_Tag, "Priority = 2");
        //abortBroadcast();
    }

}

