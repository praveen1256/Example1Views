package android.com.example1views;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

public class MultiDexApplicaiton extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}
