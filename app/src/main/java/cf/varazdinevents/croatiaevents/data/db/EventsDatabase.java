package cf.varazdinevents.croatiaevents.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

/**
 * Created by antonio on 27/07/17.
 */

@Database(version = 1, entities = {EventEntity.class})
@TypeConverters(value = Converters.class)
public abstract class EventsDatabase extends RoomDatabase {
    public abstract EventDao eventDao();
}
