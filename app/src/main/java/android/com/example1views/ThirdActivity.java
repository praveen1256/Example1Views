package android.com.example1views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_edittext;
    Button bt_finish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        String data = getIntent().getExtras().getString("data");
        Log.v("Data",""+data);
        et_edittext = findViewById(R.id.et_edittext);
        bt_finish = findViewById(R.id.bt_finish);
        bt_finish.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
