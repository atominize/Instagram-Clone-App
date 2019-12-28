package com.atominize.instagramcloneapp.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.atominize.instagramcloneapp.R;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        Log.d(TAG, "onCreate: started");

        goBack();
        setupListView();
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

    private void setupListView() {
        Log.d(TAG, "setupListView: Initializing account settings list");
        ListView listView = findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));

        ArrayAdapter adapter = new ArrayAdapter(AccountSettingsActivity.this,
                android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);
    }
}
