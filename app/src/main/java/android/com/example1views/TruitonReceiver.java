package android.com.example1views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class TruitonReceiver extends BroadcastReceiver {
    private static String Log_Tag = "SendOrderedBroadcastActivity:TruitonReceiver";
    private static String Extras = "Breadcrumb";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle results = getResultExtras(true);
        String trail = results.getString(Extras);
        results.putString(Extras, trail + "->" + Log_Tag);
        Log.i(Log_Tag, "Priority = 1");
    }

}

