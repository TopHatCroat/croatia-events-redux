package cf.varazdinevents.croatiaevents.places.events;

import android.support.annotation.MainThread;

import cf.varazdinevents.croatiaevents.MainApplication;
import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.base.BaseNavigationActivity;

/**
 * Created by antonio on 25/07/17.
 */

public class EventsActivity extends BaseNavigationActivity {

    @Override
    protected int getLayout() {
        return R.layout.view_main;
    }

    @Override
    protected void setupActivityComponent() {
        MainApplication.get(this).getAppComponent().plus(new ActivityModule(this));
    }
}
