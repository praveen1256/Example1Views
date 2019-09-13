package android.com.example1views;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

//Communicating between Activity and Service(Bind Service)
//
//        Activity with 3 Buttons
//        1)	To Bind the service
//        2)	To unBind the service
//        3)	Get the value from service
//        ServieConnection Class To get service Object
//
//
//        Service class
//IBinder Inner Class which retruns Service Object
//                We have to create some method to return the value
//
//        Between Two Apps
//
//        AIDL(Android Interface Defination Language) it is a interface some abstart methods
//
//


public class BoundService2 extends Service {

    private IBinder mBinder = new BoundService2.MyBinder();
    int value = 0;
    int percent;
    boolean onBind = true;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(BoundService2.this,"Service Create",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(BoundService2.this,"Service Bind",Toast.LENGTH_LONG).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (onBind){
                    value++;
                    try {
                        Thread.sleep(1000);//1 Sec
                        // percent =10;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(BoundService2.this,"Service Un Bind",Toast.LENGTH_LONG).show();
        onBind = false;
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(BoundService2.this,"Service Destroy",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    public String getData(){
        return "I'm From Service "+value;
    }

    public int getPercent(){
        return percent;
    }

    public class MyBinder extends Binder {
        BoundService2 getService() {
            return BoundService2.this;
        }
    }

}
