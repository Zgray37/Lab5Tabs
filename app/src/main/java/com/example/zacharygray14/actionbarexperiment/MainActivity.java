package com.example.zacharygray14.actionbarexperiment;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAB_KEY_INDEX = "tab_key";

    private Fragment breakfastFragment;
    private Fragment lunchFragment;
    private Fragment snackFragment;
    private Fragment dinnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ACTIONBAR
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        //TABS
        ActionBar.Tab breakfastTab = actionBar.newTab().setText(getString(R.string.ui_tabname_breakfast));
        ActionBar.Tab lunchTab = actionBar.newTab().setText(getString(R.string.ui_tabname_lunch));
        ActionBar.Tab snackTab = actionBar.newTab().setText(getString(R.string.ui_tabname_snack));
        ActionBar.Tab dinnerTab = actionBar.newTab().setText(getString(R.string.ui_tabname_dinner));

        //FRAGMENTS
        breakfastFragment = new BreakfastFragment();
        snackFragment = new SnackFragment();
        lunchFragment = new LunchFragment();
        dinnerFragment = new DinnerFragment();

        //LISTENERS
        breakfastTab.setTabListener(new MainActivity.MyTabsListener(breakfastFragment, getApplicationContext()));
        snackTab.setTabListener(new MainActivity.MyTabsListener(snackFragment, getApplicationContext()));
        lunchTab.setTabListener(new MainActivity.MyTabsListener(lunchFragment, getApplicationContext()));
        dinnerTab.setTabListener(new MainActivity.MyTabsListener(dinnerFragment, getApplicationContext()));

        //ADD TABS
        actionBar.addTab(breakfastTab);
        actionBar.addTab(lunchTab);
        actionBar.addTab(snackTab);
        actionBar.addTab(dinnerTab);

        //NAVIGATION
        if (savedInstanceState != null){
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_KEY_INDEX,0));

        }

    }


    class MyTabsListener implements ActionBar.TabListener {
        public Fragment fragment;

        public MyTabsListener(Fragment f, Context context) {
            fragment = f;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }
    }
}
