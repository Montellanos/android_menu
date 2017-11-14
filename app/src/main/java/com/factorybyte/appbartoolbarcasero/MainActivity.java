package com.factorybyte.appbartoolbarcasero;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.factorybyte.appbartoolbarcasero.Adapters.TabsFragmentAdapter;
import com.factorybyte.appbartoolbarcasero.Fragments.AFragment;
import com.factorybyte.appbartoolbarcasero.Fragments.BFragment;
import com.factorybyte.appbartoolbarcasero.Fragments.CFragment;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.setupWithViewPager(viewPager);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }





    public void setupViewPager(ViewPager upViewPager) {
        TabsFragmentAdapter tabsAdapter =  new TabsFragmentAdapter(getSupportFragmentManager());

        tabsAdapter.addFragment(new AFragment(), "A");
        tabsAdapter.addFragment(new BFragment(), "B");
        tabsAdapter.addFragment(new CFragment(), "C");
        viewPager.setAdapter(tabsAdapter);
    }
}
