package cf.varazdinevents.croatiaevents.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import cf.varazdinevents.croatiaevents.MainApplication;
import cf.varazdinevents.croatiaevents.di.ForApplication;
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
    @ForApplication
    MainApplication application() {
        return application;
    }

    @Provides
    @Singleton
    @ForApplication
    Context context() {
        return application.getApplicationContext();
    }

}
