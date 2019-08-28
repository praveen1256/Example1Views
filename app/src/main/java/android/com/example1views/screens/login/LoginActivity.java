package android.com.example1views.screens.login;

import android.com.example1views.R;
import android.com.example1views.screens.login.model.LoginResponse;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    // MVC,MVP,MVVM

    String TAG = "LoginActivity LifeCycle";
    EditText et_username;
    Button bt_login;

    ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = findViewById(R.id.et_username);
        bt_login = findViewById(R.id.bt_login);

        iLoginPresenter = new ImpLoginPresenter(this);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLoginPresenter.loginValidation(et_username.getText().toString());
            }
        });

        bt_login.setOnClickListener(this);

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

    @Override
    public void successValidation() {
        Toast.makeText(this,"V Success",Toast.LENGTH_LONG).show();
        showToast("Validation Success");
        iLoginPresenter.callLoginApi(et_username.getText().toString());
    }

    @Override
    public void failValidation(String msg) {
        showToast(msg);
    }

    @Override
    public void loginApiSuccess(LoginResponse loginResponse) {
        showToast(loginResponse.getMessage());
        //navigate to home screen
    }

    @Override
    public void loginApiFailed() {
        showToast("Login Failed");
    }

    private void showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View view) {
        iLoginPresenter.loginValidation(et_username.getText().toString());
    }
}
