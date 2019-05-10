package android.com.example1views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity LifeCycle";
    ListView lv_list;
    String listData[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
    int listImages[] = {R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,
            R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,
            R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2};
    ArrayAdapter<String> stringArrayAdapter;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_list = findViewById(R.id.lv_list);
        setListView();
        Log.v(TAG,TAG+" : onCreate");
    }

    private void setListView() {
//        stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,listData);
        stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.item_list,R.id.tv_item_lv,listData);

        // Custom Adapter
        myAdapter = new MyAdapter(this,listData,listImages);

        lv_list.setAdapter(myAdapter);
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedString = listData[position];
                Log.v(TAG,TAG+" : "+selectedString);
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
