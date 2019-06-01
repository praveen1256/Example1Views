package android.com.example1views;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity LifeCycle";

    /*
    *   Material Design Topics
    *
    *   Recycler View
    *   CardView
    *   Drawer Layout & Navigation View
    *   Toolbar
    *   TabLayout and Viewpager
    *   Coordinator Layout
    *   Snack Bar
    *   Collapse Toolbar
    *   Floating Action Button
    *
    * */


    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Window.settitel remove
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar =  findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.tv_toolbar_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Toolbar Title Clicked",Toast.LENGTH_LONG).show();
            }
        });
        tabLayout =  findViewById(R.id.tabs);
        viewPager =  findViewById(R.id.viewpager);
        setupViewPager();
//        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
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
}
