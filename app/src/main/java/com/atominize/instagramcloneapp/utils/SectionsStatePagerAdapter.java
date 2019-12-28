package com.atominize.instagramcloneapp.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "SectionsStatePagerAdapt";

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final HashMap<Fragment, Integer> fragments = new HashMap<>();
    private final HashMap<String, Integer> fragmentNumbers = new HashMap<>();
    private final HashMap<Integer, String> fragmentNames = new HashMap<>();

    public SectionsStatePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragments(Fragment fragment, String fragmentName) {
        fragmentList.add(fragment);
        fragments.put(fragment, fragmentList.size() - 1);
        fragmentNumbers.put(fragmentName, fragmentList.size() - 1);
        fragmentNames.put(fragmentList.size() - 1, fragmentName);
    }


    /**
     * returns the fragment number with the name @param
     * @param fragmentName
     * @return
     */
    public Integer getFragmentNumber(String fragmentName) {
        if (fragmentNumbers.containsKey(fragmentName)) {
            return fragmentNumbers.get(fragmentName);
        } else {
            return null;
        }
    }

    /**
     * returns the fragment number with the name @param
     * @param fragment
     * @return
     */
    public Integer getFragmentNumber(Fragment fragment) {
        if (fragments.containsKey(fragment)) {
            return fragments.get(fragment);
        } else {
            return null;
        }
    }

    /**
     * returns the name of the fragment @param
     * @param fragmentNumber
     * @return
     */
    public String getFragmentName(Integer fragmentNumber) {
        if (fragmentNames.containsKey(fragmentNumber)) {
            return fragmentNames.get(fragmentNumber);
        } else {
            return null;
        }
    }
}

