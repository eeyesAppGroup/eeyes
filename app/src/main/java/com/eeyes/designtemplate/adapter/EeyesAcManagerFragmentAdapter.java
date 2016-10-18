package com.eeyes.designtemplate.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.eeyes.designtemplate.common.EeyesNewsTypes;
import com.eeyes.designtemplate.ui.fragment.EeyesAcFragment;

/**
 * Created by Lizhaotailang on 2016/8/10.
 */

public class EeyesAcManagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] titles;
    private final Context context;

    public EeyesAcManagerFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        titles = EeyesNewsTypes.TYPES;
    }

    @Override
    public Fragment getItem(int position) {
        return EeyesAcFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
