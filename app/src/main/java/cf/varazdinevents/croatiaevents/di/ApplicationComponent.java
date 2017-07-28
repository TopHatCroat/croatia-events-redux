package cf.varazdinevents.croatiaevents.di;

import javax.inject.Singleton;

import cf.varazdinevents.croatiaevents.di.modules.ActivityModule;
import cf.varazdinevents.croatiaevents.di.modules.ApplicationModule;
import cf.varazdinevents.croatiaevents.di.modules.DataModule;
import cf.varazdinevents.croatiaevents.di.modules.NetworkModule;
import cf.varazdinevents.croatiaevents.places.events.EventListViewModel;
import dagger.Component;

/**
 * Created by antonio on 25/07/17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        DataModule.class,
})
public interface ApplicationComponent {
    ActivityComponent plus(ActivityModule activityModule);

    void inject(EventListViewModel eventListViewModel);
}
