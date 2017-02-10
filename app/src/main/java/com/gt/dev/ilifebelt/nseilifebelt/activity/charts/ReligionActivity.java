package com.gt.dev.ilifebelt.nseilifebelt.activity.charts;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.analytics.Tracker;
import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.controller.MyApplication;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.religion.HighStatusFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.religion.LowStatusFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.religion.MedStatusFragment;

import java.util.ArrayList;
import java.util.List;

public class ReligionActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyApplication myApp;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religion);
        viewPager = (ViewPager) findViewById(R.id.vp_religion);
        setViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_religion);
        tabLayout.setupWithViewPager(viewPager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Religión");

        startAnalytics();
    }

    private void startAnalytics() {
        myApp = (MyApplication) getApplication();
        mTracker = myApp.getDefaultTracker();
    }

    private void setViewPager(ViewPager viewPager) {
        ViewPagerAdapterReligion adapter = new ViewPagerAdapterReligion(getSupportFragmentManager());
        adapter.addFragment(new LowStatusFragment(), "Niveles Bajos");
        adapter.addFragment(new MedStatusFragment(), "Niveles Medios");
        adapter.addFragment(new HighStatusFragment(), "Niveles Altos");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapterReligion extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentListTitle = new ArrayList<>();

        public ViewPagerAdapterReligion(FragmentManager manager) {
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
            mFragmentListTitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentListTitle.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
