package com.atominize.instagramcloneapp.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.atominize.instagramcloneapp.R;
import com.atominize.instagramcloneapp.utils.BottomNavigationViewHelper;
import com.atominize.instagramcloneapp.utils.GridImageAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    private CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupWidgets();
        setupBottomNavigationView();
        setupToolBar();

        setImageProfile();

        tempGridSetup();
    }

    private void tempGridSetup() {
        ArrayList<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://www.gstatic.com/webp/gallery/1.jpg");
        imageUrls.add("https://www.gstatic.com/webp/gallery/2.jpg");
        imageUrls.add("https://www.gstatic.com/webp/gallery/3.jpg");
        imageUrls.add("https://www.gstatic.com/webp/gallery/4.jpg");
        imageUrls.add("https://www.gstatic.com/webp/gallery/5.jpg");

        setupImageGrid(imageUrls);
    }

    private void setupImageGrid(ArrayList<String> imageUrls) {
        GridView gridView = findViewById(R.id.gvOne);

        GridImageAdapter adapter = new GridImageAdapter(ProfileActivity.this,
                R.layout.layout_grid_image_view, imageUrls);

        gridView.setAdapter(adapter);
    }

    private void setImageProfile() {
        Log.d(TAG, "setImageProfile: setting profile image");

        Picasso.get().load(R.mipmap.ic_launcher).into(profileImage);
    }

    private void setupWidgets() {
        profileImage = findViewById(R.id.profile_image);
    }

    private void setupToolBar() {
        Toolbar toolbar = findViewById(R.id.tbProfile);
        setSupportActionBar(toolbar);

        ImageView profileMenu = findViewById(R.id.ivProfileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,
                        AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up bottom navigation view");

        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bnBottomNav);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileActivity.this, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }
}
