package com.eeyes.designtemplate.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.eeyes.designtemplate.R;
import com.eeyes.designtemplate.ui.fragment.EeyesAcFragment;
import com.eeyes.designtemplate.ui.fragment.EeyesAcManageFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        navigationView.setCheckedItem(R.id.nav_home);
        EeyesAcManageFragment fragment = new EeyesAcManageFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void initViews(){
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        //暂时都跳转到LatestFragment
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                changeFragment(new EeyesAcManageFragment());
                toolbar.setTitle(getString(R.string.app_name));
                break;
            case R.id.nav_theme_post:
                changeFragment(new EeyesAcManageFragment());
                toolbar.setTitle(menuItem.getTitle());
                break;
            case R.id.nav_hot_spot:
                changeFragment(new EeyesAcManageFragment());
                toolbar.setTitle(menuItem.getTitle());
                break;
            case R.id.nav_guokr:
                changeFragment(new EeyesAcManageFragment());
                toolbar.setTitle(menuItem.getTitle());
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    //改变fragment
    private void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
    }
}
