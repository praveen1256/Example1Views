package android.com.example1views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentCommunication{

    String TAG = "MainActivity LifeCycle";
    TextView tv_text;
    EditText value1;
    int result =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text = findViewById(R.id.tv_text);
        Log.v(TAG,TAG+" : onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,TAG+" : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Button Click
//        result += Integer.parseInt(value1.getText().toString())+Integer.parseInt(value1.getText().toString());
//        value1.setText("");
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
//        result=0;
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

    public void setData(String msg){
        tv_text.setText(msg);
    }

    @Override
    public void setDataCommunication(String msg) {
//        setData(msg);
        tv_text.setText(msg);
    }
}
