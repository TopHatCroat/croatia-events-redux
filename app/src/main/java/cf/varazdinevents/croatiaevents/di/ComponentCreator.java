package cf.varazdinevents.croatiaevents.di;

import cf.varazdinevents.croatiaevents.MainApplication;
import cf.varazdinevents.croatiaevents.base.BaseActivity;
import cf.varazdinevents.croatiaevents.base.BaseFragment;
import cf.varazdinevents.croatiaevents.di.modules.ActivityModule;
import cf.varazdinevents.croatiaevents.di.modules.ApplicationModule;
import cf.varazdinevents.croatiaevents.di.modules.FragmentModule;
import cf.varazdinevents.croatiaevents.di.modules.NetworkModule;

/**
 * Created by antonio on 27/07/17.
 */

public final class ComponentCreator {
    public static ApplicationComponent create(MainApplication app) {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(app))
                .networkModule(new NetworkModule())
                .build();
    }

    public static ActivityComponent create(BaseActivity activity, ApplicationComponent component) {
        return component.plus(new ActivityModule(activity));
    }

    public static FragmentComponent create(BaseFragment fragment, ActivityComponent component) {
        return component.plus(new FragmentModule(fragment));
    }
}
