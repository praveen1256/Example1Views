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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity LifeCycle";

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager =  findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout =  findViewById(R.id.tabs);
        toolbar =  findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
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
