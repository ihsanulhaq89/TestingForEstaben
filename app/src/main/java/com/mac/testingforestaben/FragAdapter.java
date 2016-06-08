package com.mac.testingforestaben;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragAdapter extends FragmentStatePagerAdapter {
    private static final int ITEMS = 3;

    public FragAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show image
                return SwitchFragment.init(position);
            case 1: // Fragment # 1 - This will show image
                return DummyFragment.init(position);
            default:// Fragment # 2-9 - Will show list
                return DummyFragment.init(position);
        }
    }
}

