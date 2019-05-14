package android.com.example1views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ItemDetails extends AppCompatActivity {

    TextView tv_details;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tv_details = findViewById(R.id.tv_details);

        tv_details.setText(getIntent().getStringExtra("myValue"));
    }
}
