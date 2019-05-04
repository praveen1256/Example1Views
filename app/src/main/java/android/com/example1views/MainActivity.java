package android.com.example1views;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Views only Push
    String TAG = "MainActivity LifeCycle";
    EditText et_username;
    Button bt_login;
    Button bt_clear;
    CheckBox cb_save;
    RatingBar ratingBar;
    TextView tv_status;// ctrl+d to create new copy in new line

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v(TAG,TAG+" : onCreate");

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });
        et_username = findViewById(R.id.et_username);
        bt_login = findViewById(R.id.bt_login);
        bt_clear = findViewById(R.id.bt_clear);
        tv_status = findViewById(R.id.tv_status);
        cb_save = findViewById(R.id.cb_save);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_save.isChecked()){
                    // save
                } else {
                    // remove
                }

                if(et_username.getText().toString().length()>0){
                    String userName = et_username.getText().toString().trim();
                    displayToast("Valid User "+userName);
                    // Server code will userName
//                    tv_status.setText("Valid User "+userName);
                } else {
//                    tv_status.setText("In Valid User");
                    Toast.makeText(MainActivity.this,"In Valid User",Toast.LENGTH_LONG).show();
                }
            }

        });

        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_username.setText("");
                tv_status.setText("Status");
            }
        });

        cb_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"Your username will be saved",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"Your username not saved",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void displayToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
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
