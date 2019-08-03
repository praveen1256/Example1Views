package android.com.example1views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerTouchListener.ClickListener {

    String TAG = "MainActivity LifeCycle";

    // ListView
    ListView lv_list;
    String listData[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
    int listImages[] = {R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,
            R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,
            R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2,R.drawable.ic_image1,R.drawable.ic_image2};
    ArrayAdapter<String> stringArrayAdapter;
    MyAdapter myAdapter;


    // RecyclerView
    RecyclerView rv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_list = findViewById(R.id.lv_list);
        rv_list = findViewById(R.id.rv_list);

        setListView();
        setRecyclerView();
        Log.v(TAG,TAG+" : onCreate");
    }

    private void setRecyclerView() {

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,listData,listImages);

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, true);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false);

//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
//        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        rv_list.setLayoutManager(mLayoutManager);
//        rv_list.setItemAnimator(new DefaultItemAnimator());
        rv_list.setAdapter(myRecyclerViewAdapter);
        rv_list.addOnItemTouchListener(new RecyclerTouchListener(this,rv_list,this));

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
                Toast.makeText(MainActivity.this,""+listData[position],Toast.LENGTH_LONG).show();
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

    @Override
    public void onClick(View view, int position) {
        Log.v(TAG,TAG+" : RV Position "+position);
//        Intent intent = new Intent(this,ItemDetails.class);
//        intent.putExtra("myValue",""+listData[position]);
//        startActivity(intent);
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
