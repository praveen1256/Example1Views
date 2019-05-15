package android.com.example1views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_edittext;
    Button bt_finish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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
        Intent data = new Intent();
        data.putExtra("edittext",et_edittext.getText().toString());
        setResult(RESULT_OK,data);
        finish();
    }
}
