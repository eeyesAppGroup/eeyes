package com.eeyes.designtemplate.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eeyes.designtemplate.R;
import com.eeyes.designtemplate.adapter.EeyesAcManagerFragmentAdapter;
import com.eeyes.designtemplate.common.EeyesNewsTypes;
import com.eeyes.designtemplate.ui.activity.MainActivity;

import java.util.ArrayList;

import static android.R.id.toggle;

/**
 * Created by Lei Guo on 2016/10/9.
 */

public class EeyesAcManageFragment extends Fragment{

    private Context context;

    private EeyesAcManagerFragmentAdapter adapter;

    private TabLayout tabLayout;


    public EeyesAcManageFragment(){

    }

    public static EeyesAcManageFragment newInstance(){
        return new EeyesAcManageFragment();
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.eeyes_tickets_booking);
        ((MainActivity) context).setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) ((MainActivity) context).findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                ((MainActivity) context), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(EeyesNewsTypes.getTypeLength());
        adapter = new EeyesAcManagerFragmentAdapter(getChildFragmentManager(), context);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }




}
