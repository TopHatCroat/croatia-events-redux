package cf.varazdinevents.croatiaevents.di;

import javax.inject.Singleton;

import cf.varazdinevents.croatiaevents.MainApplication;
import cf.varazdinevents.croatiaevents.base.utils.SharedPrefs;
import dagger.Module;
import dagger.Provides;

/**
 * Created by antonio on 25/07/17.
 */
@Module
public class ApplicationModule {
    protected final MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MainApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    SharedPrefs provideSharedPrefs() {
        return new SharedPrefs(application);
    }

}
