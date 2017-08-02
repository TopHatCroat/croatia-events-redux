package cf.varazdinevents.croatiaevents.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by antonio on 27/07/17.
 */

@Dao
public interface EventDao {
    @Query("SELECT * FROM events")
    Single<List<EventEntity>> getAllEvents();

    @Query("SELECT * FROM events where id = :id")
    Single<EventEntity> getEventById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EventEntity entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<EventEntity> entity);

    @Query("SELECT COUNT(id) FROM events WHERE api_id = :apiId")
    Integer count(int apiId);
}
