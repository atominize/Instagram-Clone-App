package com.atominize.instagramcloneapp.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.atominize.instagramcloneapp.R;
import com.squareup.picasso.Picasso;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    private ImageView profileImage, backArrow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        profileImage = view.findViewById(R.id.ciProfileImage);
        backArrow = view.findViewById(R.id.ivBack);

        setImageProfile();
        goBack();

        return view;
    }

    private void goBack() {
        Log.d(TAG, "goBack: going back to profile activity");
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }

    private void setImageProfile() {
        Log.d(TAG, "setImageProfile: setting profile image");

        Picasso.get().load(R.mipmap.ic_launcher).into(profileImage);
    }
}
