package cf.varazdinevents.croatiaevents.places.events;

import android.os.Bundle;

import cf.varazdinevents.croatiaevents.MainApplication;
import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.base.BaseNavigationActivity;
import cf.varazdinevents.croatiaevents.di.ActivityComponent;
import cf.varazdinevents.croatiaevents.di.ComponentCreator;
import cf.varazdinevents.croatiaevents.di.HasComponent;
import cf.varazdinevents.croatiaevents.di.modules.ActivityModule;

/**
 * Created by antonio on 25/07/17.
 */

public class EventsActivity extends BaseNavigationActivity implements HasComponent<ActivityComponent> {

    private ActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = ComponentCreator.create(this, MainApplication.get(this).getAppComponent());

        getSupportFragmentManager().beginTransaction().add(R.id.content_holder, new EventsFragment()).commit();
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
}
