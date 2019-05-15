package android.com.example1views;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = "MainActivity LifeCycle";
    Button bt_clickme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_clickme = findViewById(R.id.bt_clickme);
        bt_clickme.setOnClickListener(this);
        Log.v(TAG, TAG + " : onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, TAG + " : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, TAG + " : onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, TAG + " : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, TAG + ": onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, TAG + " : onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, TAG + " : onRestart");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v(TAG, TAG + " : onBackPressed");
    }

    @Override
    public void onClick(View v) {
        second();
    }

    private void callBrowser() {
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.google.com"));
        startActivity(browser);
    }

    private void call() {
        Intent browser = new Intent(Intent.ACTION_CALL);
        browser.setData(Uri.parse("tel:1234567890"));
        startActivity(browser);
    }

    private void dialNumber() {
        Intent browser = new Intent(Intent.ACTION_DIAL);
        browser.setData(Uri.parse("tel:1234567890"));
        startActivity(browser);
    }

    private void second() {
        Intent second = new Intent(this, SecondActivity.class);
        startActivityForResult(second, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            String text = data.getStringExtra("edittext");
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }
}
