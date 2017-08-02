package cf.varazdinevents.croatiaevents.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;

import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.databinding.DrawerHeaderBinding;
import cf.varazdinevents.croatiaevents.places.settings.SettingsActivity;
import timber.log.Timber;

/**
 * Created by antonio on 25/07/17.
 */

public abstract class BaseNavigationActivity extends BaseActivity {

    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        if (navigationView == null || toolbar == null || drawerLayout == null) {
            Timber.e("Navigation view or toolbar or drawer layout not found!");
            return;
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(
                this, getDrawer(), getToolbar(), R.string.drawer_open, R.string.drawer_close);
        getDrawer().addDrawerListener(drawerToggle);

        DrawerHeaderBinding drawerHeaderBinding = DataBindingUtil.inflate(
                getLayoutInflater(),
                R.layout.drawer_header,
                getNavigationView(),
                false
        );

        drawerHeaderBinding.setCity("Varaždin");
        getNavigationView().addHeaderView(drawerHeaderBinding.getRoot());
    }

    protected DrawerLayout getDrawer() {
        return drawerLayout;
    }

    @Override
    protected void onStart() {
        super.onStart();
        getNavigationView().setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.menu_all_events: {
                    break;
                }
                case R.id.menu_settings: {
                    Intent intent = new Intent(this, SettingsActivity.class);
                    startActivity(intent);
                    break;
                }
            }

            ((DrawerLayout) getNavigationView().getParent()).closeDrawer(Gravity.START);
            return true;
        });
    }

    @NonNull
    public ActionBarDrawerToggle getDrawerToggle() {
        return drawerToggle;
    }

    @NonNull
    public NavigationView getNavigationView() {
        return navigationView;
    }

    @NonNull
    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {

        }

        return false;
    }

    @Override
    public void onBackPressed() {
        if (getDrawer().isDrawerOpen(GravityCompat.START)) {
            getDrawer().closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
