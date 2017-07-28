package cf.varazdinevents.croatiaevents.di;

import javax.inject.Singleton;

import cf.varazdinevents.croatiaevents.base.utils.SharedPrefs;
import cf.varazdinevents.croatiaevents.data.EventRepository;
import cf.varazdinevents.croatiaevents.data.EventRepositoryImpl;
import cf.varazdinevents.croatiaevents.data.api.RestService;
import cf.varazdinevents.croatiaevents.data.db.EventDao;
import dagger.Module;
import dagger.Provides;

/**
 * Created by antonio on 28/07/17.
 */

@Module
class RepositoryModule {

    @Provides
    @Singleton
    EventRepository eventRepository(RestService service, EventDao dao, SharedPrefs prefs) {
        return new EventRepositoryImpl(service, dao, prefs);
    }
}
