package cf.varazdinevents.croatiaevents.places.events;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;

import javax.inject.Inject;

import cf.varazdinevents.croatiaevents.MainApplication;
import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.base.BaseNavigationActivity;
import cf.varazdinevents.croatiaevents.di.ActivityComponent;
import cf.varazdinevents.croatiaevents.di.ComponentCreator;
import cf.varazdinevents.croatiaevents.di.ForActivity;
import cf.varazdinevents.croatiaevents.di.HasComponent;
import cf.varazdinevents.croatiaevents.di.modules.ActivityModule;
import cf.varazdinevents.croatiaevents.places.Navigator;

/**
 * Created by antonio on 25/07/17.
 */

public class EventsActivity extends BaseNavigationActivity implements HasComponent<ActivityComponent> {

    @Inject
    @ForActivity
    Navigator navigator;
    private ActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = ComponentCreator.create(this, MainApplication.get(this).getAppComponent());
        component.inject(this);

        navigator.toListEvents();
    }

    @Override
    protected int getLayout() {
        return R.layout.view_main;
    }

    @Override
    protected void setupActivityComponent() {
        MainApplication.get(this).getAppComponent().plus(new ActivityModule(this));
    }

    @Override
    public ActivityComponent getComponent() {
        return component;
    }

    @Override
    public void onBackPressed() {
        if (getDrawer().isDrawerOpen(GravityCompat.START)) {
            getDrawer().closeDrawer(GravityCompat.START);
        } else {
            navigator.goBack();
        }
    }
}
