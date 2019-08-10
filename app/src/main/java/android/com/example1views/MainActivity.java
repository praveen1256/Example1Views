package android.com.example1views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Http with Async
    // Volley
    // Retrofit

    String TAG = "MainActivity LifeCycle";
    MyClass myClass = MyClass.getInstance();
    MyClass myClass1 = MyClass.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,TAG+" : onCreate");



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,TAG+" : onStart");
        RetrofitClientInstance retrofitClientInstance = RetrofitClientInstance.getMainInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,TAG+" : onResume");
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<SamplePojo> samplePojoCall = getDataService.getDetails();
//        Call<SamplePojo> samplePojoCall1 = getDataService.loginPath(et_username.getText(),et_username.getText());
        SamplePojo samplePojo = new SamplePojo();
        samplePojo.setName("xxx");
        samplePojo.setPlace("1234");
//        Call<SamplePojo> samplePojoCall = getDataService.loginBody("key",samplePojo);
        samplePojoCall.enqueue(new Callback<SamplePojo>() {
            @Override
            public void onResponse(Call<SamplePojo> call, Response<SamplePojo> response) {
                SamplePojo samplePojo = response.body();
                Toast.makeText(MainActivity.this,samplePojo.getName()+" : "+samplePojo.getPlace(),Toast.LENGTH_LONG).show();;
            }

            @Override
            public void onFailure(Call<SamplePojo> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,TAG+" : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
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


    public void login(){
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<SamplePojo> samplePojoCall = getDataService.loginValidation1("","");

//        SamplePojo samplePojo = new SamplePojo();
//        samplePojo.setName("ajkla");
//        samplePojo.setPlace("dsjdla");
//
//        getDataService.loginBody("key",samplePojo);

        samplePojoCall.enqueue(new Callback<SamplePojo>() {
            @Override
            public void onResponse(Call<SamplePojo> call, Response<SamplePojo> response) {

            }

            @Override
            public void onFailure(Call<SamplePojo> call, Throwable throwable) {
                throwable.getMessage();
                    if(throwable instanceof UnknownHostException){
                        // alert
                    } else {
                        // alert someting went wrong
                    }
            }
        });
    }
}
