package cf.varazdinevents.croatiaevents.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import io.reactivex.Flowable;

/**
 * Created by antonio on 27/07/17.
 */

@Dao
public interface EventDao {
    @Query("SELECT * FROM events")
    Flowable<EventEntity> getAllEvents();
}
