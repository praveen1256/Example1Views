package android.com.example1views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CollapsingToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);
        getSupportActionBar().hide();
    }
}

