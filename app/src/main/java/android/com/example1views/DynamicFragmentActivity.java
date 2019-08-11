package android.com.example1views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DynamicFragmentActivity extends AppCompatActivity implements FragmentCommunication {

    String TAG = "MainActivity LifeCycle";
    TextView tv_text;
    Button bt_one;
    Button bt_two;
    Button bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        bt_one = findViewById(R.id.bt_one);
        bt_two = findViewById(R.id.bt_two);
        bt_back = findViewById(R.id.bt_back1);
        bt_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFrag(new FragmentOne());
            }
        });
        bt_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFrag(new FragmentTwo());
            }
        });
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentBackStack();
            }
        });
        Log.v(TAG, TAG + " : onCreate");
    }

    private void replaceFrag(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fl_container, fragment);
        fragmentTransaction.add(R.id.fl_container, fragment);
        if (fragment instanceof FragmentOne)
            fragmentTransaction.addToBackStack("frag one");
        else
            fragmentTransaction.addToBackStack("frag two");
        fragmentTransaction.commit();
    }

    private void fragmentBackStack() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Toast.makeText(this,"Count "+fragmentManager.getBackStackEntryCount(),Toast.LENGTH_LONG).show();
        if(fragmentManager.getBackStackEntryCount()>1){
            fragmentManager.popBackStackImmediate();
        } else {
            finish();
        }
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

    public void setData(String msg) {
        tv_text.setText(msg);
    }

    @Override
    public void setDataCommunication(String msg) {
        setData(msg);
    }
}
