package cf.varazdinevents.croatiaevents.di.modules;

import cf.varazdinevents.croatiaevents.base.BaseActivity;
import cf.varazdinevents.croatiaevents.di.ActivityScope;
import cf.varazdinevents.croatiaevents.di.ForActivity;
import cf.varazdinevents.croatiaevents.places.Navigator;
import cf.varazdinevents.croatiaevents.places.NavigatorImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by antonio on 25/07/17.
 */

@Module
public class ActivityModule {

    protected final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @ForActivity
    @Provides
    public Navigator navigator() {
        return new NavigatorImpl(activity, activity.getSupportFragmentManager());
    }
}