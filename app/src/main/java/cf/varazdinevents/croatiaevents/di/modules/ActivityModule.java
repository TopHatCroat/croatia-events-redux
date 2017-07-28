package cf.varazdinevents.croatiaevents.di.modules;

import cf.varazdinevents.croatiaevents.base.BaseActivity;
import dagger.Module;

/**
 * Created by antonio on 25/07/17.
 */

@Module
public class ActivityModule {

    protected final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

}