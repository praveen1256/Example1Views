package android.com.example1views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity LifeCycle";

    private Button mFabAndSnackbarButton;
    private Button mFabAndTwoWidgetsButton;
    private Button mCollapsingToolbarButton;
    private Button mCustomBehaviorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mFabAndSnackbarButton = (Button) findViewById(R.id.fabAndSnackbarButton);
        mFabAndSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FabAndSnackbarActivity.class));
            }
        });

        mFabAndTwoWidgetsButton = (Button) findViewById(R.id.fabAndTwoWidgetsButton);
        mFabAndTwoWidgetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FabFollowsWidgetActivity.class));
            }
        });

        mCollapsingToolbarButton = (Button) findViewById(R.id.collapseToolbarButton);
        mCollapsingToolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CollapsingToolbarActivity.class));
            }
        });

        mCustomBehaviorButton = (Button) findViewById(R.id.customBehaviorButton);
        mCustomBehaviorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CustomBehaviorActivity.class));
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,TAG+" : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
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
}
