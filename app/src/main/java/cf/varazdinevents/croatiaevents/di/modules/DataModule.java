package cf.varazdinevents.croatiaevents.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import cf.varazdinevents.croatiaevents.base.utils.SharedPrefs;
import cf.varazdinevents.croatiaevents.data.db.EventsDatabase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by antonio on 27/07/17.
 */

@Module
public class DataModule {
    @Provides
    @Singleton
    SharedPrefs provideSharedPrefs(Context context) {
        return new SharedPrefs(context);
    }

    @Provides
    @Singleton
    EventsDatabase eventsDatabase(Context context) {
        return Room.databaseBuilder(context, EventsDatabase.class, "db").build();
    }
}
