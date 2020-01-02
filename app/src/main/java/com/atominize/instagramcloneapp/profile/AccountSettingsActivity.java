package com.atominize.instagramcloneapp.profile;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.atominize.instagramcloneapp.R;
import com.atominize.instagramcloneapp.home.HomeActivity;
import com.atominize.instagramcloneapp.utils.BottomNavigationViewHelper;
import com.atominize.instagramcloneapp.utils.SectionsStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";

    private SectionsStatePagerAdapter sectionsStatePagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        Log.d(TAG, "onCreate: started");

        viewPager = findViewById(R.id.vpContainer);
        relativeLayout = findViewById(R.id.rlOne);

        setupBottomNavigationView();
        goBack();
        settingsList();
        setupFragment();
    }

    private void setupViewPager(int fragmentNumber) {
        relativeLayout.setVisibility(View.GONE);
        Log.e(TAG, "setupViewPager: navigating to fragment #" + fragmentNumber);
        viewPager.setAdapter(sectionsStatePagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }

    private void setupFragment() {
        sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager(), 1);
        sectionsStatePagerAdapter.addFragments(new EditProfileFragment(),
                getString(R.string.edit_profile_fragment));
        sectionsStatePagerAdapter.addFragments(new SignOutFragment(),
                getString(R.string.sign_out_fragment));
    }

    private void goBack() {
        ImageView backArrow = findViewById(R.id.ivBack);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating back to Profile Activity");
                finish();
            }
        });
    }

    private void settingsList() {
        Log.d(TAG, "setupListView: Initializing account settings list");
        ListView listView = findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));
        options.add(getString(R.string.sign_out_fragment));

        ArrayAdapter adapter = new ArrayAdapter(AccountSettingsActivity.this,
                android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: navigating to fragment #" +i);
                setupViewPager(i);
            }
        });
    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up bottom navigation view");

        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bnBottomNav);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(AccountSettingsActivity.this, bottomNavigationViewEx);

//        Menu menu = bottomNavigationViewEx.getMenu();
//        MenuItem menuItem = menu.getItem(0);
//        menuItem.setChecked(true);

        bottomNavigationViewEx.setItemBackground(0, Color.RED);


    }
}
