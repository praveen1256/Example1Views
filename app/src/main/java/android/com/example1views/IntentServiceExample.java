package android.com.example1views;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class IntentServiceExample extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntentServiceExample(String name) {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do you work
        // It will stop once the work is done
        // Play Song
        Log.v("IntentServiceExample","onStart : "+Thread.currentThread().getName());
    }
}
